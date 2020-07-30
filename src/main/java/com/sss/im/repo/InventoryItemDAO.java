package com.sss.im.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.im.models.InventoryItem;
import com.sss.im.models.InventoryLog;

@Service
public class InventoryItemDAO {

	@Autowired
	ItemsRepo repo;
	
	public List<InventoryItem> getAllItems() {
		List<InventoryItem> items = new ArrayList<>();
		repo.findAll().forEach(item->items.add(item));
		return items;
	}
	
	public InventoryItem createItem(InventoryItem item) {
		
		return repo.save(item);
	}
	
}
