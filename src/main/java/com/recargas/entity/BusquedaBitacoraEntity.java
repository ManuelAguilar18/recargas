package com.recargas.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusquedaBitacoraEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero;
	
	private String fechaIncio;
	
	private String fechaFin;
}
