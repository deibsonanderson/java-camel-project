package br.com.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.camel.router.CamelContextWrapper;
import br.com.camel.router.CamelRouter;
import br.com.camel.service.CamelService;

@SpringBootApplication
public class JavaCamelProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaCamelProjectApplication.class, args);
	}
	
	@Bean
	public CamelContextWrapper camelContextWrapper(RouteBuilder ... routes) throws Exception{
		return new CamelContextWrapper(routes);
	}
	
	@Bean
	public CamelService camelService(CamelContextWrapper camelContextWrapper) throws Exception{
		return new CamelService(camelContextWrapper);
	}
	
	@Bean
	public CamelRouter camelRouter() throws Exception{
		return new CamelRouter();
	}
	
	

}
