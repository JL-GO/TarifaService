package spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dto.TarifaDto;
import spring.entity.Tarifa;
import spring.repository.TarifaRepository;

@Service
public class TarifaService {

	@Autowired
	TarifaRepository tarifaRepository;

	public TarifaDto obtenerTarifa(Date fecha,Integer idproducto, Integer cadena) {

		List<Tarifa> tarifasFin = tarifaRepository.findByStartDateLessThanEqualAndCompanyAndProductId(fecha,cadena,idproducto);
		List<Tarifa> tarifasInicio = tarifaRepository.findByEndDateGreaterThanEqualAndCompanyAndProductId(fecha,cadena,idproducto);
		Integer prioridad =0;	
		Tarifa TarifaPrioritaria=new Tarifa();		
		
		for (Tarifa tarifa : tarifasInicio) {			
			if(tarifasFin.contains(tarifa) && tarifa.getPriority() >= prioridad) {
					prioridad=tarifa.getPriority();
					TarifaPrioritaria = tarifa;	
			}
		}	
		TarifaDto tarifaDto = new TarifaDto();
		BeanUtils.copyProperties(TarifaPrioritaria, tarifaDto);
		return tarifaDto;
	}
}

