package com.prueba.springConAnnotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAnotations2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// leer el XML de configuracion
//		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		// leer archivo de configuracion creado en una clase java
		
		// pedir bean al contenedor
//		Empleado Juan = contexto.getBean("comercial", Empleado.class);
//		Empleado Martin = contexto.getBean("comercial", Empleado.class);
		// Son el mismo objeto o diferentes?
//		System.out.println(Juan == Martin ? "es el mismo objeto" : "son distintos objetos");
//		contexto.close();
		
		// JAVA CONFIG
		
		AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(JavaConfig.class);
//		Empleado Juan = contexto.getBean("directorFinanciero", Empleado.class);
//		System.out.println(Juan.getTareas());
//		System.out.println(Juan.getInforme());
		
		DirectorFinanciero empleado = contexto.getBean("directorFinanciero",DirectorFinanciero.class);
		System.out.println(empleado.getEmail());
		System.out.println(empleado.getNombreEmpresa());
		contexto.close();
	}

}
