package com.recargas.plan.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.recargas.dto.Bitacora;
import com.recargas.dto.HistoricoPagos;
import com.recargas.dto.TipoPlan;
import com.recargas.entity.CompraPlanEntity;
import com.recargas.plan.repository.BitacoraRepository;
import com.recargas.plan.repository.HistoricoPagoRepository;
import com.recargas.plan.repository.TipoPlanRepositry;
import com.recargas.plan.service.CompraPlanService;
import com.recargas.propiedades.Configuracion;
import com.recargas.util.UtilPagos;

import lombok.Setter;

@Service
public class CompraPlanServiceImpl implements CompraPlanService {
	
	private final static Logger log = Logger.getLogger(CompaniaServiceImpl.class);
	
	@Autowired
	BitacoraRepository bitacoraRepository;
	
	@Autowired
	TipoPlanRepositry tipoPlanRepositry;
	
	@Autowired
	HistoricoPagoRepository historicoPagoRepository;
	
	@Setter (onMethod=@__(@Autowired))
	private Configuracion config;
	
	/**
	 * Fecha
	 */
	LocalDateTime datetime = LocalDateTime.now();

	@Override
	public ResponseEntity<Object> putCompraPlan(CompraPlanEntity compra) {
		
		Map<String, String> errorMensaje = new HashMap<>();
		
		Bitacora bitacora = new Bitacora();
		
		HistoricoPagos historicoPagos = new HistoricoPagos();
		
		int tiempo = 0;
		
		log.info("[Comienza el guardado de la compra plan][Inicio]");
		
		log.info("[Valida si es numerico el numero][Inicio]");
		boolean numero = UtilPagos.isNumeric(compra.getNumero());
		log.info("[Valida si es numerico el numero][fin]");
		
		log.info("[Valida si el monto es correcto][Inicio]");
		boolean monto = UtilPagos.monto(compra.getMonto());
		log.info("[Valida si el monto es correcto][fin]");
		
		log.info("[Valida que la compania exita][Inicio]");
		boolean idPlan = compania(compra.getIdPlan());
		log.info("[Valida que la compania exita][fin]");
		
		try {
			tiempo = minutosPasados(compra);
		} catch (ParseException e) {
			log.error("[Service putCompraPlan][error] " + e);
			errorMensaje.put("codigo", "-205");
			errorMensaje.put("mensaje", "Problema con fecha");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		}
		
		try {
			if (numero == true && monto == true && idPlan == true) {
				
				if ( tiempo > config.getTiempo_espera() || tiempo == 0) {
					log.info("[Guarda información en historico]");
					historicoPagos = setCompra(compra);
					historicoPagoRepository.save(historicoPagos);
					log.info("[Guarda información en historico]");
					
					
					
					log.info("[Guarda información en bitacora]");
					bitacora = setBitacora(compra);
					bitacoraRepository.save(bitacora);	
					log.info("[Guarda información en bitacora][FIN]");
					
					errorMensaje.put("codigo", config.getCode_ok());
					errorMensaje.put("mensaje", config.getMensaje_ok());
				}else {
					log.info("Deben por lo menos pasar 15 minutos para una nueva recarga [] ");
					errorMensaje.put("codigo", config.getCode_205());
					errorMensaje.put("mensaje", config.getMensaje_205());
					return ResponseEntity.status(HttpStatus.OK).body(errorMensaje);
				}
				
			}else {
				if (numero == false) {
					log.info("El numero telefonico es incorrecto [] ");
					errorMensaje.put("codigo", config.getCode_201());
					errorMensaje.put("mensaje", config.getMensaje_201());
					return ResponseEntity.status(HttpStatus.OK).body(errorMensaje);
				}
				
				if (monto == false) {
					log.info("El monto del plan es incorrecto [] ");
					errorMensaje.put("codigo", config.getCode_202());
					errorMensaje.put("mensaje", config.getMensaje_202());
					return ResponseEntity.status(HttpStatus.OK).body(errorMensaje);
				}
				
				if (idPlan == false) {
					log.info("El id del plan es incorrecto [] ");
					errorMensaje.put("codigo", config.getCode_203());
					errorMensaje.put("mensaje",config.getMensaje_203());
					return ResponseEntity.status(HttpStatus.OK).body(errorMensaje);
				}
			}
		} catch (Exception e) {
			log.error("[Service putCompraPlan][error] " + e);
			errorMensaje.put("codigo", config.getCode_200());
			errorMensaje.put("mensaje", config.getMensaje_200());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMensaje);
		
	}

	private int minutosPasados(CompraPlanEntity compra) throws ParseException {
		
		List<HistoricoPagos> historico = historicoPagoRepository.getFechaBy(Integer.parseInt(compra.getNumero())); 
		
		int difMinutos = 0;
		int contador = historico.size()-1;
		
		if (historico.size() > 0) {
			 Calendar calInicio =Calendar.getInstance();
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 calInicio.setTime(sdf.parse(historico.get(contador).getFechaPago()));
			 Calendar calSalida =Calendar.getInstance();
			
			 difMinutos =calSalida.get(Calendar.MINUTE) - calInicio.get(Calendar.MINUTE);
		}
		

		 		
		return difMinutos;
	}

	/**
	 * 
	 * @param compra
	 * @return
	 */
	private HistoricoPagos setCompra(CompraPlanEntity compra) {
		
		HistoricoPagos historico = new HistoricoPagos();
		
		historico.setIdPlan(compra.getIdPlan());
		historico.setNumeroCelular(Integer.parseInt(compra.getNumero()));
		historico.setMonto(compra.getMonto());
		historico.setFechaPago(datetime.toString());
		
		return historico;
	}

	/**
	 * 
	 * @param compra
	 * @return
	 */
	private Bitacora setBitacora(CompraPlanEntity compra) {

		Bitacora bitacora = new Bitacora();

		bitacora.setIdPlan(compra.getIdPlan());
		bitacora.setMonto(compra.getMonto());
		bitacora.setNumeroCelular(Integer.parseInt(compra.getNumero()));
		bitacora.setFechaPago(datetime.toString());
		bitacora.setFechaProceso(datetime.toString());

		return bitacora;
	}

	/**
	 * 
	 * @param idPlan
	 * @return
	 */
	private boolean compania(int idPlan) {
		
		boolean bandera  = false;
		
		List<TipoPlan> lstPlan = tipoPlanRepositry.findByIdPlanCom(idPlan);
		
		if (lstPlan.size() > 0 ) {
			bandera = true;
		}
		
		return bandera;
	}

}
