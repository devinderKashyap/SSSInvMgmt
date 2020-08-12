package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.ZoneGeneralInventory;
import com.sss.im.models.compositekeys.ZoneInventoryID;
@Repository
public interface ZoneGeneralInventoryRepo extends CrudRepository<ZoneGeneralInventory, ZoneInventoryID>{

}
