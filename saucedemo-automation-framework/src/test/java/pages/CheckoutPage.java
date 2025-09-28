package pages;


import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {
    
    private final By firstNameInput = By.xpath("//input[@id='first-name']");
    private final By lastNameInput = By.xpath("//input[@id='last-name']");
    private final By postalCodeInput = By.xpath("//input[@id='postal-code']");
    private final By continueButton = By.xpath("//input[@id='continue']");
    private final By finishButton = By.xpath("//button[@id='finish']");
    private final By confirmationMessage = By.xpath("//h2[@class='complete-header']");
    private final By checkoutTitle = By.xpath("//span[@class='title']");
    
    public void enterFirstName(String firstName) {
        enterText(firstNameInput, firstName);
    }
    
    public void enterLastName(String lastName) {
        enterText(lastNameInput, lastName);
    }
    
    public void enterPostalCode(String postalCode) {
        enterText(postalCodeInput, postalCode);
    }
    
    public void clickContinue() {
        clickElement(continueButton);
    }
    
    public void clickFinish() {
        clickElement(finishButton);
    }
    
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
    }
    
    public void completePurchase() {
        clickFinish();
    }
    
    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
    
    public boolean isCheckoutComplete() {
        return isElementDisplayed(confirmationMessage);
    }
    
    public boolean isCheckoutStepOneDisplayed() {
        return isElementDisplayed(checkoutTitle) && getText(checkoutTitle).equals("Checkout: Your Information");
    }
}