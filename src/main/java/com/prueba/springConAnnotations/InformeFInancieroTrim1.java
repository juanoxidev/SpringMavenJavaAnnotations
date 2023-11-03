package com.prueba.springConAnnotations;

import org.springframework.stereotype.Component;
// registramos el bean en el contenedor de spring con annotation component
@Component
public class InformeFInancieroTrim1 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		// TODO Auto-generated method stub
		return "Presentacion de informe financiero del trimestre 1";
	}

}
