package com.orderpurchaseservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderpurchaseservice.model.OrdersPurchase;
import com.orderpurchaseservice.repository.OrdersPurchaseRepository;



@Service
public class OrdersPurchaseService {
	

	private OrdersPurchaseRepository ordersPurchaseRepository;

	
    @Autowired
    public OrdersPurchaseService(OrdersPurchaseRepository ordersPurchaseRepository) {
        this.ordersPurchaseRepository = ordersPurchaseRepository;
    }
    
	public List<OrdersPurchase> getAll(){
		return ordersPurchaseRepository.findAll();
	}
	
	public OrdersPurchase getIdordenpurchase(int id) {
		return ordersPurchaseRepository.findById(id).orElse(null);
	}
	
	public OrdersPurchase save(OrdersPurchase ordersPurchase) {
		OrdersPurchase nuevaOrdersPurchase = ordersPurchaseRepository.save(ordersPurchase);
		return nuevaOrdersPurchase;
	}
	
	public List<OrdersPurchase> byIdperson(int Idperson){
		return ordersPurchaseRepository.findByIdperson(Idperson);
	}
}
