package com.ejemplo1.ejemplo.services;

import com.ejemplo1.ejemplo.dao.PermisoDAO;
import com.ejemplo1.ejemplo.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    PermisoDAO permisoDAO;

    //Trae todos los permisos
    public List<Permiso> getAll() {
        return permisoDAO.getAll();
    }

    //Trae un permiso
    public Permiso getIdPermiso(long id) {
        return permisoDAO.getIdPermiso(id);
    }

    //Inserta un permiso
    public Permiso register(Permiso permiso) {
        return permisoDAO.register(permiso);
    }

    //Actualiza un permiso
    public Permiso update(Permiso permiso) {
        return  permisoDAO.update(permiso);
    }

    //Elimina un permiso
    public void delete(long id) {
        permisoDAO.delete(id);
    }

}
