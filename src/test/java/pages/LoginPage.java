package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageLoadHelper;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "login_username")
    WebElement usernameField;

    @FindBy(id = "login_password")
    WebElement passwordField;

    @FindBy(css = "form > div > button[type=\"submit\"]")
    WebElement loginButton;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void login() {
        driver.get("https://insurance-manager.sb-qa-candidatetask.sisu.sh/login");
        usernameField.sendKeys("testsellingpartner4@simplesurance.de");
        passwordField.sendKeys("TestSellingPartner4Pass");
        loginButton.click();

        // Assert that the user is redirected to the Certificates page
        PageLoadHelper.waitForRedirect(driver, CertificatesPage.URL, Duration.ofSeconds(15));
        PageLoadHelper.waitForPageToLoad(driver, Duration.ofSeconds(15));
    }
}
