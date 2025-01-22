package apiauto;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class TestReqres {

    @Test
    public void testGetListUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .assertThat().body("total", Matchers.equalTo(12))
                .assertThat().body("page", Matchers.equalTo(2));
    }

    @Test
    public void testPostCreateUser() {
        String valueName = "Indra";
        String valueJob = "Advisor";

        JSONObject bodyObj = new JSONObject();
        bodyObj.put("name", valueName);
        bodyObj.put("job", valueJob);

        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log()
                .all()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(valueName))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
    }

    @Test
    public void testPutUser() {
        RestAssured.baseURI = "https://reqres.in";

        int userId = 2;
        String newName = "Indra New Put";

        String fname = given().when().get("/api/users/"+userId).getBody().jsonPath().get("data.first_name");
        String lname = given().when().get("/api/users/"+userId).getBody().jsonPath().get("data.last_name");
        String avatar = given().when().get("/api/users/"+userId).getBody().jsonPath().get("data.avatar");
        String email = given().when().get("/api/users/"+userId).getBody().jsonPath().get("data.email");
        System.out.println("Previous Name Before PUT: "+ fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("id", userId);
        bodyMap.put("email", email);
        bodyMap.put("first_name", newName);
        bodyMap.put("last_name", lname);
        bodyMap.put("avatar", avatar);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .put("/api/users/"+userId)
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName))
                .assertThat().body("$", Matchers.hasKey("updatedAt"));
    }

    @Test
    public void testPatchUser() {
        RestAssured.baseURI = "https://reqres.in";

        int userId = 3;
        String newName = "Indra New Patch";

        String fname = given().when().get("/api/users/"+userId).getBody().jsonPath().get("data.first_name");
        System.out.println("Previous Name Before PATCH: "+ fname);

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("first_name", newName);
        JSONObject jsonObject = new JSONObject(bodyMap);

        given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(jsonObject.toString())
                .patch("/api/users/"+userId)
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .assertThat().body("first_name", Matchers.equalTo(newName))
                .assertThat().body("$", Matchers.hasKey("updatedAt"));
    }

    @Test
    public void testDeleteUser() {
        RestAssured.baseURI = "https://reqres.in";

        int userId = 4;

        given()
                .log()
                .all()
                .when()
                .delete("/api/users/"+userId)
                .then()
                .log()
                .all()
                .assertThat().statusCode(204);
    }

    @Test
    public void testValidateJsonSchemaGetSingleUser() {
        RestAssured.baseURI = "https://reqres.in";

        int userId = 5;

        File file = new File("src/test/resources/jsonSchema/GetSingleUserSchema.json");

        given()
                .log()
                .all()
                .when()
                .get("/api/users/"+userId)
                .then()
                .log()
                .all()
                .assertThat().statusCode(200)
                .assertThat().body(JsonSchemaValidator.matchesJsonSchema(file));
    }
}
