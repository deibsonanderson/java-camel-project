package br.com.camel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.camel.client.TimeDays;
import br.com.camel.client.TimeDaysProxy;
import br.com.camel.domain.CamelDomain;
import br.com.camel.service.CamelService;

@RestController
public class CamelController {

	Logger logger = LoggerFactory.getLogger(CamelController.class);
	
	@Autowired
	CamelService service;

	@Autowired
	TimeDaysProxy proxy;
	
	
	@GetMapping(value = { "/camel/{mount}/{year}" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeDays> camel(@PathVariable("mount") String mount, @PathVariable("year") String year)
			throws Exception {
		logger.info("contoller - start");
		CamelDomain domain = br.com.camel.domain.CamelDomain.builder().year(year).mount(mount).build();
		logger.info("contoller - end");
		return ResponseEntity.status(HttpStatus.OK).body(service.serviceOperation(domain));
	}
}
