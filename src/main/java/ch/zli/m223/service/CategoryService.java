package ch.zli.m223.service;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;


import ch.zli.m223.model.Category;


@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    public List<Category> findAllCategories() {
        var query = entityManager.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }
    
    
}
