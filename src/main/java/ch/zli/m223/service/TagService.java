package ch.zli.m223.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Tags;

@ApplicationScoped
public class TagService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Tags createTag(Tags tags) {
        entityManager.persist(tags);
        return tags;
    }

    public List<Tags> findAllTags() {
        var query = entityManager.createQuery("FROM Tags", Tags.class);
        return query.getResultList();
    }
    
    @Transactional
    public Tags findById(Long id) {
        return entityManager.find(Tags.class, id);
    }

    @Transactional
    public void update(Tags tags) {
        entityManager.merge(tags);
    }

    @Transactional
    public void delete(Tags tags){
        entityManager.remove(tags);
    }
}
