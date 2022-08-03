package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.AccountType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountTypeDao extends ReactiveMongoRepository<AccountType, String> {
    public Mono<AccountType> findByDescription(String description);
}
