/**
 * 
 */
package com.recargas.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity(name = "tipo_plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoPlan implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3840296632651526991L;

	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "nombreplan")
	private String nombrePlan;
	
	@Column(name = "compania")
	private String compania;
	
	@Column(name = "detalleplan")
	private String detallePlan;
	
	@Column(name = "costo")
	private double costo;
	
	@Column(name = "vigencia")
	private String vigencia;

	@Column(name = "idplan")
	private int idPlan;
}
