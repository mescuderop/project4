package com.bootcamp26.webflux.apirest.app;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import com.bootcamp26.webflux.apirest.app.models.documents.PersonType;
import com.bootcamp26.webflux.apirest.app.models.services.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;

import reactor.core.publisher.Mono;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebfluxApirestApplicationTests {

	@Autowired
	private WebTestClient client;
	
	@Autowired
	private PersonService service;

	@Value("${config.base.endpoint}")
	private String url;


	@Test
	public void listarTest() {
		
		client.get()
		.uri("/api/v2/persons")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(Person.class)
		.consumeWith(response -> {
			List<Person> persons = response.getResponseBody();
			persons.forEach(p -> {
				System.out.println(p.getName());
			});
			
			//Assertions.assertThat(persons.size()>0).isTrue();
		})
				.isEqualTo(null);
		//.hasSize(9);
	}
		
	@Test
	public void crearTest() {
		
		PersonType personType = service.findPersonTypeByDescription("Persona Natural").block();
		
		Person person = new Person("Dni", "10000345", "CARLOS GOMEZ LEON", personType, "CALLE TEST 123", "98245455", "", 1);
		
		client.post().uri(url)
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(person), Person.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.person.id").isNotEmpty()
		.jsonPath("$.person.documentType").isEqualTo("Dni")
		.jsonPath("$.person.documentNumber").isEqualTo("10000345")
		.jsonPath("$.person.name").isEqualTo("CARLOS GOMEZ LEON")
		.jsonPath("$.person.personType.description").isEqualTo("Persona Natural");
	}

	@Test
	public void crear2Test() {
		
		PersonType personType = service.findPersonTypeByDescription("Persona Natural").block();
		
		Person person = new Person("Dni", "10000345", "CARLOS GOMEZ LEON", personType, "CALLE TEST 123", "98245455", "", 1);
		
		
		client.post().uri(url)
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(person), Person.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody(new ParameterizedTypeReference<LinkedHashMap<String, Object>>() {})
		.consumeWith(response -> {
			Object o = response.getResponseBody().get("producto");
			Person p = new ObjectMapper().convertValue(o, Person.class);
			
			//System.out.println(p.getId() + " - " + p.getDocumentNumber() + " - " + p.getName());
			
			//Assertions.assertThat(p.getId()).isNotEmpty();
			//Assertions.assertThat(p.getNombre()).isEqualTo("Mesa comedor");
			//Assertions.assertThat(p.getCategoria().getNombre()).isEqualTo("Muebles");
		});
	}
	
	@Test
	public void editarTest() {
		
		Person person = service.findByDocumentNumber("41410345").block();
		PersonType personType = service.findPersonTypeByDescription("Persona Natural").block();
		
		Person personEdit = new Person("Dni", "10022345", "CARLOS GOMEZ GOMEZ", personType, "CALLE TEST 123", "98245455", "", 1);
		
		client.put().uri(url + "/{id}", Collections.singletonMap("id", person.getId()))
		.contentType(MediaType.APPLICATION_JSON_UTF8)
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.body(Mono.just(personEdit), Person.class)
		.exchange()
		.expectStatus().isCreated()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()		
		.jsonPath("$.id").isNotEmpty()
		//.jsonPath("$.documentType").isEqualTo("Dni")
		//.jsonPath("$.documentNumber").isEqualTo("10022345")
		//.jsonPath("$.name").isEqualTo("CARLOS GOMEZ GOMEZ")
		.jsonPath("$.personType.description").isEqualTo("Persona Natural");
		
	}

	@Test
	public void eliminarTest() {
		Person person = service.findById("62e7a14ffeaeec14a10b9d54").block();
		client.delete()
		.uri(url + "/{id}", Collections.singletonMap("id", person.getId()))
		.exchange()
		.expectStatus().isNoContent()
		.expectBody()
		.isEmpty();
		
		//client.get()
		//.uri(url + "/{id}", Collections.singletonMap("id", person.getId()))
		//.exchange()
		//.expectStatus().isNotFound()
		//.expectBody()
		//.isEmpty();
	}
}
