package com.drool;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.drool.pojo.Product;
import com.drool.service.IDiscountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DroolEngineDemoApplicationTests {

	@Autowired
	private IDiscountService service;
	
	@Test
	public void test_goldDiscount_success() {
		Product product=new Product();
		product.setProductType("Gold");
		product=service.getDiscount(product);
		assertNotNull(product);
		assertEquals(new Double(10.0), product.getDiscount());
	}
	@Test
	public void test_goldDiscount_fail() {
		Product product=new Product();
		product.setProductType("Gold123");
		product=service.getDiscount(product);
		assertNotNull(product);
		assertNotEquals(new Double(10.0), product.getDiscount());
	}
	@Test
	public void test_silverDiscount_success() {
		Product product=new Product();
		product.setProductType("Silver");
		product=service.getDiscount(product);
		assertNotNull(product);
		assertEquals(new Double(5.0), product.getDiscount());
	}
	@Test
	public void test_diamondDiscount_success() {
		Product product=new Product();
		product.setProductType("Diamond");
		product=service.getDiscount(product);
		assertNotNull(product);
		assertEquals(new Double(15.0), product.getDiscount());
	}

}
