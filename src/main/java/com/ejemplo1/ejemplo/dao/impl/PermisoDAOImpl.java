package com.ejemplo1.ejemplo.dao.impl;

import com.ejemplo1.ejemplo.dao.PermisoDAO;
import com.ejemplo1.ejemplo.models.Permiso;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermisoDAOImpl implements PermisoDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Permiso> getAll() {
        String hql = "FROM Permiso as p";
        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Permiso getIdPermiso(long id) {
        return entityManager.find(Permiso.class, id);
    }

    @Override
    public Permiso register(Permiso permiso) {
        entityManager.merge(permiso);
        return permiso;
    }

    @Override
    public Permiso update(Permiso permiso) {
        entityManager.merge(permiso);
        return permiso;
    }

    @Override
    public void delete(long id) {
        Permiso permiso = getIdPermiso(id);
        entityManager.remove(permiso);
    }

}
