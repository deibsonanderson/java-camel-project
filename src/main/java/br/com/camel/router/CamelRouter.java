package br.com.camel.router;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.camel.client.TimeDaysProxy;
import br.com.camel.processor.CamelProcessor;
import br.com.camel.processor.CamelValidate;
import br.com.camel.service.CamelService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CamelRouter extends RouteBuilder {
	
	Logger logger = LoggerFactory.getLogger(CamelRouter.class);
	
	public static final String GET_ROUTE = "direct:get-getTimes";
	public static final String VAL_ROUTE = "direct:get-valitateTime";
	
	@Autowired
	private TimeDaysProxy proxy;
	
	@Override
	public void configure() throws Exception {
		logger.info("router - start");
		from(GET_ROUTE)
			.setProperty("camelDomain", body())
			.to(VAL_ROUTE)
			.log("validate success")
			.log("get proxy dateTimes")
			.bean(proxy, "getDateTimes(${body.mount}, ${body.year})")
			.process(new CamelProcessor());
			
		from(VAL_ROUTE)
			.log("Validate domain")
			.process(new CamelValidate());
		logger.info("router - end");
	}

}
