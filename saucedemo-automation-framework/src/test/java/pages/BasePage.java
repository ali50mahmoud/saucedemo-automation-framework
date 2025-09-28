package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Hooks;

public class BasePage {
    
    protected WebDriver driver;
    
    public BasePage() {
        this.driver = Hooks.getDriver();
    }
    
    protected void waitForElementToBeVisible(By locator) {
        Hooks.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void clickElement(By locator) {
        waitForElementToBeVisible(locator);
        driver.findElement(locator).click();
    }
    
    protected void enterText(By locator, String text) {
        waitForElementToBeVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    protected String getText(By locator) {
        waitForElementToBeVisible(locator);
        return driver.findElement(locator).getText();
    }
    
    protected boolean isElementDisplayed(By locator) {
        try {
            waitForElementToBeVisible(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}