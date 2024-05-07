package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PageLoadHelper;

public class NewPolicyCreatingProductPage extends BasePage {
    private final By countryDropdown = By.id("country-select");
    private final By countryDropdownListOption = By.cssSelector("#menu-country-select > div > ul > li[data-value=\"DE\"]");
    private final By productNameDropdown = By.id("product-name-select");
    private final By productNameDropdownListOption = By.cssSelector("#menu-product-name-select > div > ul > li");
    private final By tariffNameDropdown = By.id("tariff-name-select");
    private final By tariffNameDropdownListOption = By.cssSelector("#menu-tariff-name-select > div > ul > li");
    private final By categoryNameDropdown = By.id("category-name-select");
    private final By CategoryNameDropdownListOption = By.cssSelector("#menu-category-name-select > div > ul > li");
    private final By durationDropdown = By.id("duration-select");
    private final By durationDropdownListOption = By.cssSelector("#menu-duration-select > div > ul > li");
    private final By frequencyDropdown = By.id("frequency-select");
    private final By frequencyDropdownListOption = By.cssSelector("#menu-frequency-select > div > ul > li");
    private final By classNameDropdown = By.id("class-name-select");
    private final By classNameDropdownListOption = By.cssSelector("#menu-class-name-select > div > ul > li[data-value=\"PDCODE677395\"]");
    private final By certificateSerialNumberField = By.id("input-createCertificate_serialNumber");
    private final By continueButton = By.xpath("//button[normalize-space()=\"Weiter\"]");

    // Constructor
    public NewPolicyCreatingProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public By getCountryDropdown() {
        return countryDropdown;
    }

    private void selectDropdownOption(By dropdown, By option) {
        driver.findElement(dropdown).click();
        PageLoadHelper.waitForElement(driver, option);
        driver.findElement(option).click();
    }

    public void selectOptionFromCountryDropdown() {
        selectDropdownOption(countryDropdown, countryDropdownListOption);
    }

    public void selectOptionFromProductNameDropdown() {
        selectDropdownOption(productNameDropdown, productNameDropdownListOption);
    }

    public void selectOptionFromTariffNameDropdown() {
        selectDropdownOption(tariffNameDropdown, tariffNameDropdownListOption);
    }

    public void selectOptionFromCategoryNameDropdown() {
        selectDropdownOption(categoryNameDropdown, CategoryNameDropdownListOption);
    }

    public void selectOptionFromDurationDropdown() {
        selectDropdownOption(durationDropdown, durationDropdownListOption);
    }

    public void selectOptionFromFrequencyDropdown() {
        selectDropdownOption(frequencyDropdown, frequencyDropdownListOption);
    }

    public void selectOptionFromClassNameDropdown() {
        selectDropdownOption(classNameDropdown, classNameDropdownListOption);
    }

    public void setCertificateSerialNumber(String username) {
        driver.findElement(certificateSerialNumberField).sendKeys(username);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
