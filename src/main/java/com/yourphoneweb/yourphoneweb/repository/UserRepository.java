package com.yourphoneweb.yourphoneweb.repository;

import com.yourphoneweb.yourphoneweb.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserEntity login(UserEntity user) {

        UserEntity userEntity = jdbcTemplate.queryForObject("SELECT * FROM users WHERE correo = ? AND contrasenia = ?", new Object[]{user.getCorreo(), user.getContrasenia()},
                (rs, rowNum) ->
                        new UserEntity(
                                rs.getInt("id"),
                                rs.getString("contrasenia"),
                                rs.getString("correo"),
                                rs.getString("nombre"),
                                rs.getInt("edad"),
                                rs.getString("fecha_nacimiento")
                        ));
        return userEntity;
    }

    public UserEntity obtenerUsuario(UserEntity user) {

        UserEntity userEntity = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{user.getId()},
                (rs, rowNum) ->
                        new UserEntity(
                                rs.getInt("id"),
                                rs.getString("contrasenia"),
                                rs.getString("correo"),
                                rs.getString("nombre"),
                                rs.getInt("edad"),
                                rs.getString("fecha_nacimiento")
                        ));
        return userEntity;
    }

    public List<UserEntity> obtenerUsuarios() {
        String sql = "SELECT * FROM users";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new UserEntity(
                                rs.getInt("id"),
                                rs.getString("contrasenia"),
                                rs.getString("correo"),
                                rs.getString("nombre"),
                                rs.getInt("edad"),
                                rs.getString("fecha_nacimiento")
                        )
        );
    }

    public void register(UserEntity user) {
        jdbcTemplate.update("INSERT INTO users (contrasenia, correo, nombre, edad, fecha_nacimiento) values (?,?,?,?,?)", user.getContrasenia(), user.getCorreo(), user.getNombre(), user.getEdad(), user.getFechaNacimiento());
    }

    public void update(int user, UserEntity userEntity) {
        jdbcTemplate.update("UPDATE users SET contrasenia = ?, correo = ?, nombre = ?, edad = ?, fecha_nacimiento = ? WHERE id = ?", userEntity.getContrasenia(), userEntity.getCorreo(), userEntity.getNombre(), userEntity.getEdad(), userEntity.getFechaNacimiento(), user);
    }

    public void delete(int user) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", user);
    }
}
