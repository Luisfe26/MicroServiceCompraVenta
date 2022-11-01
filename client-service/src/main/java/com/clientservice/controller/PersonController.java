package com.clientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.clientservice.model.OrdersPurchase;
import com.clientservice.model.OrdersSales;
import com.clientservice.model.Person;
import com.clientservice.service.PersonService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/person" )
public class PersonController {
	
	@Autowired
	private PersonService personSevice;

	@GetMapping
	public ResponseEntity<List<Person>> listarPerson(){
		List<Person> person = personSevice.getAll();
		if(person.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(person);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> obtenerPerson(@PathVariable("id") int id){
		Person person = personSevice.getPersonById(id);
		if(person == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(person);
	}
	
	@PostMapping
	public ResponseEntity<Person> guardarPerson(@RequestBody Person person){
		Person nuevoPerson = personSevice.save(person);
		return ResponseEntity.ok(nuevoPerson);
	}
	
	@GetMapping("/orderspurchase/{idperson}")
	public ResponseEntity<List<OrdersPurchase>> listarOrdersPurchase(@PathVariable("idperson") int id){
		Person person = personSevice.getPersonById(id);
		if(person == null) {
			return ResponseEntity.notFound().build();
		}
		List<OrdersPurchase> ordersPurchase = personSevice.getOrdresPurchase(id);
		return ResponseEntity.ok(ordersPurchase);
	}
	
	@GetMapping("/orderssales/{idperson}")
	public ResponseEntity<List<OrdersSales>> listarOrdersSales(@PathVariable("idperson") int id){
		Person person = personSevice.getPersonById(id);
		if(person == null) {
			return ResponseEntity.notFound().build();
		}
		List<OrdersSales> ordersSales = personSevice.getOrdersSales(id);
		return ResponseEntity.ok(ordersSales);
	}
	
	@PostMapping("/orderspurchase/{idperson}")
	public ResponseEntity<OrdersPurchase> guardarOrdersPurchase(@PathVariable("idperson") int id, @RequestBody OrdersPurchase ordersPurchase){
		OrdersPurchase nuevoOrdersPurchase = personSevice.saveOrdersPurchase(id, ordersPurchase);
		return ResponseEntity.ok(nuevoOrdersPurchase);
	}
	
	@PostMapping("/orderssales/{idperson}")
	public ResponseEntity<OrdersSales> guardarOrdersSales(@PathVariable("idperson") int id, @RequestBody OrdersSales ordersSales){
		OrdersSales nuevoOrdersSales = personSevice.saveOrdersSales(id, ordersSales);
		return ResponseEntity.ok(nuevoOrdersSales);
	}
	
	@GetMapping("/orders/{idperson}")
	public ResponseEntity<Map<String, Object>> listarOrdenes(@PathVariable("idperson") int id){
		Map<String, Object> result = personSevice.getOrders(id);
		return ResponseEntity.ok(result);
	}

}
