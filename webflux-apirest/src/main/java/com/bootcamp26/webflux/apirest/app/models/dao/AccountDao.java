package com.bootcamp26.webflux.apirest.app.models.dao;

import com.bootcamp26.webflux.apirest.app.models.documents.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface AccountDao extends ReactiveMongoRepository<Account, String> {

    public Mono<Account> findByAccountNumber(String accountNumber);
}
