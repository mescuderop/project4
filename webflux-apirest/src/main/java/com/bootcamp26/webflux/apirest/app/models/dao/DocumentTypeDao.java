package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.DocumentType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DocumentTypeDao extends ReactiveMongoRepository<DocumentType, String> {
    public Mono<DocumentType> findByDescription(String description);

}
