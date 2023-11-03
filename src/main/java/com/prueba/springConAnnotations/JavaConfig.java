package com.prueba.springConAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.prueba.springConAnnotations")
@PropertySource("classpath:datosEmpresa.propiedades")
public class JavaConfig {
	// definir el bean para informeFinancieroDtoCOmpras
	@Bean 
	public CreacionInformeFinanciero informeFinancieroDtoCompras(){ // id del Bean inyectado
		return new InformeFinancieroDtoCompras();
	}
	
	// definir el bean para DirectorFinanciero e inyectar dependencias.
	@Bean 
	public Empleado directorFinanciero(){
		return new DirectorFinanciero(informeFinancieroDtoCompras());
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
