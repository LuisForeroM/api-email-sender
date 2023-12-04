package edu.unisabana.arqSoftware.dogdaycareemailsender.service.communication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.unisabana.arqSoftware.dogdaycareemailsender.service.EmailSenderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class RabbitListenerService {

    @Autowired
    private EmailSenderService senderService;

    @RabbitListener(queues = { "${rabbitMSA.queue.name}" })

    public void receive( @Payload String message) {
        String jsonClient= message;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonClient);

            // Extraer valores
            int clientId = jsonNode.get("clientId").asInt();
            String nameClient = jsonNode.get("nameClient").asText();
            long documentClient = jsonNode.get("documentClient").asLong();
            String addressClient = jsonNode.get("addressClient").asText();
            String emailClient = jsonNode.get("emailClient").asText();
            senderService.sendemail(emailClient, "Recordatorio de recoger a su perro en la guardería", "Estimado "+nameClient+" tu mascota esta lista para ser recogida");
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
