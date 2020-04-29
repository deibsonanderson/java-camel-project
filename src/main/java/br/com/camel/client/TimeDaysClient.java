package br.com.camel.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "pontos-api", url = "${client-url}")
public interface TimeDaysClient {

	@GetMapping(value="/pontos/api/", consumes = "application/json")
    TimeDays getDateTimes(@RequestParam(value="m", required = false) String m, @RequestParam(value="y", required = false) String y);

}