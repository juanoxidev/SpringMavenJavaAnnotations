package com.prueba.springConAnnotations;
import org.springframework.stereotype.Component;
//registramos el bean en el contenedor de spring con annotation component
@Component
public class InformeFinancieroTrim3 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion de informe favorable del trimestre 3";
	}

}
