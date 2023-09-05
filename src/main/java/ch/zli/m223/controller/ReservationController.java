package ch.zli.m223.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.eclipse.microprofile.openapi.annotations.Operation;

import java.util.List;

import ch.zli.m223.service.ReservationService;
import ch.zli.m223.model.Reservation;

@Path("/reservation")
public class ReservationController {
    @Inject
    ReservationService reservationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all reservations", description = "get reservations")
    public List<Reservation> getReservations() {
        return reservationService.getAll();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Operation(summary = "delete reservation", description = "deletes reservation by id")
    public Response deleteReservation(@PathParam("id") Long id) {
        Reservation existingReservation = reservationService.getReservationById(id);

        reservationService.deleteReservation(existingReservation);

        return Response.status(200, "deleted").build();
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "get reservation by id", description = "returns reservation")
    public Reservation getReservationById(@PathParam("id") Long id) {
        return reservationService.getReservationById(id);
    }

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Creates a new entry.", description = "Creates a new entry and returns the newly added entry.")
    public Reservation create(Reservation reservation) {
       return reservationService.createReservation(reservation);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "updates reservation", description = "updates reservation")
    public Response updateUser(@PathParam("id") Long id, Reservation updatedReservation) {
        Reservation existingReservation = reservationService.getReservationById(id);

        existingReservation.setStatus(updatedReservation.getStatus());
        existingReservation.setEndDate(updatedReservation.getEndDate());
        existingReservation.setStartDate(updatedReservation.getStartDate());

        reservationService.updateReservation(existingReservation);

        return Response.status(201, "updated").build();
    }


    @GET
    @Path("/accepted")
    @Operation(summary = "get all accepted reservations", description = "get accepted reservations")
    public List<Reservation> getAcceptedReservations() {
        return reservationService.getAcceptedReservations();
    }

    @GET
    @Path("/user/{id}")
    @Operation(summary = "get user reservations", description = "returns all reservations of user")
    public List<Reservation> getUserReservations(@PathParam("id") Long id) {
        return reservationService.getUserReservations(id);
    }



}
