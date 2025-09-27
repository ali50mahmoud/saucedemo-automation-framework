package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {
    
    private LoginPage loginPage;
    private ProductsPage productsPage;
    
    public LoginSteps() {
        this.loginPage = new LoginPage();
        this.productsPage = new ProductsPage();
    }
    
    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_saucedemo_login_page() {
        loginPage.navigateToLoginPage();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");
    }
    
    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }
    
    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Products page should be displayed");
        Assert.assertEquals(productsPage.getPageTitle(), "Products", "Page title should be 'Products'");
    }
    
    @Then("I should see error message {string}")
    public void i_should_see_error_message(String expectedError) {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed");
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, 
            "Expected error: " + expectedError + ", but got: " + actualError);
    }
    
    @Then("I should see login page elements")
    public void i_should_see_login_page_elements() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page elements should be visible");
    }
    
    @Given("I login successfully as a standard user")
    public void i_login_successfully_as_a_standard_user() {
        loginPage.navigateToLoginPage();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Login should be successful");
    }
    
    @When("I logout from the application")
    public void i_logout_from_the_application() {
        productsPage.logout();
    }
    
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Should be redirected to login page after logout");
    }
}