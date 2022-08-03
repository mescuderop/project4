package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.PersonType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonTypeDao extends ReactiveMongoRepository<PersonType, String>  {

    public Mono<PersonType> findByDescription(String description);

}
