package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.ZoneGeneralInventory;

@RestController
@RequestMapping("${api.v1.baseurl}/zones/inventory")
public class ZoneInventoryController {
	
	@Autowired
	GeneralInventoryDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ZoneGeneralInventory> getAllZoneInvetory(){
		return dao.getAllZoneInventory();
	}

}
