package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.AccountType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountTypeService {

    public Flux<AccountType> findAll();

    public Mono<AccountType> findById(String id);

    public Mono<AccountType> save(AccountType accountType);

    public Mono<Void> delete(AccountType accountType);

    public Mono<AccountType> findByDescription(String description);
}
