package com.sunRays.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "itemId")
	private int itemId;
	@Column(name = "itemName")
	private String itemName;
	@Column(name = "description")
	private String description;
	//@OneToOne(mappedBy="inventory", cascade=CascadeType.ALL)
	//private InventoryDetails inventoryDetail;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public InventoryDetails getInventoryDetail() {
		return inventoryDetail;
	}
	public void setInventoryDetail(InventoryDetails inventoryDetail) {
		this.inventoryDetail = inventoryDetail;
	}*/
	
}
