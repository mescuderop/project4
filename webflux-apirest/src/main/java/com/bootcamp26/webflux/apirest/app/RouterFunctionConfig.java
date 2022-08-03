package com.bootcamp26.webflux.apirest.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bootcamp26.webflux.apirest.app.handler.PersonHandler;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterFunctionConfig {

	@Bean
	public RouterFunction<ServerResponse> routes(PersonHandler handler){
		
		return route(GET("/api/v2/persons").or(GET("/api/v3/persons")), handler::listar)
				.andRoute(GET("/api/v2/persons/{id}"), handler::ver)
				.andRoute(POST("/api/v2/persons"), handler::crear)
				.andRoute(PUT("/api/v2/persons/{id}"), handler::editar)
				.andRoute(DELETE("/api/v2/persons/{id}"), handler::eliminar);
	}

}
