package pages;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    
    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By addBackpackToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private final By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
    private final By cartBadge = By.xpath("//span[@class='shopping_cart_badge']");
    private final By menuButton = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By logoutLink = By.xpath("//a[@id='logout_sidebar_link']");
    
    public String getPageTitle() {
        return getText(pageTitle);
    }
    
    public void addBackpackToCart() {
        clickElement(addBackpackToCartButton);
    }
    
    public void openCart() {
        clickElement(cartIcon);
    }
    
    public String getCartItemCount() {
        try {
            return getText(cartBadge);
        } catch (Exception e) {
            return "0";
        }
    }
    
    public void logout() {
        clickElement(menuButton);
        waitForElementToBeVisible(logoutLink);
        clickElement(logoutLink);
    }
    
    public boolean isProductsPageDisplayed() {
        return isElementDisplayed(pageTitle);
    }
}