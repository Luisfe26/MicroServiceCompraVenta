package com.clientservice.repository;

import com.clientservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Integer>{

}
