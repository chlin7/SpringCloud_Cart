package com.gensoft.order.controller;

import com.gensoft.order.dto.CartDTO;
import com.gensoft.product.client.ProductClient;
import com.gensoft.product.common.DecreaseStockInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:54 2019/6/13
 */
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ProductClient productClient;

	@GetMapping("/decreaseStock")
	public String decreaseStock(){
		productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("164103465734242707",3)));
		return "ok";
	}
}
