package com.recargas.propiedades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
 
import lombok.Getter;

@Configuration
@PropertySource("classpath:configura.properties")
@Getter
public class Configuracion {

	@Value("${code.ok}")
	private String code_ok;
	
    @Value("${mensaje.ok}")
    private String mensaje_ok;
	
	@Value("${tiempo.espera}")
	private int tiempo_espera;
	
    @Value("${code.error.200}")
    private String code_200;
    
    @Value("${mensaje.200}")
    private String mensaje_200;

    @Value("${code.error.201}")
    private String code_201;
    
    @Value("${mensaje.201}")
    private String mensaje_201;
    
    @Value("${code.error.202}")
    private String code_202;
    
    @Value("${mensaje.202}")
    private String mensaje_202;
    
    @Value("${code.error.203}")
    private String code_203;
    
    @Value("${mensaje.203}")
    private String mensaje_203;
    
    @Value("${code.error.205}")
    private String code_205;
    
    @Value("${mensaje.205}")
    private String mensaje_205;
    
    @Value("${code.error.206}")
    private String code_206;
    
    @Value("${mensaje.206}")
    private String mensaje_206;
    
    @Value("${code.error.207}")
    private String code_207;
    
    @Value("${mensaje.207}")
    private String mensaje_207;
    
    @Value("${code.error.208}")
    private String code_208;
    
    @Value("${mensaje.208}")
    private String mensaje_208;
    
    @Value("${code.error.209}")
    private String code_209;
    
    @Value("${mensaje.209}")
    private String mensaje_209;
    
    @Value("${code.error.210}")
    private String code_210;
    
    @Value("${mensaje.210}")
    private String mensaje_210;
    
    @Value("${code.error.211}")
    private String code_211;
    
    @Value("${mensaje.211}")
    private String mensaje_211;
}
