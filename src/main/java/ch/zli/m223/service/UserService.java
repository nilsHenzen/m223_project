package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;

import ch.zli.m223.model.Application_User;

@ApplicationScoped
public class UserService {
    @Inject
    EntityManager entityManager;

    public List<Application_User> findAll() {
        var query = entityManager.createQuery("FROM Application_User", Application_User.class);
        return query.getResultList();
    }

}
