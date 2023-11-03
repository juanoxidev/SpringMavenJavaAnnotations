package com.prueba.springConAnnotations;

import org.springframework.stereotype.Component;
// Spring con la annotation @Component registra el bean de esta clase, lo utilizamos llamando al id que le pasamos por parametro
@Component("Comercial")
public class Comercial implements Empleado {

	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender siempre";
	}

	@Override
	public String getInforme() {
		// TODO Auto-generated method stub
		return "Informe generado por el comercial";
	}

}
