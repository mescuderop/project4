package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.PersonType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonTypeService {
    public Flux<PersonType> findAll();

    public Mono<PersonType> findById(String id);

    public Mono<PersonType> save(PersonType personType);

    public Mono<Void> delete(PersonType personType);

    public Mono<PersonType> findByDescription(String description);
}
