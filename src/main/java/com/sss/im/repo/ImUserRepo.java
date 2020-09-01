package com.sss.im.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sss.im.models.ImUser;
@Repository
public interface ImUserRepo extends CrudRepository<ImUser, String>{

}
