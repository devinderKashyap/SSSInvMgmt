package com.sss.im.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.models.InventoryLog;
import com.sss.im.repo.InventoryLogDAO;

@RestController
@RequestMapping("/logs")
public class InventoryLogsController {
	
	@Autowired
	InventoryLogDAO dao; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<InventoryLog> getAllLogs(){
		
		return dao.getAlllogs();
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void addLog(@RequestBody InventoryLog log){
		
		dao.createLog(log);
	}

}
