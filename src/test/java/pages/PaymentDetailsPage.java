package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PaymentDetailsPage extends BasePage {
    private final By cardNumberField = By.cssSelector("input[name=\"cardnumber\"]");
    private final By paymentDetailsIframe = By.cssSelector("iframe[name^=\"__privateStripeFrame\"]");
    private final By expiryDateField = By.cssSelector("input[name=\"exp-date\"]");
    private final By cvcField = By.cssSelector("input[name=\"cvc\"]");
    private final By continueButton = By.xpath("//button[normalize-space()=\"Kostenpflichtig bestellen\"]");

    // Constructor
    public PaymentDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public By getPaymentDetailsIframe() {
        return paymentDetailsIframe;
    }

    public By getCardNumberField() {
        return cardNumberField;
    }

    public void choosePaymentDetailsIframe() {
        WebElement iframe = driver.findElement(paymentDetailsIframe);
        driver.switchTo().frame(iframe);
    }

    public void leaveIframe() {
        driver.switchTo().defaultContent();
    }

    public void setCardNumber(String cardNumber) {
        driver.findElement(cardNumberField).sendKeys(cardNumber);
    }

    public void setExpiryDate(String expiryDate) {
        driver.findElement(expiryDateField).sendKeys(expiryDate);
    }

    public void setCvc(String cvc) {
        driver.findElement(cvcField).sendKeys(cvc);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
