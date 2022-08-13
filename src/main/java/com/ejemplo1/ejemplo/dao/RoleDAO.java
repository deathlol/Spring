package com.ejemplo1.ejemplo.dao;

import com.ejemplo1.ejemplo.models.Role;

import java.util.List;

public interface RoleDAO {

    //Trae todos los roles
    List<Role> getAll();

    //Trae un role
    Role getIdRole(long id);

    //Inserta un role
    Role register(Role role);

    //Actualiza un role
    Role update(Role role);

    //Elimina un role
    void delete(long id);

}
