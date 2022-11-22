package com.ehb.Elecrtonics.Service;

import com.ehb.Elecrtonics.Model.AuthenticationToken;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.dao.UserDao;
import com.ehb.Elecrtonics.dto.ResponseDto;
import com.ehb.Elecrtonics.dto.SigninDto;
import com.ehb.Elecrtonics.dto.SigninResponseDto;
import com.ehb.Elecrtonics.dto.SignupDto;
import com.ehb.Elecrtonics.exceptions.AuthenticationErrorException;
import com.ehb.Elecrtonics.exceptions.newException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service
public class UserService {
@Autowired
AuthenticationService authenticationService;
    @Autowired
private UserDao userDao;
@Transactional
    public ResponseDto signUp(SignupDto signupDto) {

        if(Objects.nonNull(userDao.findByEmail(signupDto.getEmail())))
        {
    throw new newException("user already exist");
        }
        String encryptPassword= signupDto.getPassword();
        try{
            encryptPassword=hashPassword(signupDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user=new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(),encryptPassword);
userDao.save(user);
       final AuthenticationToken authenticationToken=new AuthenticationToken(user);
authenticationService.saveToken(authenticationToken);
        ResponseDto responseDto=new ResponseDto("success","dummy response");
    return responseDto;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md= MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest=md.digest();
        String hash= DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SigninResponseDto signIn(SigninDto signinDto)  {
User user=userDao.findByEmail(signinDto.getEmail());
if (Objects.isNull(user))
{
throw new AuthenticationErrorException("user is not valid");

}
        try {
           if(!user.getPassword().equals(hashPassword(signinDto.getPassword())))
           {
               throw new AuthenticationErrorException("wrong password");

           }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
AuthenticationToken token =authenticationService.getToken(user);
        if(Objects.isNull(token))
        {
            throw new newException("token is not present");

        }
        return new SigninResponseDto("succes",token.getToken());
    }

    public Iterable<User> listUser() {
        return userDao.findAll();
    }
}
