package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.InventoryPurchase;
@Repository
public interface InventoryPurchaseRepo extends CrudRepository<InventoryPurchase, String>{

}
