package com.sunRays.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Customer implements Comparable<Customer>{
	@Id
	@GeneratedValue
	private int custId;
	private String custName;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
		
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "custId: "+custId+" custName: "+custName;
	}
	
	@Override
	public int compareTo(Customer cust) {
		int result;
		if(getCustId() < cust.getCustId()){
			result = -1;
		}else if(getCustId() > cust.getCustId()){
			result = 1;
		}else{
			result = 0;
		}
		return result;
	}
	
}
