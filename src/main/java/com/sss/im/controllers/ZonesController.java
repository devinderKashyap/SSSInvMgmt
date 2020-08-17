package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.GeneralInventoryDAO;
import com.sss.im.models.Zone;

@RestController
@RequestMapping("${api.v1.baseurl}/zones")
public class ZonesController {
	
	@Autowired
	GeneralInventoryDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Zone> getAllZones(){
		return dao.getAllInventoryZones();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Zone saveZone(@RequestBody Zone zone){
		return dao.addInventoryZones(zone);
	}

	@RequestMapping(method=RequestMethod.DELETE,value="/{zoneName}")
	public void deleteZone(@PathVariable String zoneName){
		dao.deleteInventoryZones(zoneName);
	}
}
