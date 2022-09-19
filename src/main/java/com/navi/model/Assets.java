package com.navi.model;

public class Assets {
	private Debt debt;
	private Equity equity;
	private Gold gold;
	private int totalAssetsValue;

	public Assets(int equity, int debt, int gold) {
		super();
		this.totalAssetsValue = debt + equity + gold;
		this.debt = new Debt(debt, (((float) debt / totalAssetsValue) * 100));
		this.equity = new Equity(equity, (((float) equity / totalAssetsValue) * 100));
		this.gold = new Gold(gold, (((float) gold / totalAssetsValue) * 100));
	}

	public int getTotalAssetsValue() {
		return totalAssetsValue;
	}

	public Assets(Debt debt, Equity equity, Gold gold) {
		super();
		this.debt = debt;
		this.equity = equity;
		this.gold = gold;
	}

	public Debt getDebt() {
		return debt;
	}

	public void setDebt(Debt debt) {
		this.debt = debt;
	}

	public Equity getEquity() {
		return equity;
	}

	public void setEquity(Equity equity) {
		this.equity = equity;
	}

	public Gold getGold() {
		return gold;
	}

	public void setGold(Gold gold) {
		this.gold = gold;
	}

	@Override
	public String toString() {
		return equity.getAmount() + " " + debt.getAmount() + " " + gold.getAmount();
	}

}
