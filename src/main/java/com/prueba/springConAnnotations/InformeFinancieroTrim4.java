package com.prueba.springConAnnotations;
import org.springframework.stereotype.Component;
//registramos el bean en el contenedor de spring con annotation component
@Component
public class InformeFinancieroTrim4 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Ultimo informe del año, veamos el balance";
	}

}
