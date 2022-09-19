package com.navi.model;

public class Gold {
	private int amount;
	private float percentage;
	private int sip;

	public Gold(int amount) {
		this(amount, 0);
	}

	public Gold(int amount, float percentage) {
		this(amount, percentage, 0);
	}

	public Gold(int amount, float percentage, int sip) {
		super();
		this.amount = amount;
		this.percentage = percentage;
		this.sip = sip;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public int getSip() {
		return sip;
	}

	public void setSip(int sip) {
		this.sip = sip;
	}

}
