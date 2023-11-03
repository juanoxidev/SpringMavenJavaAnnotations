package com.prueba.springConAnnotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnnotations {

	public static void main(String[] args) {
		// leer el XML de configuracion
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		// pedir un bean al contenedor con javaAnnotation
		Empleado Juan = contexto.getBean("comercial", Empleado.class);
		// usar el bean 
		System.out.println(Juan.getInforme());
		System.out.println(Juan.getTareas());
		//cerrar el conexto
		contexto.close();

	}

}
