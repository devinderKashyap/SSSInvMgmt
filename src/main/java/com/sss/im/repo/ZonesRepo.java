package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.Zone;
@Repository
public interface ZonesRepo extends CrudRepository<Zone, String>{

}
