package com.bootcamp26.webflux.apirest.app;

import com.bootcamp26.webflux.apirest.app.models.documents.Person;
import com.bootcamp26.webflux.apirest.app.models.documents.PersonType;
import com.bootcamp26.webflux.apirest.app.models.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WebfluxApirestApplication implements CommandLineRunner {

	@Autowired
	private PersonService service;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	private static final Logger log = LoggerFactory.getLogger(WebfluxApirestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("persons").subscribe();
		//mongoTemplate.dropCollection("documentTypes").subscribe();
		mongoTemplate.dropCollection("personTypes").subscribe();

		//DocumentType dni = new DocumentType("Dni");
		//DocumentType ruc = new DocumentType("ruc");

		PersonType personaNatural = new PersonType("Persona Natural");
		PersonType personaJuridica = new PersonType("Persona Juridica");

		Flux.just(personaNatural, personaJuridica)
				.flatMap(service::savePersonType)
				.doOnNext(c ->{
					log.info("Tipo de Persona creada: " + c.getDescription() + ", Id: " + c.getId());
				}).thenMany(
						Flux.just(new Person( "Dni", "41410345", "JUAN PEREZ PEREZ", personaNatural, "CALLE 28 DE JULIO 23", "624684684", "", 1 ),
									new	Person( "Ruc", "20414103450", "REPRESENTACIONES ABC", personaJuridica, "AV. METROPOLITANA", "92857285", "", 1),
									new	Person( "Dni", "41410340", "CARLOS RAMIREZ SANDOVAL", personaNatural, "CALLE HUSARES DE JUNIN 345", "97655643", "", 1)
								)
								.flatMap(person -> {
									return service.save(person);
								})
				)
				.subscribe(person -> log.info("Insert: " + person.getId() + " " + person.getName()));

	}
}
