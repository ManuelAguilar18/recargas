/**
 * 
 */
package com.recargas.plan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargas.entity.CompraPlanEntity;
import com.recargas.plan.service.CompraPlanService;

/**
 * 
 */
@RestController
@RequestMapping("/pago")
public class CompraPlanController {

	private final static Logger log = Logger.getLogger(CompaniaTelefonicaController.class);
	
	/**
	 * 
	 */
	@Autowired
	private CompraPlanService compraPlanService;
	
	@PutMapping(value = "/plan", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> putCompraPlan(@RequestBody CompraPlanEntity compra){
		
		log.debug("[Compra de planes][inicio]");
		
		ResponseEntity<Object> objPlan = compraPlanService.putCompraPlan(compra); 
		
		log.debug("[Compra de planes][fin]");
		
		
		return objPlan;
	}
	
}
