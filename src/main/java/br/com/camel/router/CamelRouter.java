package br.com.camel.router;

import org.apache.camel.builder.RouteBuilder;

import br.com.camel.processor.CamelProcessor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class CamelRouter extends RouteBuilder {

	public static final String GET_ROUTE = "direct:get-getCamel";
	public static final String VAL_ROUTE = "direct:get-valCamel";
	
	
	@Override
	public void configure() throws Exception {
		System.out.println("rota");
		from(GET_ROUTE)
		//.setProperty("camelDomain", body())
		.process(new CamelProcessor());
		//.to(VAL_ROUTE)
		//.end();
		
		
		//from(VAL_ROUTE)
		//.process(Ca );
		
	}

}
