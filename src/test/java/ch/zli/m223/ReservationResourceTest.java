package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class ReservationResourceTest {
    
    
    @Test
    public void testGetReservations() {
        given()
            .when().get("/reservation")
            .then()
            .statusCode(200);
    }

    @Test
    public void testGetReservationById() {
        given()
            .when().get("/reservation/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testGetReservationByIdFail() {
        given()
            .when().get("/reservation/100")
            .then()
            .statusCode(204);
    }

    @Test
    public void testGetAcceptedReservations() {
        given()
            .when().get("/reservation/accepted")
            .then()
            .statusCode(200);
    }

    @Test
    public void testGetReservationUserId() {
        given()
            .when().get("/reservation/user/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testDeleteReservation() {
        given()
        .when().delete("/reservation/10")
        .then()
          .statusCode(200);
    }

    // Test is built to let an error in the console, because entry to delete wont be found
    @Test
    public void testDeleteReservationFail() {
        given()
        .when().delete("/reservation/100")
        .then()
          .statusCode(500);
    }

    //update & create reservation not working

}
