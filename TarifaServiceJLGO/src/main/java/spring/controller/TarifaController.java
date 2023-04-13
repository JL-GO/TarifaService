package spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.dto.TarifaDto;
import spring.service.TarifaService;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {

	@Autowired
	TarifaService tarifaService;
	
	@GetMapping
	public ResponseEntity<TarifaDto> obtenerTarifaPrioritaria(@RequestParam String fecha, Integer idproducto, Integer cadena ) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			Date date = dateFormat.parse(fecha);
			return new ResponseEntity<TarifaDto>(tarifaService.obtenerTarifa(date,idproducto,cadena),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}

