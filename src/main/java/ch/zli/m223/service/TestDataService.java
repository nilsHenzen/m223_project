/**package ch.zli.m223.service;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.model.Application_User;
import ch.zli.m223.model.Role;
import io.quarkus.arc.profile.IfBuildProfile;
import io.quarkus.runtime.StartupEvent;


@IfBuildProfile("dev")
public class TestDataService {
    @Inject
    EntityManager entityManager;

    @Transactional
    void generateData(@Observes StartupEvent event) {
        var role1 = new Role();
        role1.setName("test");
        role1.setId(4L);
        entityManager.persist(role1);

        var user1 = new Application_User();
        user1.setEmail("user1@mail");
        user1.setUSername("user1");
        user1.setFirstName("user");
        user1.setLastnameName("user");
        user1.setPassword("user1");
        user1.setRole(role1);
        entityManager.persist(user1);       
    }
}
 */