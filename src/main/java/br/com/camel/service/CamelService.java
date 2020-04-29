package br.com.camel.service;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.camel.client.TimeDays;
import br.com.camel.domain.CamelDomain;
import br.com.camel.router.CamelContextWrapper;
import br.com.camel.router.CamelRouter;


public class CamelService {
	
	Logger logger = LoggerFactory.getLogger(CamelService.class);
	
	private final ProducerTemplate template;

	public CamelService(CamelContextWrapper wrapper) {
		template = wrapper.createProducerTemplate();
	}

	public TimeDays serviceOperation(CamelDomain camelDomain) {
		logger.info("service - start");
		CamelDomain response = template.requestBody(CamelRouter.GET_ROUTE, camelDomain, CamelDomain.class);
		logger.info("service - end");
		return response.getTime();
	}

}
