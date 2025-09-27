package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    
    private final By usernameInput = By.xpath("//input[@id='user-name']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");
    private final By loginLogo = By.xpath("//div[@class='login_logo']");
    
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
        waitForElementToBeVisible(loginLogo);
    }
    
    public void enterUsername(String username) {
        enterText(usernameInput, username);
    }
    
    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }
    
    public void clickLogin() {
        clickElement(loginButton);
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }
    
    public boolean isLoginPageDisplayed() {
        return isElementDisplayed(loginLogo);
    }
}