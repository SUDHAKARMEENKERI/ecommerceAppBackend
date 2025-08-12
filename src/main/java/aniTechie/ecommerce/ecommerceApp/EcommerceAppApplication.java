package aniTechie.ecommerce.ecommerceApp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@OpenAPIDefinition(
		info = @Info(
				title = "Users Management API",
				version = "1.0",
				description = "API documentation for managing user"
		)
)
@SpringBootApplication
@ComponentScan(basePackages = "controller")
@ComponentScan(basePackages = "service")
@ComponentScan(basePackages = "errorHandling")
@EnableJpaRepositories(basePackages = "dao")
@EntityScan(basePackages = "model")
public class EcommerceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceAppApplication.class, args);
	}

}
