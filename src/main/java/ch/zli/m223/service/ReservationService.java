package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.util.List;

import ch.zli.m223.model.Reservation;

@ApplicationScoped
public class ReservationService {
    @Inject
    EntityManager entityManager;

    public List<Reservation> getAll() {
         var query = entityManager.createQuery("FROM Reservation", Reservation.class);
        return query.getResultList();

    }

}
