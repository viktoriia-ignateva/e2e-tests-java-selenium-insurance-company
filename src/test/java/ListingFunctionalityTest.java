import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CertificatesPage;
import pages.LoginPage;
import utils.PageLoadHelper;

public class ListingFunctionalityTest extends BaseTest {
    CertificatesPage certificatesPage;

    @BeforeTest
    public void setup() {
        // Open the Certificates page
        LoginPage loginPage = new LoginPage(driver);
        certificatesPage = new CertificatesPage(driver);
        // Login
        loginPage.login();
    }

    @BeforeMethod
    public void beforeEachTest() {
        // Refresh the page
        driver.navigate().refresh();
    }

    @Test
    public void testListRendering() {
        Assert.assertTrue(certificatesPage.getList().isDisplayed(), "Listing is not displayed");
        Assert.assertEquals(certificatesPage.getListItems().size(), 25, "Listing is have any items");
    }

    @Test
    public void testListingSorting() {
        // Check the initial order of the listing
        WebElement firstItemBeforeSorting = certificatesPage.getListItems().getFirst();
        Assert.assertEquals(firstItemBeforeSorting.findElement(By.cssSelector(":nth-child(1)")).getText(), "200000421630", "Listing is not sorted");

        // Sort the listing
        driver.findElement(By.cssSelector(CertificatesPage.LIST_SORT_SELECTOR)).click();
        PageLoadHelper.waitForElement(driver, By.cssSelector(CertificatesPage.LIST_SELECTOR));
        Assert.assertTrue(driver.findElement(By.cssSelector(CertificatesPage.LIST_SELECTOR)).isDisplayed(), "Listing is not displayed");

        // Check if the listing is sorted
        WebElement firstItemAfterSorting = certificatesPage.getListItems().getFirst();
        Assert.assertEquals(firstItemAfterSorting.findElement(By.cssSelector(":nth-child(1)")).getText(), "200000421604", "Listing is not sorted");
    }

    @Test
    public void testListingFiltering() {
        PageLoadHelper.waitForElement(driver, By.cssSelector(CertificatesPage.LIST_FILTER_SELECTOR));

        // Filter the listing
        driver.findElement(By.cssSelector(CertificatesPage.LIST_FILTER_SELECTOR)).click();
        PageLoadHelper.waitForElement(driver, By.cssSelector(CertificatesPage.LIST_FILTER_MENU_ITEM_POLICY_NUMBER));
        driver.findElement(By.cssSelector(CertificatesPage.LIST_FILTER_MENU_ITEM_POLICY_NUMBER)).click();
        PageLoadHelper.waitForElement(driver, By.cssSelector(CertificatesPage.LIST_FILTER_INPUT));

        // Enter the filter value
        driver.findElement(By.cssSelector(CertificatesPage.LIST_FILTER_INPUT)).sendKeys("200000421604");
        driver.findElement(By.cssSelector(CertificatesPage.LIST_FILTER_INPUT)).sendKeys(Keys.ENTER);

        PageLoadHelper.waitForElement(driver, By.cssSelector(CertificatesPage.LIST_SELECTOR));

        // Check if the listing is filtered
        Assert.assertEquals(driver.findElements(By.cssSelector(CertificatesPage.LIST_ITEM_SELECTOR)).size(), 1, "Listing is not filtered");
        WebElement filterItem = driver.findElements(By.cssSelector(CertificatesPage.LIST_ITEM_SELECTOR)).getFirst();
        Assert.assertEquals(filterItem.findElement(By.cssSelector(":nth-child(1)")).getText(), "200000421604", "Listing is not filtered");
    }
}
