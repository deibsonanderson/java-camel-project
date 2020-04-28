package br.com.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelProcessor implements Processor {

	@Override
    public void process(Exchange exchange) throws Exception {
		System.out.println("process");
		//System.out.println(exchange.getIn().getBody(String.class));
    }
    
}