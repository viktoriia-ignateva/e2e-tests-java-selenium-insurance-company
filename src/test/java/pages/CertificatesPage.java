package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageLoadHelper;

import java.util.List;

public class CertificatesPage extends BasePage {
    public static final String CREATE_INSURANCE_BUTTON_SELECTOR = "#root > div > div > div.MuiGrid-root.MuiGrid-container.css-1d3bbye > div:nth-child(1) > div > div:nth-child(2) > button";
    public static final String LIST_SELECTOR = "table[data-testid=\"policy-list\"]";
    public static final String LIST_ITEM_SELECTOR = "table[data-testid=\"policy-list\"] > tbody > tr";
    public static final String LIST_SORT_SELECTOR = "table[data-testid=\"policy-list\"] > thead > tr > th[data-sort=\"POLICY_NUMBER\"] > [data-testid=\"ExpandMoreIcon\"]";
    public static final String LIST_FILTER_SELECTOR = "div[role=\"combobox\"]";
    public static final String LIST_FILTER_MENU_ITEM_POLICY_NUMBER = "li[data-value=\"policy_number\"]";
    public static final String LIST_FILTER_INPUT = "input[type=\"text\"]";

    public static final String URL = "https://insurance-manager.sb-qa-candidatetask.sisu.sh/certificates";

    @FindBy(css = "a[href=\"/policy/import\"] > button")
    WebElement importButton;

    @FindBy(css = "input[type=file]")
    WebElement fileInput;

    @FindBy(css = "a[href=\"/policy/create\"] > button")
    WebElement newButton;

    @FindBy(css = "table[data-testid=\"policy-list\"]")
    WebElement list;

    @FindAll(@FindBy(css = "table[data-testid=\"policy-list\"] > tbody > tr"))
    List<WebElement> listItems;

    // Constructor
    public CertificatesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public WebElement getList() {
        return list;
    }

    public List<WebElement> getListItems() {
        return listItems;
    }

    public void clickImportButton() {
        importButton.click();
    }

    public void uploadCSVFile(String filePath) {
        fileInput.sendKeys(filePath);
    }

    public void clickNewButton() {
        PageLoadHelper.waitForElement(driver, By.cssSelector("a[href=\"/policy/create\"] > button"));
        newButton.click();
    }
}
