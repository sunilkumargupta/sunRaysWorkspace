package com.sunRays.dao;

import java.util.List;

import com.sunRays.model.Inventory;

public interface InventoryDao {

	Inventory getItem(Integer itemId);
	List <Inventory>  getAllItems();
	void update(Inventory item);
	void delete(Inventory item);


}
