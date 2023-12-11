package com.recargas.plan.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recargas.dto.BitacoraSearch;
import com.recargas.entity.BusquedaBitacoraEntity;
import com.recargas.plan.repository.BitacoraRepository;
import com.recargas.plan.repository.BitacoraSearchRepository;
import com.recargas.plan.service.BitacoraService;
import com.recargas.propiedades.Configuracion;

import lombok.Setter;

@Service
public class BitacoraServiceImpl implements BitacoraService{
	
	private final static Logger log = Logger.getLogger(BitacoraServiceImpl.class);
	
	@Setter (onMethod=@__(@Autowired))
	private Configuracion config;
	
	@Autowired
	BitacoraRepository bitacora;
	
	@Autowired
	BitacoraSearchRepository bitacoraRepository;

	@Override
	public ResponseEntity<Object> postBusquedaFecha(BusquedaBitacoraEntity busqueda) {
		
		Map<String, String> errorMensaje = new HashMap<>();
		
		log.info("[Metodo postBusquedaFecha][Inicio]");
		
		List<BitacoraSearch> lstBitacora = new ArrayList<>();
		
		Date fechaInicio = null;
		Date fechaFin = null;
		
		boolean fechas =false;
		
		try {
			log.info("[Validacion de fechas]");
			if (!busqueda.getFechaIncio().isEmpty() && !busqueda.getFechaFin().isEmpty()) {
				fechaInicio = convertirAFecha(busqueda.getFechaIncio());
				fechaFin = convertirAFecha(busqueda.getFechaFin());
				fechas = true;
			}else {
				errorMensaje.put("codigo", config.getCode_209());
				errorMensaje.put("mensaje", config.getMensaje_209());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
			}
			if (fechas== true) {
				log.info("[Busca informacion de fechas]");
				lstBitacora = bitacoraRepository.findFecha(fechaInicio, fechaFin);	
			}
			
		} catch (Exception e) {
			log.error("[Service postBusquedaFecha][error] " + e);
			errorMensaje.put("codigo", config.getCode_207());
			errorMensaje.put("mensaje", config.getMensaje_207());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		}
		
		log.info("[Metodo postBusquedaFecha][Fin]");
		
		return ResponseEntity.status(HttpStatus.OK).body(lstBitacora);
	}

	@Override
	public ResponseEntity<Object> postBusquedaCompania(BusquedaBitacoraEntity busqueda) {
		Map<String, String> errorMensaje = new HashMap<>();
		
		log.info("[Metodo postBusquedaCompania][Inicio]");
		
		List<BitacoraSearch> lstBitacora = null;
		
		Date fechaInicio = null;
		Date fechaFin = null;
		int numero = 0;
		
		boolean fechas =false;
		boolean numeroValido =false;
		
		try {
			log.info("[Validacion de fechas]");
			if (!busqueda.getFechaIncio().isEmpty() && !busqueda.getFechaFin().isEmpty()) {
				fechaInicio = convertirAFecha(busqueda.getFechaIncio());
				fechaFin = convertirAFecha(busqueda.getFechaFin());
				fechas = true;
			}else {
				errorMensaje.put("codigo", config.getCode_209());
				errorMensaje.put("mensaje", config.getMensaje_209());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
			}
			
			log.info("[Validacion de fechas]");
			if (!busqueda.getNumero().isEmpty()) {
				numero = Integer.parseInt(busqueda.getNumero());
				numeroValido = true;
			}else {
				errorMensaje.put("codigo", config.getCode_210());
				errorMensaje.put("mensaje", config.getMensaje_210());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
			}

			if (numeroValido == true && fechas == true) {
				log.info("[S]");
				lstBitacora = bitacoraRepository.findNumeroCelular(numero, fechaInicio, fechaFin);	
			}
			
		} catch (Exception e) {
			log.error("[Service postBusquedaCompania][error] " + e);
			errorMensaje.put("codigo", config.getCode_208());
			errorMensaje.put("mensaje", config.getMensaje_208());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		}
		
		log.info("[Metodo postBusquedaCompania][Fin]");
		
		return ResponseEntity.status(HttpStatus.OK).body(lstBitacora);
	}
	
	/**
	 * 
	 * @param fecha
	 * @return
	 * @throws ParseException
	 */
	private Date convertirAFecha(String fecha) throws ParseException {

		Date date = null;
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			date = sdf.parse(fecha);
			
		} catch (Exception e) {
			log.error("[Service postBusquedaCompania][error] " + e);
		}
		

		return date; 
	}

}
