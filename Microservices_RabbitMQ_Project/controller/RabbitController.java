package org.Tayana.Microservices_RabbitMQ_Project.controller;

import org.Tayana.Microservices_RabbitMQ_Project.dto.Student;
import org.Tayana.Microservices_RabbitMQ_Project.producer.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController
{
	@Autowired
	private RabbitMQProducer producer;
	
	@PostMapping("/student")
	public ResponseEntity<Student> sendMessage(@RequestBody Student student)
	{
		producer.save(student);
		return new ResponseEntity<Student>(student,HttpStatus.ACCEPTED);
	}
}
