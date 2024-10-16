package org.integrador3.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@EntityScan(basePackages = "org.integrador3.ps.model")
public class IntegradorTp3Application {
	public static void main(String[] args) {
		SpringApplication.run(IntegradorTp3Application.class, args);
	}
}
