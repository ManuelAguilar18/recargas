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



@Entity
@Table(name = "plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Compania implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3315763379771336497L;
	
	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "nombrecompania")
	private String nombre_compania;
	
	@Column(name = "nombrecorto")
	private String nombre_corto;
	
	@Column(name = "estatus")
	private int estatus;
	
}
