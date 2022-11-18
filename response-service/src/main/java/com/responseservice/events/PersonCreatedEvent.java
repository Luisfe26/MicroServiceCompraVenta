package com.responseservice.events;

import com.responseservice.model.Person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonCreatedEvent extends Event<Person>{

}
