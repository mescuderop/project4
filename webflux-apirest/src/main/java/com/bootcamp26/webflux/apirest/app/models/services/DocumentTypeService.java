package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.DocumentType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DocumentTypeService {

    public Flux<DocumentType> findAll();

    public Mono<DocumentType> findById(String id);

    public Mono<DocumentType> save(DocumentType documentType);

    public Mono<Void> delete(DocumentType documentType);

    public Mono<DocumentType> findByDescription(String description);

}
