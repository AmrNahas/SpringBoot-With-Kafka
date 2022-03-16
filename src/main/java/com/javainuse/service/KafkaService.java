package com.javainuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	String kafkaTopic = "test";
	
	public void send(String data) {
	    kafkaTemplate.send(kafkaTopic, data);
	}

	@KafkaListener(topics = "test", groupId = "foo")
	public void listenGroupFoo(String message) {
		System.out.println("Received Message in group foo: " + message);
	}
}
