package com.responseservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.responseservice.events.Event;
import com.responseservice.events.PersonCreatedEvent;

@Slf4j
@Component
public class PersonEventsService {
	
	@KafkaListener(
			topics = "${topic.person.name:persons}",
			containerFactory = "kafkaListenerContainerFactory",
	groupId = "grupo1")
	public void consumer(Event<?> event) {
		if (event.getClass().isAssignableFrom(PersonCreatedEvent.class)) {
			PersonCreatedEvent personCreatedEvent = (PersonCreatedEvent) event;
			log.info("Received Person created event .... with Id={}, data={}",
					personCreatedEvent.getId(),
					personCreatedEvent.getData().toString());
		}

	}

}
