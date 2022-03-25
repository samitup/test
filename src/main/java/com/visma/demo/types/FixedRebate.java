package com.visma.demo.types;

import com.visma.demo.utils.FixedRebateCalc;
import com.visma.demo.utils.RebateCalc;

import lombok.Data;

@Data
public class FixedRebate implements Rebate {
	private static final RebateCalc calc = new FixedRebateCalc();
	private final double fixedDiscount;

	@Override
	public RebateCalc getCalc() {
		return calc;
	}

}