import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CertificatesPage;
import pages.LoginPage;

import java.io.File;

public class CreateBatchInsurancePoliciesTest extends BaseTest {
    CertificatesPage certificatesPage;
    LoginPage loginPage;
    File uploadFile = new File("src/test/resources/testdata.csv");

    @BeforeTest
    public void beforeTest() {
        certificatesPage = new CertificatesPage(driver);
        loginPage = new LoginPage(driver);

        // Login
        loginPage.login();
    }


    @Test
    public void testCreateBatchInsurancePolicyWithCSV() {
        // Click the Import button
        certificatesPage.clickImportButton();

        // Upload the CSV file
        certificatesPage.uploadCSVFile(uploadFile.getAbsolutePath());

        // assert create insurance button is enabled
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(CertificatesPage.CREATE_INSURANCE_BUTTON_SELECTOR))));

        driver.findElement(By.cssSelector(CertificatesPage.CREATE_INSURANCE_BUTTON_SELECTOR)).click();
    }
}
