package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.AuthenticationToken;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.dao.TokenDao;
import com.ehb.Elecrtonics.exceptions.AuthenticationErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    @Autowired
    TokenDao tokenDao;

    public  void saveToken(AuthenticationToken authenticationToken) {
        tokenDao.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
    return tokenDao.findByUser(user);
    }
public User getUser(String token)
{
    final AuthenticationToken authenticationToken=tokenDao.findByToken(token);
    if(Objects.isNull(authenticationToken))
    {
        return null;
    }
    return authenticationToken.getUser();

}
    public void authenticate(String token){
        if(Objects.isNull(token))
        {
            throw new AuthenticationErrorException("token is not present");
        }
        if (Objects.isNull(getUser(token)))
        {
            throw new AuthenticationErrorException("token not valid");
        }
    }
}
