package com.clientservice.feingclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clientservice.model.OrdersSales;

@FeignClient(name = "order-sales-servise", url= "http://localhost:8002")
@RequestMapping("/orderssales")
public interface OrderSalesFeignClient {
	
	@PostMapping
	public OrdersSales save(@RequestBody OrdersSales ordersSales );
	
	@GetMapping("/person/{idperson}")
	public List<OrdersSales> getOrdersSales(@PathVariable("idperson") int idperson);
	


}
