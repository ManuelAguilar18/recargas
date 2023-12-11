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
public class BusquedaPlanEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4919220286214797384L;

	private int id;
	
	private String compania;
}
