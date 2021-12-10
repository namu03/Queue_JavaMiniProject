package com.from5;

public class Customer {
	private String custName;
	private Pizza p[];
	private int size;
	private Bill bill;
	public Customer( String custName,int size) {
		this.custName = custName;
		this.size=size;
		setP(new Pizza[size]);
	}

	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Pizza[] getP() {
		return p;
	}
	public void setP(Pizza p[]) {
		this.p = p;
	}	
	
	
}
