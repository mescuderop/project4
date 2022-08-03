package com.bootcamp26.webflux.apirest.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static org.springframework.web.reactive.function.BodyInserters.*;

import java.net.URI;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import com.bootcamp26.webflux.apirest.app.models.services.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {


	@Autowired
	private PersonService service;
		
	@Autowired
	private Validator validator;
	

	public Mono<ServerResponse> listar(ServerRequest request){
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.findAll(), Person.class);
	}
	
	public Mono<ServerResponse> ver(ServerRequest request){
		
		String id = request.pathVariable("id");
		return service.findById(id).flatMap( p -> ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(fromObject(p)))
				.switchIfEmpty(ServerResponse.notFound().build());
	}
	
	public Mono<ServerResponse> crear(ServerRequest request){
		Mono<Person> person = request.bodyToMono(Person.class);
		
		return person.flatMap(p -> {
			
			Errors errors = new BeanPropertyBindingResult(p, Person.class.getName());
			validator.validate(p, errors);
			
			if(errors.hasErrors()) {
				return Flux.fromIterable(errors.getFieldErrors())
						.map(fieldError -> "El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage())
						.collectList()
						.flatMap(list -> ServerResponse.badRequest().body(fromObject(list)));
			} else {
				//if(p.getCreateAt() ==null) {
				//	p.setCreateAt(new Date());
				//}
				return service.save(p).flatMap(pdb -> ServerResponse
						.created(URI.create("/api/v2/persons/".concat(pdb.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(fromObject(pdb)));
			}
			
		});
	}
	
	public Mono<ServerResponse> editar(ServerRequest request){
		Mono<Person> person = request.bodyToMono(Person.class);
		String id = request.pathVariable("id");
		
		Mono<Person> personDb = service.findById(id);
		
		return personDb.zipWith(person, (db, req) ->{			
			db.setDocumentType(req.getDocumentType());
			db.setDocumentNumber(req.getDocumentNumber());
			db.setName(req.getName());
			db.setPersonType(req.getPersonType());
			db.setAddress(req.getAddress());
			db.setPhone(req.getPhone());
			db.setEmail(req.getEmail());
			db.setState(req.getState());
            
			return db;
		}).flatMap(p -> ServerResponse.created(URI.create("/api/v2/persons/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.save(p), Person.class))
		.switchIfEmpty(ServerResponse.notFound().build());
		
	}
	
	public Mono<ServerResponse> eliminar(ServerRequest request){
		String id = request.pathVariable("id");
		
		Mono<Person> personDb = service.findById(id);
		
		return personDb.flatMap(p-> service.delete(p).then(ServerResponse.noContent().build()))
				.switchIfEmpty(ServerResponse.notFound().build());
		
	}
	
}
