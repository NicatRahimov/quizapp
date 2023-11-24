package az.coders.quizapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = "THis is description",
title = "This is title",
contact = @Contact(name = "nicat",
		url = "url.com",
		email = "nijatrahimov9@gmail.com"),
license = @License(name = "Apache",url = "license url")))
public class QuizappApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuizappApplication.class, args);
	}

}
