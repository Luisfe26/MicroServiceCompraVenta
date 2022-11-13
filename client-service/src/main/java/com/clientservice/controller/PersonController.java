package com.clientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.clientservice.model.OrdersPurchase;
import com.clientservice.model.OrdersSales;
import com.clientservice.model.Person;
import com.clientservice.service.PersonService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonService personSevice;

	@GetMapping
	public ResponseEntity<List<Person>> listarPerson() {
		List<Person> person = personSevice.getAll();
		if (person.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(person);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> obtenerPerson(@PathVariable("id") int id) {
		Person person = personSevice.getPersonById(id);
		if (person == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(person);
	}

	@PostMapping
	public ResponseEntity<Person> guardarPerson(@RequestBody Person person) {
		Person nuevoPerson = personSevice.save(person);
		return ResponseEntity.ok(nuevoPerson);
	}

	@CircuitBreaker(name = "orderPurchaseCB", fallbackMethod = "fallBackGetOrdrePurchase")
	@GetMapping("/orderspurchase/{idperson}")
	public ResponseEntity<List<OrdersPurchase>> listarOrdersPurchase(@PathVariable("idperson") int id) {
		Person person = personSevice.getPersonById(id);
		if (person == null) {
			return ResponseEntity.notFound().build();
		}
		List<OrdersPurchase> ordersPurchase = personSevice.getOrdresPurchase(id);
		return ResponseEntity.ok(ordersPurchase);
	}

	@CircuitBreaker(name = "orderSalesCB", fallbackMethod = "fallBackGetOrdreSales")
	@GetMapping("/orderssales/{idperson}")
	public ResponseEntity<List<OrdersSales>> listarOrdersSales(@PathVariable("idperson") int id) {
		Person person = personSevice.getPersonById(id);
		if (person == null) {
			return ResponseEntity.notFound().build();
		}
		List<OrdersSales> ordersSales = personSevice.getOrdersSales(id);
		return ResponseEntity.ok(ordersSales);
	}

	@CircuitBreaker(name = "orderPurchaseCB", fallbackMethod = "fallBackSaveOrdrePurchase")
	@PostMapping("/orderspurchase/{idperson}")
	public ResponseEntity<OrdersPurchase> guardarOrdersPurchase(@PathVariable("idperson") int id,
			@RequestBody OrdersPurchase ordersPurchase) {
		OrdersPurchase nuevoOrdersPurchase = personSevice.saveOrdersPurchase(id, ordersPurchase);
		return ResponseEntity.ok(nuevoOrdersPurchase);
	}

	@CircuitBreaker(name = "orderSalesCB", fallbackMethod = "fallBackSaveOrdreSales")
	@PostMapping("/orderssales/{idperson}")
	public ResponseEntity<OrdersSales> guardarOrdersSales(@PathVariable("idperson") int id,
			@RequestBody OrdersSales ordersSales) {
		OrdersSales nuevoOrdersSales = personSevice.saveOrdersSales(id, ordersSales);
		return ResponseEntity.ok(nuevoOrdersSales);
	}

	@CircuitBreaker(name = "ordersCB", fallbackMethod = "fallBackGetOrdres")
	@GetMapping("/orders/{idperson}")
	public ResponseEntity<Map<String, Object>> listarOrdenes(@PathVariable("idperson") int id) {
		Map<String, Object> result = personSevice.getOrders(id);
		return ResponseEntity.ok(result);
	}

    private ResponseEntity<List<OrdersPurchase>> fallBackGetOrdrePurchase(@PathVariable("idperson") int id,
			RuntimeException exception) {
		return new ResponseEntity("Las oredenes de compras del cliente no estan disponibles intente mas tarde",
				HttpStatus.OK);
	}

	private ResponseEntity<List<OrdersSales>> fallBackGetOrdreSales(@PathVariable("idperson") int id,
			RuntimeException exception) {
		return new ResponseEntity("Las oredenes de ventas del cliente no estan disponibles intente mas tarde",
				HttpStatus.OK);
	}

	private ResponseEntity<OrdersPurchase> fallBackSaveOrdrePurchase(@PathVariable("idperson") int id,
			@RequestBody OrdersPurchase ordersPurchase, RuntimeException exception) {
		return new ResponseEntity("No se pudo procesar su oreden de compra intente mas tarde", HttpStatus.OK);
	}

	private ResponseEntity<OrdersSales> fallBackSaveOrdreSales(@PathVariable("idperson") int id,
			@RequestBody OrdersSales OrdersSales, RuntimeException exception) {
		return new ResponseEntity("No se pudo procesar su oreden de venta intente mas tarde", HttpStatus.OK);
	}

	private ResponseEntity<Map<String, Object>> fallBackGetOrdres(@PathVariable("idperson") int id,
			RuntimeException exception) {
		return new ResponseEntity("Las oredenes del cliente no estan disponibles intente mas tarde",
				HttpStatus.OK);
	}

}
