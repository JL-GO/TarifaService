package spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.service.TarifaService;

@SpringBootTest
class Tests {

	@Autowired
	TarifaService tarifaService;
	
	@Test
	void contextLoads() throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		Integer producto = 35455;
		Integer company = 1;
		Assertions.assertEquals(35.50,tarifaService.obtenerTarifa(dateFormat.parse("2020-06-14T10:00:00.000Z"), producto, company).getPrice());
		Assertions.assertEquals(25.45,tarifaService.obtenerTarifa(dateFormat.parse("2020-06-14T16:00:00.000Z"), producto, company).getPrice());
		Assertions.assertEquals(35.50,tarifaService.obtenerTarifa(dateFormat.parse("2020-06-14T21:00:00.000Z"), producto, company).getPrice());
		Assertions.assertEquals(30.50,tarifaService.obtenerTarifa(dateFormat.parse("2020-06-15T10:00:00.000Z"), producto, company).getPrice());
		Assertions.assertEquals(38.95,tarifaService.obtenerTarifa(dateFormat.parse("2020-06-16T21:00:00.000Z"), producto, company).getPrice());
	}
}
