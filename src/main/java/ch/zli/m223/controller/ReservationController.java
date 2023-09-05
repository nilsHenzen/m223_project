package ch.zli.m223.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
}
