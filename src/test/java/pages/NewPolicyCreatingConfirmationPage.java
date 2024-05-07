package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewPolicyCreatingConfirmationPage extends BasePage {
    private final By checkboxes = By.xpath("//input[@type='checkbox']");
    private final By continueButton = By.xpath("//button[normalize-space()=\"Versicherung erstellen\"]");

    // Constructor
    public NewPolicyCreatingConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public By getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getAllCheckboxes() {
        return driver.findElements(checkboxes);
    }

    public void checkAllCheckboxes() {
        List<WebElement> checkboxes = getAllCheckboxes();
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
