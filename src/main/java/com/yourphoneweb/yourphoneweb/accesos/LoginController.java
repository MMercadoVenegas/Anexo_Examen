package com.yourphoneweb.yourphoneweb.accesos;

import com.yourphoneweb.yourphoneweb.model.UserEntity;
import com.yourphoneweb.yourphoneweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public boolean login(@RequestBody UserEntity user) {
        return loginService.login(user);
    }

    @PostMapping("register-user")
    public void register(@RequestBody UserEntity user) {
        loginService.saveUser(user);
    }

}
