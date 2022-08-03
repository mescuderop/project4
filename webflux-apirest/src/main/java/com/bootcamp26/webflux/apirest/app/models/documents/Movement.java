package com.bootcamp26.webflux.apirest.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection="movements")
public class Movement {


    @Id
    private String id;
    @NotNull
    private Double amount;

    @Valid
    @NotNull
    private OperationType operationType;

    @Valid
    @NotNull
    private Account account;

    @NotEmpty
    private String accountNumber;
    @NotEmpty
    private String documentNumber;

    @NotNull
    private Integer state;

    public Movement() {
    }

    public Movement(Double amount, String accountNumber, String documentNumber, Integer state) {
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.documentNumber = documentNumber;
        this.state = state;
    }

    public Movement(Double amount, OperationType operationType, Account account, String accountNumber, String documentNumber, Integer state) {
        this.amount = amount;
        this.operationType = operationType;
        this.account = account;
        this.accountNumber = accountNumber;
        this.documentNumber = documentNumber;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
