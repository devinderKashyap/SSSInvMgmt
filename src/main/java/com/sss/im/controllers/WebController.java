package com.sss.im.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sss.im.models.InventoryLog;
import com.sss.im.repo.InventoryLogDAO;

@Controller
@RequestMapping("/")
public class WebController {
	
	@Autowired
	InventoryLogDAO dao; 
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage(){
		return "imhome";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/imhome")
	public String getIMHomePage(){
		return "imhome";
	}
	
	@GetMapping("/list-logs")
	public String allTasks(HttpServletRequest request){
		request.setAttribute("logs", dao.getAlllogs());
		return "list-logs";
	}
	
	@GetMapping("/add-log")
	public String newTask(HttpServletRequest request){
		request.setAttribute("log", new InventoryLog());
		return "add-log";
	}
	
	@PostMapping("/add-log")
	public String saveTask(@ModelAttribute InventoryLog log, BindingResult bindingResult, HttpServletRequest request){
		dao.createLog(log);
		request.setAttribute("logs", dao.getAlllogs());
		return "list-logs";
	}
}
