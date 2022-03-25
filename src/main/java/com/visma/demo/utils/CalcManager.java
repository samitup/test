package com.visma.demo.utils;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.visma.demo.entities.Product;
import com.visma.demo.services.ProductService;
import com.visma.demo.types.RebateType;

@Component
public class CalcManager {

	@Autowired
	private ProductService productService;

	public List<Product> countRebate(RebateType rebateType) {
		List<Product> productList = productService.getProducts();
		for (Product product : productList) {
			rebateType.getRebate().getCalc().countRebate(product, rebateType);
		}

		return productList;
	}
}