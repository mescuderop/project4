package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.Movement;
import com.bootcamp26.webflux.apirest.app.models.documents.OperationType;
import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
    public Flux<Movement> findAll();

    public Mono<Movement> findById(String id);

    public Mono<Movement> save(Movement movement);

    public Mono<Void> delete(Movement movement);

    public Flux<OperationType> findAllOperationType();

    public Mono<OperationType> findAccountTypeById(String id);

    public Mono<OperationType> saveOperationType(OperationType operationType);

    public Mono<Movement> findByAccountNumber(String accountNumber);

    public Mono<OperationType> findOperationTypeByDescription(String description);

    public Flux<Person> findAllPerson();

    public Mono<Person> findPersonById(String id);

    public Mono<Person> savePerson(Person person);

    public Mono<Person> findPersonByDocumentNumber(String documentNumber);
}
