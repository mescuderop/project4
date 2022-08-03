package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.OperationType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface OperationTypeDao extends ReactiveMongoRepository<OperationType, String> {
    public Mono<OperationType> findByDescription(String description);
}
