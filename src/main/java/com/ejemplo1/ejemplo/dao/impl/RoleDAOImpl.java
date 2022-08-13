package com.ejemplo1.ejemplo.dao.impl;

import com.ejemplo1.ejemplo.dao.RoleDAO;
import com.ejemplo1.ejemplo.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getAll() {
        String hql = "FROM Role as r";
        return (List<Role>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Role getIdRole(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role register(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Override
    public void delete(long id) {
        Role role = getIdRole(id);
        entityManager.remove(role);
    }
    
}
