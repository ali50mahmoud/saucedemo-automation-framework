package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BooksApiClient {
    
    private static final String BASE_URL = ConfigReader.getApiBaseUrl();
    
    static {
        RestAssured.baseURI = BASE_URL;
    }
    
    public Response getApiStatus() {
        return given()
                .when()
                .get("/status")
                .then()
                .extract().response();
    }
    
    public Response getBooks() {
        return given()
                .when()
                .get("/books")
                .then()
                .extract().response();
    }
    
    public String getAuthToken() {
        Map<String, String> clientInfo = new HashMap<>();
        clientInfo.put("clientName", "TestClient");
        clientInfo.put("clientEmail", "testclient" + System.currentTimeMillis() + "@example.com");
        
        Response response = given()
                .contentType("application/json")
                .body(clientInfo)
                .when()
                .post("/api-clients/")
                .then()
                .extract().response();
        
        return response.jsonPath().getString("accessToken");
    }
    
    public Response submitOrder(String authToken, String bookId, String customerName) {
        Map<String, Object> order = new HashMap<>();
        order.put("bookId", Integer.parseInt(bookId));
        order.put("customerName", customerName);
        
        return given()
                .header("Authorization", "Bearer " + authToken)
                .contentType("application/json")
                .body(order)
                .when()
                .post("/orders")
                .then()
                .extract().response();
    }
    
    public Response getOrders(String authToken) {
        return given()
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/orders")
                .then()
                .extract().response();
    }
}