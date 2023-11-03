package com.prueba.springConAnnotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Spring con la annotation @Component registra el bean de esta clase, lo utilizamos llamando al id que le pasamos por parametro
//@Component("Comercial")
@Component
//@Scope("prototype")
public class Comercial implements Empleado {

	// inyeccion de dependencia con java anotation en un campo atributo de clase aplica el concepto de reflexion
	// no es recomendable hacerlo directamente en el campo de clase porque es una mala práctica conocida como Field injection ya que dificulta las pruebas unitarias
	// cuando tenemos mas de una clase que implemente la interfaz que busca Spring entonces debemos usar qualifier luego del autowired  @Qualifier("idDelBean") si no tiene ponemos el nombre de la clase con la primera letra en minuscula
	@Autowired
	@Qualifier("informeFinancieroTrim2")
	private CreacionInformeFinanciero nuevoInforme;
	// crear constructor para inyeccion de dependencia en clase que lo solicite
	// Autowired: Spring busca en todo mi proyecto si hay una clase que implemente
	// la interfaz CreacionInformeFinanciero y si la encuentra es de donde obtiene
	// la inyeccion de dependencia
//	@Autowired
//	public Comercial(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}
	
	//Ejecucion de codigo despues de la creacion del Bean 
	@PostConstruct
	public void ejecutaDespuesCreacion() {
		System.out.println("Ejecutando tras creacion de Bean");
	}
	
	//Ejecucion de codigo despues de apagar el contenedor Spring
	@PreDestroy
	public void ejecutaAntesDestruccion() {
		System.out.println("Ejecutando antes de la destruccion");
	}
	
	@Override
	public String getTareas() {
		// TODO Auto-generated method stub
		return "Vender siempre";
	}

	@Override
	public String getInforme() {
		// llamamos al atributo inyectado por Autowired
		return nuevoInforme.getInformeFinanciero();
	}
	// inyeccion de dependencia con java annotation desde un setter
//	@Autowired
//	public void setNuevoInforme(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}
	
	// inyeccion de dependencia con java annotation desde un metodo x
//	@Autowired
//	public void metodoX(CreacionInformeFinanciero nuevoInforme) {
//		this.nuevoInforme = nuevoInforme;
//	}

}
