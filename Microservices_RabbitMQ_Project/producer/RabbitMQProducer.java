package org.Tayana.Microservices_RabbitMQ_Project.producer;

import org.Tayana.Microservices_RabbitMQ_Project.dto.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Service
public class RabbitMQProducer 
{
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${rabbitmq.exchange.json.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.json.key}")
	private String routingKey;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(RabbitMQProducer.class);
	
	
	public void save(Student student)	{		//here logger is used to show the data in console window 
		LOGGER.info(String.format("Message sent -> %s", student.toString()));
		//rabbitTemplate.convertAndSend  method converts Java Object to AMQP message and send it to default TopicExchange
		rabbitTemplate.convertAndSend(exchange, routingKey, student);
	}
	
	
}
















//@Service
//public class RabbitMQProducer {
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//    
//	@Value("${rabbitmq.routing.json.key}")
//	private String routingKey;
//	
//	@Value("${rabbitmq.exchange.response.name}")
//	private String exchange;
//
//    public void send(Student student)
//    {
//        String correlationId = java.util.UUID.randomUUID().toString();
//        String replyToQueue = "replyQueue_" + correlationId;
//        Message<Student> message = MessageBuilder
//                .withPayload(student)
//                .setHeader("correlationId", correlationId)
//                .setHeader("replyTo", replyToQueue)
//                .build();
//
//
//        rabbitTemplate.convertAndSend(exchange, routingKey, message);
//        System.out.println("sent"+message.toString());
//    }
//}


