package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import com.bootcamp26.webflux.apirest.app.models.documents.DocumentType;
import com.bootcamp26.webflux.apirest.app.models.documents.PersonType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {

    public Flux<Person> findAll();

    public Mono<Person> findById(String id);

    public Mono<Person> save(Person person);

    public Mono<Void> delete(Person person);


    public Mono<Person> findByDocumentNumber(String documentNumber);


    public Flux<PersonType> findAllPersonType();

    public Mono<PersonType> findPersonTypeById(String id);

    public Mono<PersonType> savePersonType(PersonType personType);

    public Mono<PersonType> findPersonTypeByDescription(String description);

}
