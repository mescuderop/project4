package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.documents.Account;
import com.bootcamp26.webflux.apirest.app.models.documents.AccountType;
import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

    public Flux<Account> findAll();

    public Mono<Account> findById(String id);

    public Mono<Account> save(Account account);

    public Mono<Void> delete(Account account);

    public Flux<AccountType> findAllAccountType();

    public Mono<AccountType> findAccountTypeById(String id);

    public Mono<AccountType> saveAccountType(AccountType accountType);

    public Mono<Account> findByAccountNumber(String accountNumber);

    public Mono<AccountType> findAccountTypeByDescription(String description);

    public Flux<Person> findAllPerson();

    public Mono<Person> findPersonById(String id);

    public Mono<Person> savePerson(Person person);

    public Mono<Person> findPersonByDocumentNumber(String documentNumber);

}
