package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {
    
    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By checkoutButton = By.xpath("//button[@id='checkout']");
    private final By cartItem = By.xpath("//div[@class='cart_item']");
    private final By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");
    private final By removeButton = By.xpath("//button[contains(text(),'Remove')]");
    
    public String getPageTitle() {
        return getText(pageTitle);
    }
    
    public void proceedToCheckout() {
        clickElement(checkoutButton);
    }
    
    public void continueShopping() {
        clickElement(continueShoppingButton);
    }
    
    public void removeItemFromCart() {
        if (isElementDisplayed(removeButton)) {
            clickElement(removeButton);
        }
    }
    
    public boolean isItemInCart() {
        return isElementDisplayed(cartItem);
    }
    
    public boolean isCartPageDisplayed() {
        return isElementDisplayed(pageTitle) && getText(pageTitle).equals("Your Cart");
    }
}