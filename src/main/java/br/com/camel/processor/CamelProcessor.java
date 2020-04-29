package br.com.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.camel.client.TimeDays;
import br.com.camel.domain.CamelDomain;

public class CamelProcessor implements Processor {

	Logger logger = LoggerFactory.getLogger(CamelProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("camelProcessor - start");
		TimeDays t = exchange.getIn().getBody(TimeDays.class);
		
		CamelDomain d = (CamelDomain) exchange.getProperty("camelDomain");
		d.setTime(t);
		
		System.out.println("process: " + t.getTimeCurrent());
		exchange.getMessage().setBody(d);
		
		logger.info("camelProcessor - end");
	}

}