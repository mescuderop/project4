package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonDao extends ReactiveMongoRepository<Person, String> {

    public Mono<Person> findByDocumentNumber(String documentNumber);
}
