package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.InventoryTransaction;
@Repository
public interface InventoryTransactionRepo extends CrudRepository<InventoryTransaction, String>{

}
