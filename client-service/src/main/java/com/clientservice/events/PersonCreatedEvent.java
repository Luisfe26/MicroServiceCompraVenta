package com.clientservice.events;

import com.clientservice.model.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonCreatedEvent extends Event<Person>{

}
