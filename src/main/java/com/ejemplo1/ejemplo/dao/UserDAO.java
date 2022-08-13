package com.ejemplo1.ejemplo.dao;

import com.ejemplo1.ejemplo.models.User;
import java.util.List;

public interface UserDAO {

    //Trae todos los usuarios
    List<User> getAll();

    //Trae un usuario
    User getIdUser(long id);

    //Inserta un usuario
    User register(User user);

    //Actualiza un usuario
    User update(User user);

    //Elimina un usuario
    void delete(long id);

    User login(User user);
}
