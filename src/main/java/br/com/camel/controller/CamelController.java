package br.com.camel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.camel.domain.CamelDomain;
import br.com.camel.service.CamelService;

@RestController
public class CamelController {

	@Autowired
	CamelService service;

	@GetMapping(value = { "/camel" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> camel() throws Exception {
		CamelDomain domain = br.com.camel.domain.CamelDomain.builder()
															.id("1")
															.name("fulane")
															.build();
		service.serviceOperation(domain);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
