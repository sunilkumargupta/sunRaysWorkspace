package com.sunRays.bean;


public class InventoryDto {
	private String itemId;
	private String itemName;
	private String description;
	//private InventoryDetailDto inventoryDetailDto;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
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
	/*public InventoryDetailDto getInventoryDetailDto() {
		return inventoryDetailDto;
	}
	public void setInventoryDetailDto(InventoryDetailDto inventoryDetailDto) {
		this.inventoryDetailDto = inventoryDetailDto;
	}*/

	
}
