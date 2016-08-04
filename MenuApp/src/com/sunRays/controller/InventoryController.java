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

import com.sunRays.bean.InventoryDto;
import com.sunRays.model.Inventory;
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
	 @Path("/list")
	 @Produces(MediaType.APPLICATION_JSON)
	 public List<Inventory> getItemList(){
		 return inventoryService.getAllItems();
	 }
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Inventory>  update(InventoryDto item){
		inventoryService.update(beanToModel(item));
		 return getItemList();
	 }
	private Inventory beanToModel(InventoryDto itemDto) {
		Inventory item = new Inventory();
		if(itemDto.getItemId()!=null && itemDto.getItemId().length()>0)
			item.setItemId(Integer.parseInt(itemDto.getItemId()));
		item.setItemName(itemDto.getItemName());
		item.setDescription(itemDto.getDescription());
		return item;
	}

	
}
