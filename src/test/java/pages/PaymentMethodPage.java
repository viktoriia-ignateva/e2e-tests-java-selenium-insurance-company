package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodPage extends BasePage {
    private final By continueButton = By.xpath("//button[normalize-space()=\"Weiter zur Bezahlung\"]");

    // Constructor
    public PaymentMethodPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public By getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
