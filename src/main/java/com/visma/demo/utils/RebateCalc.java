package com.visma.demo.utils;

import com.visma.demo.entities.Product;
import com.visma.demo.types.RebateType;

public interface RebateCalc {

	void countRebate(Product product, RebateType rebateType);

}