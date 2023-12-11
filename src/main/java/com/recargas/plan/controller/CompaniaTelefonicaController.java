/**
 * 
 */
package com.recargas.plan.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recargas.plan.service.CompaniaService;

/**
 * 
 */
@RestController
@RequestMapping("/compania")
public class CompaniaTelefonicaController {

	private final static Logger log = Logger.getLogger(CompaniaTelefonicaController.class);
	
	@Autowired
	CompaniaService companiaService;
	
	@GetMapping(value = "/telefonicas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getCompania() {
		
		log.debug("[getCompania][inicio]");
		
		ResponseEntity<Object> objCom = companiaService.getCompania();
				
		log.debug("[getCompania][fin]");
		
		return objCom;
	}
}
