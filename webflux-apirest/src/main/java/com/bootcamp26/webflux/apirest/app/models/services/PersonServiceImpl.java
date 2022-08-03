package com.bootcamp26.webflux.apirest.app.models.services;

import com.bootcamp26.webflux.apirest.app.models.dao.DocumentTypeDao;
import com.bootcamp26.webflux.apirest.app.models.dao.PersonDao;
import com.bootcamp26.webflux.apirest.app.models.dao.PersonTypeDao;
import com.bootcamp26.webflux.apirest.app.models.documents.DocumentType;
import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import com.bootcamp26.webflux.apirest.app.models.documents.PersonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao dao;

    @Autowired
    private DocumentTypeDao documentTypeDao;

    @Autowired
    private PersonTypeDao personTypeDao;

    @Override
    public Flux<Person> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Person> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Mono<Person> save(Person person) {
        return dao.save(person);
    }

    @Override
    public Mono<Void> delete(Person person) {
        return dao.delete(person);
    }

    /*
    @Override
    public Flux<DocumentType> findAllDocumentType() {
        return null;
    }

    @Override
    public Mono<DocumentType> findDocumentTypeById(String id) {
        return null;
    }

    @Override
    public Mono<DocumentType> saveDocumentType(DocumentType documentType) {
        return null;
    }
*/
    @Override
    public Mono<Person> findByDocumentNumber(String documentNumber) {
        return null;
    }

/*
    @Override
    public Mono<DocumentType> findDocumentTypeByDescription(String description) {
        return null;
    }
*/

    @Override
    public Flux<PersonType> findAllPersonType() {
        return personTypeDao.findAll();
    }

    @Override
    public Mono<PersonType> findPersonTypeById(String id) {
        return personTypeDao.findById(id);
    }

    @Override
    public Mono<PersonType> savePersonType(PersonType personType) {
        return personTypeDao.save(personType);
    }

    //@Override
    //public Mono<Person> findByName(String name) {
    //    return dao.obtenerPorNombre(name);
    //}

    @Override
    public Mono<PersonType> findPersonTypeByDescription(String description) {
        return personTypeDao.findByDescription(description);
    }


}
