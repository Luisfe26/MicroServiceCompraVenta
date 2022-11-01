package com.ordersalesservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersalesservice.model.OrdersSales;
import com.ordersalesservice.repository.OrdersSalesRepository;



@Service
public class OrdersSalesService {

	@Autowired
	private OrdersSalesRepository ordersSalesRepository;

	public List<OrdersSales> getAll(){
		return ordersSalesRepository.findAll();
	}
	
	public OrdersSales getIdordenpurchase(int id) {
		return ordersSalesRepository.findById(id).orElse(null);
	}
	
	public OrdersSales save(OrdersSales ordersSales) {
		OrdersSales nuevaOrdersSales = ordersSalesRepository.save(ordersSales);
		return nuevaOrdersSales;
	}
	
	public List<OrdersSales> byIdperson(int Idperson){
		return ordersSalesRepository.findByIdperson(Idperson);
	}
}
