package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.models.InventoryItem;
import com.sss.im.repo.InventoryItemDAO;

@RestController
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	InventoryItemDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<InventoryItem> getAllInventory(){
		return dao.getAllItems();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public InventoryItem saveInventory(@RequestBody InventoryItem item){
		System.out.println("ItemsController.saveInventory() "+item);
		return dao.createItem(item);
	}

}
