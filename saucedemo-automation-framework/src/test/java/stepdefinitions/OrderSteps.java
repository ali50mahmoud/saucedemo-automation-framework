package stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductsPage;

public class OrderSteps {
    
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    
    public OrderSteps() {
        this.productsPage = new ProductsPage();
        this.cartPage = new CartPage();
        this.checkoutPage = new CheckoutPage();
    }
    
    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        productsPage.addBackpackToCart();
    }
    
    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        productsPage.openCart();
        Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page should be displayed");
        cartPage.proceedToCheckout();
        Assert.assertTrue(checkoutPage.isCheckoutStepOneDisplayed(), "Checkout step one should be displayed");
    }
    
    @When("I enter checkout information {string} {string} {string}")
    public void i_enter_checkout_information(String firstName, String lastName, String postalCode) {
        checkoutPage.enterCheckoutInformation(firstName, lastName, postalCode);
    }
    
    @When("I complete the purchase")
    public void i_complete_the_purchase() {
        checkoutPage.completePurchase();
    }
    
    @Then("I should see order confirmation message")
    public void i_should_see_order_confirmation_message() {
        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertEquals(confirmation, "Thank you for your order!", 
            "Order confirmation message should be displayed");
    }
    
    @Then("the cart should show {string} items")
    public void the_cart_should_show_items(String expectedCount) {
        String actualCount = productsPage.getCartItemCount();
        Assert.assertEquals(actualCount, expectedCount, 
            "Expected cart count: " + expectedCount + ", but got: " + actualCount);
    }
    
    @When("I remove the product from cart")
    public void i_remove_the_product_from_cart() {
        productsPage.openCart();
        cartPage.removeItemFromCart();
    }
    
    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        String actualCount = productsPage.getCartItemCount();
        Assert.assertEquals(actualCount, "0", "Cart should be empty, but has " + actualCount + " items");
    }
}