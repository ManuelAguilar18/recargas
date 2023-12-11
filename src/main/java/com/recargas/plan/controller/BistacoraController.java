package com.recargas.plan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargas.entity.BusquedaBitacoraEntity;
import com.recargas.plan.service.BitacoraService;

@RestController
@RequestMapping("/bitacora")
public class BistacoraController {

	private final static Logger log = Logger.getLogger(BistacoraController.class);
	
	@Autowired
	BitacoraService bitacoraService;
	
	@PostMapping(value = "/busquedaFecha", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> postBusquedaFecha(@RequestBody BusquedaBitacoraEntity busqueda){
		
		log.debug("[Busqueda bitacora fechas][inicio]");
		
		ResponseEntity<Object> objPlan = bitacoraService.postBusquedaFecha(busqueda); 
		
		log.debug("[Busqueda bitacora fechas][fin]");
		
		
		return objPlan;
	}
	

	@PostMapping(value = "/busquedaNumero", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> putCompraPlan(@RequestBody BusquedaBitacoraEntity busqueda){
		
		log.debug("[Busqueda bitacora compania][inicio]");
		
		ResponseEntity<Object> objPlan = bitacoraService.postBusquedaCompania(busqueda); 
		
		log.debug("[Busqueda bitacora compania][fin]");
		
		
		return objPlan;
	}
}
