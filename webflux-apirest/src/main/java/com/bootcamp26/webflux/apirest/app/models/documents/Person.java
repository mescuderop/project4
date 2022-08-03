package com.bootcamp26.webflux.apirest.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection="persons")
public class Person {

    @Id
    private String id;

    @NotEmpty
    private String documentType;

    @NotEmpty
    private String documentNumber;

    @NotEmpty
    private String name;

    @Valid
    @NotNull
    private PersonType personType;

    @NotEmpty
    private String address;

    @NotEmpty
    private String phone;

    @NotEmpty
    private String email;

    @NotNull
    private Integer state;

    public Person() {
    }

    public Person(String documentType, String documentNumber, String name, String address, String phone, String email, Integer state) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.state = state;
    }

    public Person(String documentType, String documentNumber, String name, PersonType personType, String address, String phone, String email, Integer state) {

        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.name = name;
        this.personType = personType;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.state = state;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
