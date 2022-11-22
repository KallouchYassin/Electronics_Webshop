package com.ehb.Elecrtonics.dao;

import com.ehb.Elecrtonics.Model.AuthenticationToken;
import com.ehb.Elecrtonics.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface TokenDao extends CrudRepository<AuthenticationToken,Integer> {


    AuthenticationToken findByUser(User user);
    AuthenticationToken findByToken(String token);

}
