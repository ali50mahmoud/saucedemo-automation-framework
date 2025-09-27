package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import api.BooksApiClient;

public class ApiSteps {
    
    private BooksApiClient apiClient;
    private Response response;
    private String authToken;
    private String orderId;
    
    public ApiSteps() {
        this.apiClient = new BooksApiClient();
    }
    
    @When("I check the API status")
    public void i_check_the_api_status() {
        response = apiClient.getApiStatus();
    }
    
    @Then("API status should be {string}")
    public void api_status_should_be(String expectedStatus) {
        Assert.assertEquals(response.getStatusCode(), 200);
        String actualStatus = response.jsonPath().getString("status");
        Assert.assertEquals(actualStatus, expectedStatus);
    }
    
    @When("I request the list of books")
    public void i_request_the_list_of_books() {
        response = apiClient.getBooks();
    }
    
    @Then("I should receive a list of books")
    public void i_should_receive_a_list_of_books() {
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("").size() > 0);
    }
    
    @Given("I have a valid API authentication token")
    public void i_have_a_valid_api_authentication_token() {
        authToken = apiClient.getAuthToken();
        Assert.assertNotNull(authToken, "Auth token should not be null");
    }
    
    @When("I submit a new order for book {string} with customer name {string}")
    public void i_submit_a_new_order_for_book_with_customer_name(String bookId, String customerName) {
        response = apiClient.submitOrder(authToken, bookId, customerName);
    }
    
    @Then("the order should be created successfully")
    public void the_order_should_be_created_successfully() {
        Assert.assertEquals(response.getStatusCode(), 201);
        orderId = response.jsonPath().getString("orderId");
        Assert.assertNotNull(orderId, "Order ID should not be null");
    }
    
    @Then("I should be able to retrieve the order")
    public void i_should_be_able_to_retrieve_the_order() {
        Response ordersResponse = apiClient.getOrders(authToken);
        Assert.assertEquals(ordersResponse.getStatusCode(), 200);
    }
}