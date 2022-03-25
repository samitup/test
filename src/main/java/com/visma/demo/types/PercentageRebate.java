package com.visma.demo.types;

import com.visma.demo.utils.PercentageRebateCalc;
import com.visma.demo.utils.RebateCalc;

import lombok.Data;

@Data
public class PercentageRebate implements Rebate {
	private static final RebateCalc calc = new PercentageRebateCalc();
	private final double rebatePercentage;

	@Override
	public RebateCalc getCalc() {
		return calc;
	}
}