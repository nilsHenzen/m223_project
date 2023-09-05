package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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

    public Application_User login(String username) {
        TypedQuery<Application_User> query = entityManager.createQuery("FROM Application_User WHERE username = :username", Application_User.class);
        query.setParameter("username", username); 

        return query.getSingleResult();
    }

    @Transactional
    public Application_User getUserById(Long id) {
        return entityManager.find(Application_User.class, id);
    }

    @Transactional
    public Application_User createUser(Application_User application_User) {
        entityManager.persist(application_User);
        return application_User;
    }

    @Transactional
    public void updateUser(Application_User application_User) {
        entityManager.merge(application_User);
    }

    @Transactional
    public void deleteUser(Application_User application_User) {
        entityManager.remove(application_User);
    }

}
