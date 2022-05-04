package com.bootcamp.enterprise.active.creditcard.service;

import com.bootcamp.enterprise.active.creditcard.entity.EnterpriseCreditCard;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EnterpriseCreditCardService {

    public Flux<EnterpriseCreditCard> getAll();

    public Mono<EnterpriseCreditCard> getById(String id);

    public Mono<EnterpriseCreditCard> save(EnterpriseCreditCard enterpriseCreditCard);

    public Mono<EnterpriseCreditCard> update(EnterpriseCreditCard enterpriseCreditCard);

    public Mono<EnterpriseCreditCard> delete(String id);

    Mono<EnterpriseCreditCard> getByIdClient(String idClient);

}