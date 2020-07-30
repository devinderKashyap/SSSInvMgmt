package com.sss.im.repo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.im.models.InventoryLog;

@Service
public class InventoryLogDAO {

	@Autowired
	InventoryLogsRepo repo;
	
	public List<InventoryLog> getAlllogs() {
		List<InventoryLog> logs = new ArrayList<>();
		repo.findAll().forEach(log->logs.add(log));
		return logs;
	}
	
	public InventoryLog createLog(InventoryLog log) {
		log.setDate(new Date());
		return repo.save(log);
	}
	
}
