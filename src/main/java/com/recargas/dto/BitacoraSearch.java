/**
 * 
 */
package com.recargas.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity (name = "bitacora")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BitacoraSearch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 884286419897373221L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique = true)
	private int id;	
	
	@Column(name = "idplan")
	private int idPlan;	
	
	@Column(name = "numero")
	private int numeroCelular;	
	
	@Column(name = "monto")
	private double monto;
	
	@Column(name = "fechapago")
	private Date fechaPago;
	
	@Column(name = "fechaproceso")
	private Date fechaProceso;		
	
}
