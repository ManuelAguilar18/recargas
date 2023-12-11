package com.recargas.plan.service;

import org.springframework.http.ResponseEntity;

import com.recargas.entity.CompraPlanEntity;

public interface CompraPlanService {

	/**
	 * 
	 * @param compra
	 * @return
	 */
	ResponseEntity<Object> putCompraPlan(CompraPlanEntity compra);

}
