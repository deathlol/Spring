package com.ejemplo1.ejemplo.dao;

import com.ejemplo1.ejemplo.models.Permiso;

import java.util.List;

public interface PermisoDAO {

    //Trae todos los permisos
    List<Permiso> getAll();

    //Trae un permiso
    Permiso getIdPermiso(long id);

    //Inserta un permiso
    Permiso register(Permiso permiso);

    //Actualiza un permiso
    Permiso update(Permiso permiso);

    //Elimina un permiso
    void delete(long id);
}
