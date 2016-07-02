package com.sunRays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunRays.dao.InventoryDao;
import com.sunRays.model.Inventory;

@Service("inventoryService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InventoryServiceImpl implements  InventoryService{

	@Autowired
	private InventoryDao inventoryDao;
	
	@Override
	public Inventory getItem(Integer itemId) {
		return inventoryDao.getItem(itemId);
	}

	@Override
	public List<Inventory> getAllItems() {
		return inventoryDao.getAllItems();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(Inventory item) {
		inventoryDao.update(item);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Inventory item) {
		inventoryDao.delete(item);
		
	}

}
