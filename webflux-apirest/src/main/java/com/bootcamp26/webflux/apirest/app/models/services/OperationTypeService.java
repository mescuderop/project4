package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.OperationType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OperationTypeService {

    public Flux<OperationType> findAll();

    public Mono<OperationType> findById(String id);

    public Mono<OperationType> save(OperationType operationType);

    public Mono<Void> delete(OperationType operationType);

    public Mono<OperationType> findByDescription(String description);
}
