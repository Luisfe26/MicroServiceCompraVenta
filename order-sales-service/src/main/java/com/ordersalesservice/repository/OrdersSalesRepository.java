package com.ordersalesservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ordersalesservice.model.OrdersSales;


public interface OrdersSalesRepository extends JpaRepository<OrdersSales,Integer>  {
	
	List<OrdersSales> findByIdperson(int Idperson);

}
