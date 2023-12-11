/**
 * 
 */
package com.recargas.plan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recargas.dto.Compania;
import com.recargas.plan.repository.PlanReponsitory;
import com.recargas.plan.service.CompaniaService;
import com.recargas.propiedades.Configuracion;

import lombok.Setter;

/**
 * 
 */
@Service
public class CompaniaServiceImpl implements CompaniaService{

	private final static Logger log = Logger.getLogger(CompaniaServiceImpl.class);
	
	@Setter (onMethod=@__(@Autowired))
	private Configuracion config;
	
	/**
	 * 
	 */
	@Autowired
	private PlanReponsitory planReponsitory;


	@Override
	public ResponseEntity<Object> getCompania() {
		
		log.info("[Service getCompania][inicio]");
		
		Map<String, String> errorMensaje = new HashMap<>();
		
		List<Compania> lstCom = new ArrayList<>();
		
		try {
			lstCom = planReponsitory.findAll();
			
			if (lstCom.size() > 0) {
				log.info("La lista compania tiene [] " + lstCom.size());
				return ResponseEntity.status(HttpStatus.OK).body(lstCom);
			}else {
				log.info("La lista compania tiene [] " + lstCom.size());
				errorMensaje.put("codigo", config.getCode_206());
				errorMensaje.put("mensaje", "La lista contiene "+lstCom.size());
				return ResponseEntity.status(HttpStatus.OK).body(errorMensaje);
			}		
			
		} catch (Exception e) {
			
			log.error("[Service getCompania][error] " + e);
			errorMensaje.put("codigo", config.getCode_200());
			errorMensaje.put("mensaje", config.getCode_206());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		}finally {
			log.info("[Service getCompania][Fin]");
		}
		
	}
	
	
	
}
