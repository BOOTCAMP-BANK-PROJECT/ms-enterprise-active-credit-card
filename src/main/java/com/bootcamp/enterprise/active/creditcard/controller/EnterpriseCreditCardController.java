package com.bootcamp.enterprise.active.creditcard.controller;

import com.bootcamp.enterprise.active.creditcard.entity.EnterpriseCreditCard;
import com.bootcamp.enterprise.active.creditcard.service.EnterpriseCreditCardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("personal/active/credit_card")
@Tag(name = "Personal Active Credit Card", description = "Manage Personal Active Credit Cards accounts")
@CrossOrigin(value = {"*"})
@RequiredArgsConstructor
public class EnterpriseCreditCardController {

    public final EnterpriseCreditCardService service;

    @GetMapping
    public Mono<ResponseEntity<Flux<EnterpriseCreditCard>>> getAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getAll())
        );
    }

    @GetMapping("/{idClient}")
    public Mono<ResponseEntity<Mono<EnterpriseCreditCard>>> getByIdClient(@PathVariable String idClient) {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getByIdClient(idClient))
        );
    }

    @GetMapping("/{idEnterpriseCreditCard}")
    public Mono<ResponseEntity<Mono<EnterpriseCreditCard>>> getByIdEnterpriseCreditCard(@PathVariable String idEnterpriseCreditCard) {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.getById(idEnterpriseCreditCard))
        );
    }

    @PostMapping
    public Mono<ResponseEntity<EnterpriseCreditCard>> create(@RequestBody EnterpriseCreditCard enterpriseCreditCard) {

        return service.save(enterpriseCreditCard).map(p -> ResponseEntity
                .created(URI.create("/EnterpriseCreditCard/".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p)
        );
    }

    @PutMapping
    public Mono<ResponseEntity<EnterpriseCreditCard>> update(@RequestBody EnterpriseCreditCard enterpriseCreditCard) {
        return service.update(enterpriseCreditCard)
                .map(p -> ResponseEntity.created(URI.create("/EnterpriseCreditCard/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public Mono<ResponseEntity<EnterpriseCreditCard>> delete(@RequestBody String id) {
        return service.delete(id)
                .map(p -> ResponseEntity.created(URI.create("/EnterpriseCreditCard/"
                                .concat(p.getId())
                        ))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
