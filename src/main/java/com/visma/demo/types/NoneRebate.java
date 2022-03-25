package com.visma.demo.types;

import com.visma.demo.utils.NoRebateCalc;
import com.visma.demo.utils.RebateCalc;

public class NoneRebate implements Rebate {
	private static final RebateCalc calc = new NoRebateCalc();

	@Override
	public RebateCalc getCalc() {
		return calc;
	}

}
