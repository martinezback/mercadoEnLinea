package com.softlond.mercadoEnLinea;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MercadoEnLineaApplication {
	public static void main(String[] args) {
		SpringApplication.run(MercadoEnLineaApplication.class, args);
	}

}
