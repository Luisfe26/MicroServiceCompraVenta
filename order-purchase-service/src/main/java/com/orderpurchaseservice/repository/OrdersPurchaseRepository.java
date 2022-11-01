package com.orderpurchaseservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orderpurchaseservice.model.OrdersPurchase;

public interface OrdersPurchaseRepository extends JpaRepository<OrdersPurchase,Integer> {

	List<OrdersPurchase> findByIdperson(int Idperson);

}
