package com.recargas.plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recargas.dto.HistoricoPagos;

public interface HistoricoPagoRepository extends JpaRepository<HistoricoPagos, Integer>{

	@Query("SELECT hp FROM historico_pagos hp WHERE hp.numeroCelular = ?1")
	List<HistoricoPagos> getFechaBy(int numero);

}
