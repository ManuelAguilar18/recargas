/**
 * 
 */
package com.recargas.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "bitacora")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bitacora implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 884286419897373221L;

	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;	
	
	@Column(name = "idplan")
	private int idPlan;	
	
	@Column(name = "numero")
	private int numeroCelular;	
	
	@Column(name = "monto")
	private double monto;
	
	@Column(name = "fechapago")
	private String fechaPago;
	
	@Column(name = "fechaproceso")
	private String fechaProceso;		
	
}
