package controller;

import com.github.javafaker.PhoneNumber;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import model.TransactionModel;
import model.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@Getter
@Setter
public class Transaction extends Setup {

    private String message;

    public Transaction() throws IOException {
        initConfig();
    }

    public void depositMoneyFromSystemToAgent() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", "019283635362", 10);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void depositMoneyWithSystem() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", agent_phone_number, 5000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Agent_TrnxId", jsonResponse.get("trnxId").toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void depositMoneyWithInsufficientAmount() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", agent_phone_number, 5);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }
    public void depositMoneyWithSufficientAmount() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        TransactionModel transModel = new TransactionModel("SYSTEM", agent_phone_number, 100);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Agent_TrnxId", jsonResponse.get("trnxId").toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void depositMoneyAgentToCustomerWithInvalidPhoneNumber() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transModel = new TransactionModel(agent_phone_number, "0343721931", 10);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());

        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void depositMoneyFromCustomerToInvalidAgent() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_number = prop.getProperty("Agent_phone_number");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transModel = new TransactionModel("0139238247", customer_Phone_Number, 10);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());

        String message = jsonResponse.get("message");
        setMessage(message);

    }



    public void depositMoneyFromAgentToCustomer() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        String agent_phone_number = prop.getProperty("Agent_phone_number");

        TransactionModel transModel = new TransactionModel(agent_phone_number, customer_Phone_Number, 2000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        Utils.setEnvVariable("Customer_TrnxId", jsonResponse.get("trnxId").toString());

        String message = jsonResponse.get("message");
        setMessage(message);


    }

    public void depositMoneyFromAgentToInvalidCustomer() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        String agent_phone_number = prop.getProperty("Agent_phone_number");

        TransactionModel transModel = new TransactionModel(agent_phone_number, "03981371253", 200);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transModel)
                        .when()
                        .post("/transaction/deposit");


        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);


    }

    public void checkCustomerBalanceWithInValidCredentials() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String PhoneNumber = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/balance/01872347367");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void checkCustomerBalanceWithValidCredentials() throws ConfigurationException {
        RestAssured.baseURI = prop.getProperty("base_url");
        String PhoneNumber = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/balance/" + PhoneNumber);

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);
    }
    public void checkStatementWithInvalidTransactionId() {
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/search/TXN130111");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void checkStatementWithValidTransactionId() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String TransactionId = prop.getProperty("Agent_TrnxId");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/search/" + TransactionId);

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);


    }

    public void  withdrawMoneyFromInvalidAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_Phone_Number, "01521332333", 1000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }
    public void withdrawMoneyFromValidAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_Phone_Number = prop.getProperty("Customer_phone_number");
        String agent_Phone_Number = prop.getProperty("Agent_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_Phone_Number, agent_Phone_Number, 60);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void withdrawMoneyWithInsufficientBalance() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_Number = prop.getProperty("Agent_phone_number");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, agent_phone_Number, 5);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");
        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }


    public void withdrawMoneyWithSufficientBalance() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_Number = prop.getProperty("Agent_phone_number");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, agent_phone_Number, 1000);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/withdraw");
        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void sendMoneyFromCustomerToAgent() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String agent_phone_Number = prop.getProperty("Agent_phone_number");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, agent_phone_Number, 20);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }


    public void sendMoneyCustomerToCustomerWithInvalidCreds() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01293843734", 20);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void sendMoneyCustomerToCustomerWithvalidCredentials() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01502918191", 20);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void sendMoneyCustomerToCustomerWithInvalidAmount() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01502918191", 3);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void sendMoneyCustomerToCustomerWithvalidAmount() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        TransactionModel transactionModel = new TransactionModel(customer_phone_Number, "01502918191", 500);

        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .body(transactionModel)
                        .when()
                        .post("/transaction/sendmoney");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void checkCustomerStatementWithInvalidPhoneNumber() {
        RestAssured.baseURI = prop.getProperty("base_url");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/statement/01#55566678");

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }

    public void checkCustomerStatementWithValidPhoneNumber() {
        RestAssured.baseURI = prop.getProperty("base_url");
        String customer_phone_Number = prop.getProperty("Customer_phone_number");
        Response res =
                given()
                        .contentType("application/json")
                        .header("Authorization", prop.getProperty("token"))
                        .header("X-AUTH-SECRET-KEY", "ROADTOSDET")
                        .when()
                        .get("/transaction/statement/" + customer_phone_Number);

        JsonPath jsonResponse = res.jsonPath();
        System.out.println(jsonResponse.get().toString());
        String message = jsonResponse.get("message");
        setMessage(message);

    }
}
