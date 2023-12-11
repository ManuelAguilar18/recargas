	package com.recargas.util;

import org.apache.log4j.Logger;

public class UtilPagos {

	private final static Logger log = Logger.getLogger(UtilPagos.class);
	
	public static boolean isNumeric(String numero)
	{
		boolean bandera = true;
		
		log.info("[Validaciones para el numero][inicio] " + numero);
		if (numero == null || numero.equals("")) {
			bandera = false;
			return bandera;
		}

		for (int i = 0; i < numero.length(); i++)
		{
			char c = numero.charAt(i);
			if (c < '0' || c > '9') {
				bandera = false;
				return bandera;
			}
		}
		
		if (numero.length() > 10) {
			bandera = false;
			return bandera;
		}
		
		log.info("[Validaciones para el numero][fin] {badera} "+ bandera);
		
		return bandera;
	}

	public static boolean monto(double montoPlan) {
		
		boolean bandera = false;
		
		if (montoPlan > 0.0) {
			
			bandera = true;
			return bandera;
		}
		
		return bandera;
	}
}
