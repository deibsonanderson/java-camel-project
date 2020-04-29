package br.com.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.camel.domain.CamelDomain;
import br.com.camel.exception.InvalidMountException;
import br.com.camel.exception.InvalidNumberException;
import br.com.camel.exception.InvalidYearException;

public class CamelValidate implements Processor {


	Logger logger = LoggerFactory.getLogger(CamelValidate.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("camelValidate - start");

		CamelDomain domain = exchange.getIn().getBody(CamelDomain.class);

		validMount(toNumber(domain.getMount()));
		validYear(toNumber(domain.getYear()));

		exchange.getMessage().setBody(domain);
		logger.info("camelValidate - end");

	}

	private void validYear(int year) throws InvalidYearException {
		if (year < 1900 || year > 2500) {
			throw new InvalidYearException("invalid year");
		}
	}

	private void validMount(int mount) throws InvalidMountException {
		if (mount < 1 || mount > 12) {
			throw new InvalidMountException("invalid mount");
		}
	}

	private int toNumber(String value) throws InvalidNumberException {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			throw new InvalidNumberException("invalid number");
		}
	}

}
