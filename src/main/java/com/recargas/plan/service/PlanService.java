package com.recargas.plan.service;

import org.springframework.http.ResponseEntity;

import com.recargas.entity.BusquedaPlanEntity;

public interface PlanService {

	/**
	 * 
	 * @param busqueda 
	 * @return
	 */
	ResponseEntity<Object> postBuscarPlanes(BusquedaPlanEntity busqueda);
}
