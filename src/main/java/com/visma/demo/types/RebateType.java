package com.visma.demo.types;

public enum RebateType {
	LONGTERMCUSTOMER(new PercentageRebate(15.0)), NEWCUSTOMER(new PercentageRebate(10.0)), NONE(new NoneRebate()),
	FIXED_LAPTOP(new FixedRebate(10.0));

	private final Rebate rebate;

	RebateType(Rebate rebate) {
		this.rebate = rebate;
	}

	public Rebate getRebate() {
		return this.rebate;
	}

}
