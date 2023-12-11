/**
 * 
 */
package com.recargas.plan.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recargas.dto.Compania;

/**
 * 
 */
@Repository
public interface PlanReponsitory extends JpaRepository<Compania, Integer>{

	
}
