package com.sunRays.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class InventoryDetails {
	@Id
    @Column(name="itemId", unique=true, nullable=false)
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="inventory"))
	private int itemId;
	@Column(name="itemPrice")
	private float itemPrice;
	@Column(name="availableQty")
	private float availableQty;
	@OneToOne
    @PrimaryKeyJoinColumn
	private Inventory inventory;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public float getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(float availableQty) {
		this.availableQty = availableQty;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
