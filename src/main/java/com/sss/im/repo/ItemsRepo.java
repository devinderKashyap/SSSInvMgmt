package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.InventoryItem;
@Repository
public interface ItemsRepo extends CrudRepository<InventoryItem, String>{

}
