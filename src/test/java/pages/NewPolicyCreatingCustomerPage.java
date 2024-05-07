package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewPolicyCreatingCustomerPage extends BasePage {
    private final By firstNameField = By.id("input-createCertificate_firstName");
    private final By lastNameField = By.id("input-createCertificate_lastName");
    private final By emailField = By.id("input-createCertificate_email");
    private final By streetField = By.id("input-createCertificate_streetName");
    private final By houseNumberField = By.id("input-createCertificate_streetNumber");
    private final By postalCodeField = By.id("input-createCertificate_zip");
    private final By cityField = By.id("input-createCertificate_city");
    private final By countryField = By.id("input-createCertificate_country");
    private final By continueButton = By.xpath("//button[normalize-space()=\"Weiter\"]");

    // Constructor
    public NewPolicyCreatingCustomerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public By getFirstNameField() {
        return firstNameField;
    }

    public void setFirstName(String firstName) { driver.findElement(firstNameField).sendKeys(firstName); }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setStreet(String street) {
        driver.findElement(streetField).sendKeys(street);
    }

    public void setHouseNumber(String houseNumber) {
        driver.findElement(houseNumberField).sendKeys(houseNumber);
    }

    public void setPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void setCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }

    public void setCountry(String country) {
        driver.findElement(countryField).sendKeys(country);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
