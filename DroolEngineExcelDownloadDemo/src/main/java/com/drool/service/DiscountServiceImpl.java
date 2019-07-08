package com.drool.service;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drool.pojo.Product;

@Service
public class DiscountServiceImpl implements IDiscountService {


	private final KieContainer kieContainer;

	@Autowired
	public DiscountServiceImpl(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	@Override
	public Product getDiscount(Product product) {
		// KieContainer kieContainer=
		// KieServices.Factory.get().getKieClasspathContainer();

		System.out.println("Product before rules : " + product);
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		System.out.println("Product after rules : " + product);
		return product;
	}

}
