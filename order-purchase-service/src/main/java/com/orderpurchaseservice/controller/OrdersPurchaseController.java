package com.orderpurchaseservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.orderpurchaseservice.model.OrdersPurchase;
import com.orderpurchaseservice.service.OrdersPurchaseService;



@RestController
@RequestMapping(value = "/orderspurchase" )
public class OrdersPurchaseController {
	
	@Autowired
	private OrdersPurchaseService ordersPurchaseService;
	
	@GetMapping
	public ResponseEntity<List<OrdersPurchase>> listarOrdersPurchase(){
		List<OrdersPurchase> ordersPurchase = ordersPurchaseService.getAll();
		if(ordersPurchase.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ordersPurchase);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdersPurchase> obtenerOrdersPurchase(@PathVariable("id") int id){
		OrdersPurchase ordersPurchase = ordersPurchaseService.getIdordenpurchase(id);
		if(ordersPurchase == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ordersPurchase);
	}
	
	@PostMapping
	public ResponseEntity<OrdersPurchase> guardarOrdersPurchase(@RequestBody OrdersPurchase ordersPurchase){
		OrdersPurchase nuevoOrdersPurchase = ordersPurchaseService.save(ordersPurchase);
		return ResponseEntity.ok(nuevoOrdersPurchase);
	}
	
	@GetMapping("/person/{idperson}")
	public ResponseEntity<List<OrdersPurchase>> listarOrdersPurchasePorIdperson(@PathVariable("idperson") int id){
		List<OrdersPurchase> ordersPurchase = ordersPurchaseService.byIdperson(id);
		if(ordersPurchase.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(ordersPurchase);
	}
}
