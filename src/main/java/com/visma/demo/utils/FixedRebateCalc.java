package com.visma.demo.utils;

import com.visma.demo.entities.Product;
import com.visma.demo.types.FixedRebate;
import com.visma.demo.types.RebateType;

public class FixedRebateCalc implements RebateCalc {

	@Override
	public void countRebate(Product product, RebateType rebateType) {
		FixedRebate rebate = (FixedRebate) rebateType.getRebate();
		if (product.getName().equals("Laptop")) {
			product.setStandardPrice(product.getStandardPrice() - rebate.getFixedDiscount());
		}
	}
}