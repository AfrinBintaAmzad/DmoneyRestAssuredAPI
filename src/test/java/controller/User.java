package controller;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class User extends Setup {
    UserModel loginModel = new UserModel("salman@roadtocareer.net", "1234");

    public User() throws IOException {
        initConfig();
    }


    private String message;

    public void callLoginAPIWithInvalidCredentials() {
        UserModel loginModel = new UserModel("wrong@roadtocareer.net", "12345");

        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .body(loginModel)
                        .when()
                        .post("/user/login");


        JsonPath jsonResponse = res.jsonPath();
        String message = jsonResponse.get("message");
        setMessage(message);
    }

    public void callLoginAPIWithValidCredentials() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .body(loginModel)
                        .when()
                        .post("/user/login");

        JsonPath jsonResponse = res.jsonPath();
        String token = jsonResponse.get("token");
        String message = jsonResponse.get("message");

        Utils.setEnvVariable("token", token);
        System.out.println(token);
        System.out.println(message);
        setMessage(message);
    }

    public void createUser() throws ConfigurationException {
        Utils utils = new Utils();
        utils.generateRandomUser();
        UserModel regModel = new UserModel(utils.getName(), "1930", utils.getEmail(), utils.generatePhoneNumber(), "1830123440", "Customer");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(regModel)
                        .when()
                        .post("/user/create");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Customer_id", jsonResponse.get("user.id").toString());
        Utils.setEnvVariable("Customer_name", jsonResponse.get("user.name"));
        Utils.setEnvVariable("Customer_email", jsonResponse.get("user.email"));
        Utils.setEnvVariable("Customer_phone_number", jsonResponse.get("user.phone_number"));

        System.out.println(message);
        String message = jsonResponse.get("message");
        setMessage(message);


    }

    public void createAgent() throws ConfigurationException {
        Utils utils = new Utils();
        utils.generateRandomUser();
        UserModel regModel = new UserModel(utils.getName(), "1940", utils.getEmail(), utils.generatePhoneNumber(), "1830123430", "Agent");
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(regModel)
                        .when()
                        .post("/user/create");
        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Agent_id", jsonResponse.get("user.id").toString());
        Utils.setEnvVariable("Agent_name", jsonResponse.get("user.name"));
        Utils.setEnvVariable("Agent_email", jsonResponse.get("user.email"));
        Utils.setEnvVariable("Agent_phone_number", jsonResponse.get("user.phone_number"));

        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void searchUserByInvalidPhonenumber() throws ConfigurationException, IOException {

        RestAssured.baseURI = prop.getProperty("base_url");

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/user/search/phonenumber/76067067067");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }


    public void searchUserByValidPhonenumber() throws ConfigurationException, IOException {

        RestAssured.baseURI = prop.getProperty("base_url");
        String PhoneNumber = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/user/search/phonenumber/" + PhoneNumber)
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonReponse = res.jsonPath();
        System.out.println(jsonReponse.get().toString());
        String message = jsonReponse.get("message");
        setMessage(message);
    }

    public void searchAgentByInvalidPhonenumber() throws ConfigurationException, IOException {

        RestAssured.baseURI = prop.getProperty("base_url");

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/user/search/phonenumber/99099099099");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void searchAgentByValidPhonenumber() throws ConfigurationException, IOException {

        RestAssured.baseURI = prop.getProperty("base_url");
        String PhoneNumber = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/user/search/phonenumber/" + PhoneNumber)
                        .then()
                        .assertThat().statusCode(200).extract().response();

        JsonPath jsonReponse = res.jsonPath();
        System.out.println(jsonReponse.get().toString());
        String message = jsonReponse.get("message");
        setMessage(message);
    }


}
