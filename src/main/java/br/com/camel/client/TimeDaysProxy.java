package br.com.camel.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camel.client.TimeDays;
import br.com.camel.client.TimeDaysClient;

@Service
public class TimeDaysProxy {

	@Autowired
	TimeDaysClient client;

	public TimeDays getDateTimes(String mount, String year) {
		TimeDays result = null;
		try {
			result = client.getDateTimes(mount, year);
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
