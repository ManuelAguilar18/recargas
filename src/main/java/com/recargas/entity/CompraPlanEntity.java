/**
 * 
 */
package com.recargas.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Getter
@Setter
public class CompraPlanEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPlan;
	
	private String numero;
	
	private double monto;
	
	private String compania;
	
}
