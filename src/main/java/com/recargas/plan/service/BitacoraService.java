package com.recargas.plan.service;

import org.springframework.http.ResponseEntity;

import com.recargas.entity.BusquedaBitacoraEntity;

public interface BitacoraService {

	/**
	 * 
	 * @param busqueda
	 * @return
	 */
	ResponseEntity<Object> postBusquedaFecha(BusquedaBitacoraEntity busqueda);

	/**
	 * 
	 * @param busqueda
	 * @return
	 */
	ResponseEntity<Object> postBusquedaCompania(BusquedaBitacoraEntity busqueda);

}
