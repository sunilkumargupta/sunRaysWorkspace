package com.sunRays.service;

import java.util.List;

import com.sunRays.model.Inventory;

public interface InventoryService {

	Inventory getItem(Integer itemId);
	List <Inventory>  getAllItems();
	void update(Inventory item);
	void delete(Inventory item);


}
