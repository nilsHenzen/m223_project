package ch.zli.m223;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;


@QuarkusTest
public class RoleResourceTest {

  @Test
  public void testIndexEndpoint() {
    given()
      .when().get("/role")
      .then()
       .statusCode(200);
  }
    
}
