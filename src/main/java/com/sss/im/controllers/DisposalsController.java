package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.InventoryDisposal;

@RestController
@RequestMapping("/disposals")
public class DisposalsController {
	
	@Autowired
	GeneralInventoryDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<InventoryDisposal> getAllInventoryDisposals(){
		return dao.getAllInventoryDisposal();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public InventoryDisposal saveInventoryTransaction(@RequestBody InventoryDisposal disposal){
		System.out.println("ItemsController.saveInventory() "+disposal);
		return dao.addInventoryDisposal(disposal);
	}

}
