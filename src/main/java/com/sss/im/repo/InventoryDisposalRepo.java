package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.InventoryDisposal;
@Repository
public interface InventoryDisposalRepo extends CrudRepository<InventoryDisposal, String>{

}
