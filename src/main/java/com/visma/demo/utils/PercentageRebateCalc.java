package com.visma.demo.utils;

import com.visma.demo.entities.Product;
import com.visma.demo.types.PercentageRebate;
import com.visma.demo.types.RebateType;

public class PercentageRebateCalc implements RebateCalc {
	Double getRebatePercentage(RebateType rebateType) {
		PercentageRebate rebate = (PercentageRebate) rebateType.getRebate();
		return rebate.getRebatePercentage();
	}

	@Override
	public void countRebate(Product product, RebateType rebateType) {
		final double rebatePrice;
		rebatePrice = product.getStandardPrice() - (product.getStandardPrice() / getRebatePercentage(rebateType));
		product.setStandardPrice(rebatePrice);
	}

}