package com.jpa.ecomm_ops;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "SFA Compliance Operation Service API",
				version = "1.0",
				description = "API documentation for SFA Compliance Operation Service",
				contact = @Contact(
						name = "Nainsi Singh",
						email = "nainsi.singh@sita.aero"
				)

		),
		security = { @SecurityRequirement(name = "bearerAuth") },
		servers = {
				@Server(url = "${server.servlet.context-path}", description = "SFA Compliance Operation Service")
		}
)
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT",
		in = SecuritySchemeIn.HEADER
)
public class ECommApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ECommApplication.class, args);
	}
	//To run code as a standalone
	@Override
	public void run(String... args) throws Exception {

	}
}
