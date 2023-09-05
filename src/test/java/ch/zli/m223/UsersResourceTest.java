package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class UsersResourceTest {

    @Test
    public void testLoginCorrect() {
        given()
            .header("Authorization", "markus:abc123")
            .when()
            .post("/users/login");

    }

    // Test is built to let an error in the console, because query wont be found
    @Test
    public void testLoginWrong() {
        given()
            .header("Authorization", "fritz:helloworld") 
            .when()
            .post("/users/login");
    }

    @Test
    public void testGetUsers() {
        given()
            .when().get("/users")
            .then()
            .statusCode(200);
    }

    @Test
    public void testGetSingleUser() {
        given()
            .when().get("/users/1")
            .then()
            .statusCode(200);
    }

    @Test
    public void testGetSingleUserFail() {
        given()
            .when().get("/users/100")
            .then()
            .statusCode(204);
    }

    @Test
    public void deleteUser() {
        given()
        .when().delete("/users/10")
        .then()
          .statusCode(200);
    }

    // Test is built to let an error in the console, because entry to delete wont be found
    @Test
    public void deleteUserFail() {
        given()
        .when().delete("/users/100")
        .then()
          .statusCode(500);
    }

    //update & create user not working



}