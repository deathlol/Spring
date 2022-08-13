package com.ejemplo1.ejemplo.services;

import com.ejemplo1.ejemplo.dao.RoleDAO;
import com.ejemplo1.ejemplo.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDAO roleDAO;

    //Trae todos los roles
    public List<Role> getAll() {
        return roleDAO.getAll();
    }

    //Trae un role
    public Role getIdRole(long id) {
        return roleDAO.getIdRole(id);
    }

    //Inserta un role
    public Role register(Role role) {
        return roleDAO.register(role);
    }

    //Actualiza un role
    public Role update(Role role) {
        return  roleDAO.update(role);
    }

    //Elimina un role
    public void delete(long id) {
        roleDAO.delete(id);
    }

}
