package com.yourphoneweb.yourphoneweb.accesos;

import com.yourphoneweb.yourphoneweb.model.UserEntity;
import com.yourphoneweb.yourphoneweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    LoginService loginService;

    @GetMapping("users")
    public List<UserEntity> getAllUsers() {
        return loginService.getUsers();
    }

    @GetMapping("users/{id}")
    public UserEntity getAllUsers(@PathVariable("id") int id) {
        return loginService.getUserById(id);
    }

    @PutMapping("users/{id}")
    public boolean updateUser(@PathVariable("id") int id, @RequestBody UserEntity user) {
        loginService.updateUser(id, user);
        return true;
    }


}
