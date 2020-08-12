package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.StoreGeneralInventory;

@RestController
@RequestMapping("/inventory")
public class GeneralInventoryController {
	
	@Autowired
	GeneralInventoryDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<StoreGeneralInventory> getAllInventory(){
		return dao.getAllStoreInventory();
	}
	

}
