package com.sunRays.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sunRays.model.Inventory;


@Repository("inventoryDao")
public class InventoryDaoImpl implements InventoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Inventory getItem(Integer itemId) {
		return (Inventory)sessionFactory.getCurrentSession().get(Inventory.class, itemId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> getAllItems() {
		return (List<Inventory>) sessionFactory.getCurrentSession().createCriteria(Inventory.class).list();
	}

	@Override
	public void update(Inventory item) {
		sessionFactory.getCurrentSession().saveOrUpdate(item);
		
	}

	@Override
	public void delete(Inventory item) {
		sessionFactory.getCurrentSession().delete(item);
		
	}

}
