package ch.zli.m223.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

    @Transactional
    public Reservation getReservationById(Long id) {
        return entityManager.find(Reservation.class, id);
    }

    @Transactional
    public void deleteReservation(Reservation reservation) {
        entityManager.remove(reservation);
    }

    @Transactional
    public void updateReservation(Reservation reservation) {
        entityManager.merge(reservation);
    }

    @Transactional
    public Reservation createReservation(Reservation reservation) {
        entityManager.persist(reservation);
        return reservation;
    }

    public List<Reservation> getAcceptedReservations() {
        var query = entityManager.createQuery("FROM Reservation WHERE status = 'accepted'", Reservation.class);
        return query.getResultList();
    }

    public List<Reservation> getUserReservations(Long id) {
        var query = entityManager.createQuery("FROM Reservation WHERE id = :id", Reservation.class);
        query.setParameter("id", id); 
        return query.getResultList();
    }

}
