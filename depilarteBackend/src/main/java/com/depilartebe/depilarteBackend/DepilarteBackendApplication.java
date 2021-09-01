package com.depilartebe.depilarteBackend;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class DepilarteBackendApplication {
	private static Logger log = LogManager.getLogger(DepilarteBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DepilarteBackendApplication.class, args);

		log.info("Servicio Iniciado");
	}

}
