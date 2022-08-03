package com.bootcamp26.webflux.apirest.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection="accounts")
public class Account {

    @Id
    private String id;

    @Valid
    @NotNull
    private DocumentType documentType;

    @Valid
    @NotNull
    private Person person;

    @NotEmpty
    private String accountNumber;

    @NotEmpty
    private String cardNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateExpires;

    @NotNull
    private Double lineAvailable;

    @NotNull
    private Double balanceAvailable;

    @NotNull
    private Integer state;

    public Account() {
    }

    public Account(String accountNumber, String cardNumber, Date dateExpires, Double lineAvailable, Double balanceAvailable, Integer state) {
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.dateExpires = dateExpires;
        this.lineAvailable = lineAvailable;
        this.balanceAvailable = balanceAvailable;
        this.state = state;
    }

    public Account(DocumentType documentType, Person person, String accountNumber, String cardNumber, Date dateExpires, Double lineAvailable, Double balanceAvailable, Integer state) {

        this.documentType = documentType;
        this.person = person;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.dateExpires = dateExpires;
        this.lineAvailable = lineAvailable;
        this.balanceAvailable = balanceAvailable;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getDateExpires() {
        return dateExpires;
    }

    public void setDateExpires(Date dateExpires) {
        this.dateExpires = dateExpires;
    }

    public Double getLineAvailable() {
        return lineAvailable;
    }

    public void setLineAvailable(Double lineAvailable) {
        this.lineAvailable = lineAvailable;
    }

    public Double getBalanceAvailable() {
        return balanceAvailable;
    }

    public void setBalanceAvailable(Double balanceAvailable) {
        this.balanceAvailable = balanceAvailable;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
