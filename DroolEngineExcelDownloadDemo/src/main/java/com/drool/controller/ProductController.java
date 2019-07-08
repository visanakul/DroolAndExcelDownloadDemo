package com.drool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drool.pojo.Product;
import com.drool.service.IDiscountService;
@RestController
public class ProductController {
	
	@Autowired
	private IDiscountService service;
	
	@GetMapping("/discount")
	public Product handleDiscount(@RequestParam("type") String type) {
		Product product=new Product();
		product.setProductType(type);
		return service.getDiscount(product);
	}
}
