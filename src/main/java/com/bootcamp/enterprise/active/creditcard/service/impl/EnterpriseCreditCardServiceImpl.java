package com.bootcamp.enterprise.active.creditcard.service.impl;


import com.bootcamp.enterprise.active.creditcard.entity.EnterpriseCreditCard;
import com.bootcamp.enterprise.active.creditcard.entity.Movement;
import com.bootcamp.enterprise.active.creditcard.repository.EnterpriseCreditCardRepository;
import com.bootcamp.enterprise.active.creditcard.service.EnterpriseCreditCardService;
import com.bootcamp.enterprise.active.creditcard.service.WebClientService;
import com.bootcamp.enterprise.active.creditcard.util.Constant;
import com.bootcamp.enterprise.active.creditcard.util.handler.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class EnterpriseCreditCardServiceImpl implements EnterpriseCreditCardService {

    public final EnterpriseCreditCardRepository repository;

    public final WebClientService webClient;

    @Override
    public Flux<EnterpriseCreditCard> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<EnterpriseCreditCard> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<EnterpriseCreditCard> getByIdClient(String idClient) {
        return repository.findByIdClient(idClient);
    }

    @Override
    public Mono<EnterpriseCreditCard> save(EnterpriseCreditCard enterpriseEnterpriseCreditCard) {
        return repository.findByIdClient(enterpriseEnterpriseCreditCard.getIdClient())
                .map(sa -> {
                    throw new BadRequestException(
                            "ID",
                            "Client have one ore more enterpriseEnterpriseCreditCards",
                            sa.getId(),
                            EnterpriseCreditCardServiceImpl.class,
                            "save.onErrorResume"
                    );
                })
                .switchIfEmpty(Mono.defer(() -> {
                   /* webClient
                            .getWebClient()
                            .post()
                            .uri("/debtExpired/")
                            .bodyValue(enterpriseEnterpriseCreditCard.getIdClient())
                            .retrieve()
                            .bodyToMono(Boolean.class).flatMap(rs->rs==true);*/

                            enterpriseEnterpriseCreditCard.setId(null);
                            enterpriseEnterpriseCreditCard.setInsertionDate(new Date());
                            enterpriseEnterpriseCreditCard.setRegistrationStatus((short) 1);
                            return repository.save(enterpriseEnterpriseCreditCard).map(cc -> {
                                webClient
                                        .getWebClient()
                                        .post()
                                        .uri("movement")
                                        .bodyValue(generateCardLine(cc))
                                        .retrieve()
                                        .bodyToMono(Movement.class);
                                return cc;
                            });
                        }
                ))
                .onErrorResume(e -> Mono.error(e)).cast(EnterpriseCreditCard.class);
    }

    @Override
    public Mono<EnterpriseCreditCard> update(EnterpriseCreditCard enterpriseEnterpriseCreditCard) {

        return repository.findById(enterpriseEnterpriseCreditCard.getId())
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + enterpriseEnterpriseCreditCard.getId() + " was not found. >> switchIfEmpty")))
                .flatMap(p -> repository.save(enterpriseEnterpriseCreditCard))
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to update an item.",
                        e.getMessage(),
                        EnterpriseCreditCardServiceImpl.class,
                        "update.onErrorResume"
                )));
    }

    @Override
    public Mono<EnterpriseCreditCard> delete(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("An item with the id " + id + " was not found. >> switchIfEmpty")))
                .flatMap(p -> {
                    p.setRegistrationStatus(Constant.STATUS_INACTIVE);
                    return repository.save(p);
                })
                .onErrorResume(e -> Mono.error(new BadRequestException(
                        "ID",
                        "An error occurred while trying to delete an item.",
                        e.getMessage(),
                        EnterpriseCreditCardServiceImpl.class,
                        "update.onErrorResume"
                )));
    }

    private Movement generateCardLine(EnterpriseCreditCard enterpriseEnterpriseCreditCard) {
        return new Movement(null, enterpriseEnterpriseCreditCard.getCreditCardLine(),
                Constant.ID_BANK, enterpriseEnterpriseCreditCard.getId(), new Date(),
                enterpriseEnterpriseCreditCard.getIsoCurrencyCode(), Constant.CREATION_CARD, Constant.INITIAL_CARD,
                true, new Date(), enterpriseEnterpriseCreditCard.getFk_insertionUser(), enterpriseEnterpriseCreditCard.getInsertionTerminal(),
                enterpriseEnterpriseCreditCard.getRegistrationStatus());
    }

}