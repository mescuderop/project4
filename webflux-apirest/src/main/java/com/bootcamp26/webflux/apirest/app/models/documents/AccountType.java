package com.bootcamp26.webflux.apirest.app.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collection = "accountTypes")
public class AccountType {

    @Id
    @NotEmpty
    private String id;

    private String description;

    public AccountType() {
    }

    public AccountType(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
