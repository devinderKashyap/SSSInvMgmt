package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.StoreGeneralInventory;
@Repository
public interface StoreGeneralInventoryRepo extends CrudRepository<StoreGeneralInventory, String>{

}
