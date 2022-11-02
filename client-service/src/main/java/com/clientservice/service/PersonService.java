package com.clientservice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.clientservice.feingclients.OrderPurchaseFeignClient;
import com.clientservice.feingclients.OrderSalesFeignClient;
import com.clientservice.model.OrdersPurchase;
import com.clientservice.model.OrdersSales;
import com.clientservice.model.Person;
import com.clientservice.repository.PersonRepository;


@Service
public class PersonService {

	private PersonRepository personRepository;


	@Autowired(required = true)
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        }
        
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private OrderPurchaseFeignClient orderPurchaseFeignClient;
	
	@Autowired
	private OrderSalesFeignClient orderSalesFeignClient;
	

	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getPersonById(int id) {
		return personRepository.findById(id).orElse(null);
	}
	
	public Person save(Person person) {
		Person nuevaPerson = personRepository.save(person);
		return nuevaPerson;
	}
	
	public List<OrdersPurchase> getOrdresPurchase(int idperson){
		List<OrdersPurchase> ordersPurchase = restTemplate.getForObject("http://localhost:8001/orderspurchase/person/" + idperson, List.class);
				return ordersPurchase;
	}
	
	public List<OrdersSales> getOrdersSales(int idperson){
		List<OrdersSales> ordersSales = restTemplate.getForObject("http://localhost:8002/orderssales/person/" + idperson, List.class);
				return ordersSales;
	}
	
	public OrdersPurchase saveOrdersPurchase(int idperson, OrdersPurchase ordersPurchase) {
		ordersPurchase.setIdperson(idperson);
		OrdersPurchase nuevoOrdersPurchase = orderPurchaseFeignClient.save(ordersPurchase);
		return nuevoOrdersPurchase;
	}
	
	public OrdersSales saveOrdersSales(int idperson, OrdersSales ordersSales) {
		ordersSales.setIdperson(idperson);
		OrdersSales nuevoOrdersSales = orderSalesFeignClient.save(ordersSales);
		return nuevoOrdersSales;
	}
	
	public Map<String, Object> getOrders(int idperson){
		Map<String, Object> result = new HashMap<>();
		Person person = personRepository.findById(idperson).orElse(null);
		
		if(person == null) {
			result.put("Message", "El cliente no existe");
			return result;
		}
		
		result.put("Datos cliente", person);
		
		List<OrdersPurchase> ordersPurchase = orderPurchaseFeignClient.getOrdersPurchase(idperson);
		if(ordersPurchase.isEmpty()) {
			result.put("Ordenes de compra", "El cliente no tiene ordenes de compra");
		}else {
			result.put("Ordenes de compra", ordersPurchase);
		}
		
		List<OrdersSales> ordersSales = orderSalesFeignClient.getOrdersSales(idperson);
		if(ordersSales.isEmpty()) {
			result.put("Ordenes de vemta", "El cliente no tiene ordenes de venta");
		}else {
			result.put("Ordenes de vemta", ordersSales);
		}
		return result;
	}
}
