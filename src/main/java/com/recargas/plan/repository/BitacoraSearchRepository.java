package com.recargas.plan.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recargas.dto.BitacoraSearch;

public interface BitacoraSearchRepository extends JpaRepository<BitacoraSearch, Integer>{
	
	
	@Query(value = "select * from bitacora where fechaPago BETWEEN ?1 and ?2", nativeQuery = true)
	List<BitacoraSearch> findFecha(Date fechaInicio,Date fechaFin);
	
	@Query(value = "select * from bitacora where numero = ?1 and fechaPago BETWEEN ?2 and ?3", nativeQuery = true)
	List<BitacoraSearch> findNumeroCelular(int numero, Date fechaInicio, Date fechaFin);

}
