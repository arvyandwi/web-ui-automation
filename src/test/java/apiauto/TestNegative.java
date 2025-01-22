package apiauto;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestNegative {

    @Test
    public void testNegativeGetUser() {
        String userId = "14";
        given()
                .when()
                .get("https://reqres.in/api/unknown/"+userId)
                .then()
                .log()
                .all()
                .assertThat().statusCode(404)
                .assertThat().body("$", Matchers.anEmptyMap());
    }

    @Test
    public void testNegativeRegisterUnsuccessful() {
        String valueEmail = "test_email@email";

        JSONObject bodyObj = new JSONObject();
        bodyObj.put("email", valueEmail);

        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when()
                .post("https://reqres.in/api/register/")
                .then()
                .log()
                .all()
                .assertThat().statusCode(400)
                .assertThat().body("$", Matchers.hasKey("error"));
    }
}
