package com.clientservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.clientservice.events.Event;
import com.clientservice.events.EventType;
import com.clientservice.events.PersonCreatedEvent;
import com.clientservice.model.Person;

import java.util.Date;
import java.util.UUID;

@Component
public class PersonEventsService {
	
	@Autowired
	private KafkaTemplate<String, Event<?>> producer;
	
	@Value("${topic.person.name:persons}")
	private String topicCustomer;
	
	public void publish(Person person) {

		PersonCreatedEvent data = new PersonCreatedEvent();
		data.setData(person);
		data.setId(UUID.randomUUID().toString());
		data.setType(EventType.CREATED);
		data.setDate(new Date());

		this.producer.send(topicCustomer, data);
	}

}
