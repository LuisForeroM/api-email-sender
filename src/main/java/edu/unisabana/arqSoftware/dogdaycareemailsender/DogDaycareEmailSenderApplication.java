package edu.unisabana.arqSoftware.dogdaycareemailsender;

import edu.unisabana.arqSoftware.dogdaycareemailsender.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DogDaycareEmailSenderApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(DogDaycareEmailSenderApplication.class, args);

	}

}


