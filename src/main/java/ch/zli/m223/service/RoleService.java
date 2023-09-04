package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.zli.m223.model.Role;

@ApplicationScoped
public class RoleService {
    
    @Inject
    EntityManager entityManager;

    public List<Role> findAll() {
        var query = entityManager.createQuery("FROM Role", Role.class);
        return query.getResultList();
    }

}
