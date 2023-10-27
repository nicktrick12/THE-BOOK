package br.edu.ifsp.thebook;

import br.edu.ifsp.thebook.config.GlobalCorsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThebookApplication.class, args);
	}

	@Bean
	public GlobalCorsConfiguration corsFilter() {
		return new GlobalCorsConfiguration();
	}

}
