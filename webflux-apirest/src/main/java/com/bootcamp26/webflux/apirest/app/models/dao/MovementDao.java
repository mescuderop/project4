package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.Movement;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface MovementDao extends ReactiveMongoRepository<Movement, String> {

    public Mono<Movement> findByAccountNumber(String accountNumber);
}
