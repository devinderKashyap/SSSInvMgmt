package com.sss.im.repo;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.sss.im.models.InventoryLog;

@Repository
public interface InventoryLogsRepo extends CrudRepository<InventoryLog, String>{
	
	
}
