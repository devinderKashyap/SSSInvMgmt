package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.Zone;

@RestController
@RequestMapping("/zones")
public class ZonesController {
	
	@Autowired
	GeneralInventoryDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Zone> getAllZones(){
		return dao.getAllInventoryZones();
	}

}
