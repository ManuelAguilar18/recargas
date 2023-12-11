package com.recargas.plan.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recargas.dto.TipoPlan;
import com.recargas.entity.BusquedaPlanEntity;
import com.recargas.plan.repository.TipoPlanRepositry;
import com.recargas.plan.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService{
	
	private final static Logger log = Logger.getLogger(PlanServiceImpl.class); 
	
	@Autowired
	private TipoPlanRepositry tipoPlanRepositry;
	
	@Override
	public ResponseEntity<Object> postBuscarPlanes(BusquedaPlanEntity busqueda) {
		
		log.log(Level.INFO,"[Servicio buscar planes][inicio]");
		List<TipoPlan> tipoPlan = null;
		Map<String, String> errorMensaje = new HashMap<>();
		
		log.info("[El id de busqueda {}]" + busqueda.getId());
		log.info("Compania {}" + busqueda.getCompania());
		
		try {
			if (busqueda != null) {
				
				if (busqueda.getId() == 0 && busqueda.getCompania().isEmpty()) {
					tipoPlan = tipoPlanRepositry.findAll();
				}
				
				if (busqueda.getId() > 0 && busqueda.getCompania().isEmpty()) {
					tipoPlan = tipoPlanRepositry.findByIdPlan(busqueda.getId());	
				}
				
				if (busqueda.getId() == 0 && !busqueda.getCompania().isEmpty()) {
					tipoPlan = tipoPlanRepositry.findByCompania(busqueda.getCompania());	
				}
			}	
			
			if (tipoPlan == null || tipoPlan.isEmpty()) {
				errorMensaje.put("mensaje", "No se encuentra la infomación del plan");
				return ResponseEntity.status(HttpStatus.OK).body(errorMensaje);
			}
			
		} catch (Exception e) {
			log.error("Se genero una excepcio []" +e);
			errorMensaje.put("mensaje","Existe una falla en la comunicación del servicio");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		}
		
		
		log.info("[Servicio buscar planes][fin]");
		
		return ResponseEntity.status(HttpStatus.OK).body(tipoPlan);
	}

}
