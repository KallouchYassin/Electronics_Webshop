package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role,String> {
}
