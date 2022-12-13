package com.ehb.Elecrtonics.Controller;

import com.ehb.Elecrtonics.Model.Category;
import com.ehb.Elecrtonics.Model.User;
import com.ehb.Elecrtonics.Service.UserService;
import com.ehb.Elecrtonics.dto.ResponseDto;
import com.ehb.Elecrtonics.dto.SigninDto;
import com.ehb.Elecrtonics.dto.SignupDto;
import com.ehb.Elecrtonics.dto.SigninResponseDto;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto)
    {
        return userService.signUp(signupDto);
    }

    @PostMapping("/signin")
    public SigninResponseDto signin(@RequestBody SigninDto signinDto) throws AuthenticationException {
        return userService.signIn(signinDto);
    }
    @GetMapping("/list")
    public Iterable<User> listCategory()
    {
        return userService.listUser();
    }


}
