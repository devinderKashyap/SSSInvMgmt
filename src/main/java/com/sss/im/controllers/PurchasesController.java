package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.InventoryPurchase;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {
	
	@Autowired
	GeneralInventoryDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<InventoryPurchase> getAllInventoryPurchases(){
		return dao.getAllInventoryPurchases();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public InventoryPurchase saveInventoryTransaction(@RequestBody InventoryPurchase purchase){
		System.out.println("ItemsController.saveInventory() "+purchase);
		return dao.addInventoryPurchase(purchase);
	}

}
