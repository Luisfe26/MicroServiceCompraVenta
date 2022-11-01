package com.ordersalesservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersalesservice.model.OrdersSales;
import com.ordersalesservice.service.OrdersSalesService;



@RestController
@RequestMapping(value = "/orderssales" )
public class OrdersSalesController {
	
	@Autowired
	private OrdersSalesService ordersSalesService;
	
	@GetMapping
	public ResponseEntity<List<OrdersSales>> listarOrdersPurchase(){
		List<OrdersSales> ordersSales = ordersSalesService.getAll();
		if(ordersSales.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ordersSales);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdersSales> obtenerOrdersPurchase(@PathVariable("id") int id){
		OrdersSales ordersSales = ordersSalesService.getIdordenpurchase(id);
		if(ordersSales == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ordersSales);
	}
	
	@PostMapping
	public ResponseEntity<OrdersSales> guardarOrdersPurchase(@RequestBody OrdersSales ordersSales){
		OrdersSales nuevoOrdersSales = ordersSalesService.save(ordersSales);
		return ResponseEntity.ok(nuevoOrdersSales);
	}
	
	@GetMapping("/person/{idperson}")
	public ResponseEntity<List<OrdersSales>> listarOrdersPurchasePorIdperson(@PathVariable("idperson") int id){
		List<OrdersSales> ordersSales = ordersSalesService.byIdperson(id);
		if(ordersSales.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ordersSales);
	}

}
