package br.com.camel.service;

import org.apache.camel.ProducerTemplate;

import br.com.camel.domain.CamelDomain;
import br.com.camel.processor.CamelProcessor;
import br.com.camel.router.CamelContextWrapper;
import br.com.camel.router.CamelRouter;

//@Service
public class CamelService {

	private final ProducerTemplate template;
	
	public CamelService(CamelContextWrapper wrapper) {
		template = wrapper.createProducerTemplate();
	}

	public void serviceOperation(CamelDomain domain) {
		System.out.println("inicio");
		System.out.println(template);
		//template.request(CamelRouter.GET_ROUTE, new CamelProcessor());
		template.requestBody(CamelRouter.GET_ROUTE, domain, CamelDomain.class);
		System.out.println("fim");
		
	}

}
