/**
 * 
 */
package com.recargas.plan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargas.entity.BusquedaPlanEntity;
import com.recargas.plan.service.PlanService;


/**
 * 
 */
@RestController
@RequestMapping("/planes")
public class PlanController {
	
	private final static Logger log = Logger.getLogger(PlanController.class);
	
	@Autowired
	PlanService planService;
	
	@PostMapping(value = "/plan", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> postBuscarPlanes(@RequestBody BusquedaPlanEntity busqueda) {
		
		log.debug("[Busqueda de planes][inicio]");
		
		ResponseEntity<Object> objPlan = planService.postBuscarPlanes(busqueda); 
		
		log.debug("[Busqueda de planes][fin]");
		
		return objPlan;
	}
}
