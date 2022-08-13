package com.ejemplo1.ejemplo.services;

import com.ejemplo1.ejemplo.dao.UserDAO;
import com.ejemplo1.ejemplo.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    //Trae todos los usuarios
    public List<User> getAll() {
        return userDAO.getAll();
    }

    //Trae un usuario
    public User getIdUser(long id) {
        return userDAO.getIdUser(id);
    }

    //Inserta un usuario
    public void register(User user) {
        String hash = generarHash(user.getPassword());
        user.setPassword(hash);
        userDAO.register(user);
    }

    //Actualiza un usuario
    public User update(User user) {
        return  userDAO.update(user);
    }

    //Elimina un usuario
    public void delete(long id) {
        userDAO.delete(id);
    }

    private String generarHash(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 1024 * 1, 1, password);
    }

    public User login(User user) {
        return userDAO.login(user);
    }
}
