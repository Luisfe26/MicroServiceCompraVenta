package com.clientservice.repository;

import com.clientservice.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
