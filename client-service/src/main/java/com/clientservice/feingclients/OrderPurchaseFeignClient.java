package com.clientservice.feingclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.clientservice.model.OrdersPurchase;

@FeignClient(name = "order-purchase-servise", url= "http://localhost:8001")
@RequestMapping("/orderspurchase")
public interface OrderPurchaseFeignClient {
	
	@PostMapping
	public OrdersPurchase save(@RequestBody OrdersPurchase ordersPurchase );
	
	@GetMapping("/person/{idperson}")
	public List<OrdersPurchase> getOrdersPurchase(@PathVariable("idperson") int idperson);

}
