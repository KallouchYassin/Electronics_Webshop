package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.Role;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.dao.RoleDao;
import com.ehb.Elecrtonics.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public User registerUser(User user)
    {
return userDao.save(user);
    }

    public void initRolesAndUser()
    {
        Role adminRole=new Role();
        adminRole.setRole_name("Admin");
        adminRole.setRole_description("Admin role ");
   roleDao.save(adminRole);

        Role userRole=new Role();
        userRole.setRole_name("User");
        userRole.setRole_description("Default role ");
        roleDao.save(userRole);

        User adminUser =new User();
        adminUser.setUserFirstname("admin");
        adminUser.setUserFirstname("admin");
        adminUser.setUserPassword("admin1234");
        adminUser.setUsername("admin");

        Set<Role> adminRoles= new HashSet<>();

        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User firstUser =new User();
        firstUser.setUserFirstname("firstUser");
        firstUser.setUserFirstname("firstUser");
        firstUser.setUserPassword("firstUser1234");
        firstUser.setUsername("firstUser");
        Set<Role> userRoles= new HashSet<>();
        userRoles.add(userRole);
firstUser.setRole(userRoles);
        userDao.save(firstUser);
    }
}
