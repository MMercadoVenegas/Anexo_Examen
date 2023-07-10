package com.yourphoneweb.yourphoneweb.service;

import com.yourphoneweb.yourphoneweb.model.UserEntity;
import com.yourphoneweb.yourphoneweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getUsers() {
        return userRepository.obtenerUsuarios();
    }

    public UserEntity getUserById(int id) {
        return userRepository.obtenerUsuario(new UserEntity(id, null, null, null, 0, null));
    }

    public void saveUser(UserEntity user) {
        userRepository.register(user);
    }

    public void updateUser(int user, UserEntity userEntity) {
        userRepository.update(user, userEntity);
    }

    public void deleteUser(int user) {
        userRepository.delete(user);
    }

    public boolean login(UserEntity user) {

        UserEntity userEntity = userRepository.login(user);

        if (userEntity != null) {
            if (userEntity.getCorreo().equals(user.getCorreo())) {
                if (userEntity.getContrasenia().equals(user.getContrasenia())) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return false;
    }
}
