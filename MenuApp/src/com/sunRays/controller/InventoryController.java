package com.sunRays.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sunRays.bean.MenuItemDto;
import com.sunRays.model.Inventory;
import com.sunRays.model.InventoryDetails;
import com.sunRays.model.MenuItem;
import com.sunRays.service.InventoryService;


@Component
@Scope("prototype")
@Path("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@GET
	@Path("/get/{itemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Inventory getItem(@PathParam ("itemId") String itemId){
		Inventory iry=null;
		if(itemId!=null && itemId.length()>0)
			 iry=inventoryService.getItem(Integer.parseInt(itemId));
		return iry;
	}
	
	@GET
	 @Path("/listItems")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Inventory> getItemList(){
		 return inventoryService.getAllItems();
	 }
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory>  update(Inventory item){
		inventoryService.update(item);
		 return getItemList();
	 }
	@GET
	@Path("/hello")
	public String  hello(){
		Inventory item=new Inventory();
		InventoryDetails id=new InventoryDetails();
		//id.setItemId(1);
		id.setItemPrice(12.5f);
		id.setItemPrice(15f);
		
		//item.setItemId(3);
		item.setItemName("Lux");
		item.setDescription("Hindustan Lever");
		item.setInventoryDetail(id);
		id.setInventory(item);
		inventoryService.update(item);
		return "sunRays";
	 }
}
