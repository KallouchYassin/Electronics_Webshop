package com.ehb.Elecrtonics.Controller;

import com.ehb.Elecrtonics.Model.Role;
import com.ehb.Elecrtonics.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
     @Autowired
     private RoleService roleService;
     @PostMapping("/createRole")
     public Role createRole(@RequestBody Role r)
     {
return roleService.createRole(r);
     }
}
