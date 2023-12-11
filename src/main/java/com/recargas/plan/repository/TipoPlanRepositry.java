/**
 * 
 */
package com.recargas.plan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.recargas.dto.TipoPlan;

/**
 * 
 */
public interface TipoPlanRepositry extends JpaRepository<TipoPlan, Integer>{

	@Query("SELECT tp FROM tipo_plan tp WHERE tp.idPlan = :idPlan")
	List<TipoPlan> findByIdPlan(@Param("idPlan") int idPlan);

	@Query("SELECT tp FROM tipo_plan tp WHERE tp.compania = :compania")
	List<TipoPlan> findByCompania(@Param("compania") String compania);
	
	@Query("SELECT tp FROM tipo_plan tp WHERE tp.id = :idPlan")
	List<TipoPlan> findByIdPlanCom(@Param("idPlan") int idPlan);

}
