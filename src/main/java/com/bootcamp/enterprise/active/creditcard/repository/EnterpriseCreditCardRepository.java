package com.bootcamp.enterprise.active.creditcard.repository;

import com.bootcamp.enterprise.active.creditcard.entity.EnterpriseCreditCard;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface EnterpriseCreditCardRepository extends ReactiveMongoRepository<EnterpriseCreditCard, String> {

    Mono<EnterpriseCreditCard> findByIdClient(String idClient);
}