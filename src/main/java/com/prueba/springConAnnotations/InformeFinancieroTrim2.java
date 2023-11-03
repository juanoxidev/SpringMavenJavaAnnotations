package com.prueba.springConAnnotations;
import org.springframework.stereotype.Component;
//registramos el bean en el contenedor de spring con annotation component
@Component
public class InformeFinancieroTrim2 implements CreacionInformeFinanciero {

	@Override
	public String getInformeFinanciero() {
		return "Presentacion de informe del trimestre 2, veamos..";
	}

}
