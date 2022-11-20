package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.Role;
import com.ehb.Elecrtonics.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    public Role createRole(Role r)
    {
    return roleDao.save(r);
    }
}
