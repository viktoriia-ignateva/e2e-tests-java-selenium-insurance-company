import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import utils.PageLoadHelper;

public class CreateNewPolicyTest extends BaseTest{
    private CertificatesPage certificatesPage;
    private NewPolicyCreatingProductPage newPolicyCreatingProductPage;
    private NewPolicyCreatingCustomerPage newPolicyCreatingCustomerPage;
    private NewPolicyCreatingConfirmationPage newPolicyCreatingConfirmationPage;
    private PaymentMethodPage paymentMethodPage;
    private PaymentDetailsPage paymentDetailsPage;

    @BeforeTest
    public void beforeTest() {
        LoginPage loginPage = new LoginPage(driver);
        certificatesPage = new CertificatesPage(driver);
        newPolicyCreatingProductPage = new NewPolicyCreatingProductPage(driver);
        newPolicyCreatingCustomerPage = new NewPolicyCreatingCustomerPage(driver);
        newPolicyCreatingConfirmationPage = new NewPolicyCreatingConfirmationPage(driver);
        paymentMethodPage = new PaymentMethodPage(driver);
        paymentDetailsPage = new PaymentDetailsPage(driver);

        // Login
        loginPage.login();
    }

    @Test
    public void setNewPolicyCreatingProductPage() {
        // Fill in product page fields
        certificatesPage.clickNewButton();
        PageLoadHelper.waitForElement(driver, newPolicyCreatingProductPage.getCountryDropdown());
        newPolicyCreatingProductPage.selectOptionFromCountryDropdown();
        newPolicyCreatingProductPage.selectOptionFromProductNameDropdown();
        newPolicyCreatingProductPage.selectOptionFromTariffNameDropdown();
        newPolicyCreatingProductPage.selectOptionFromCategoryNameDropdown();
        newPolicyCreatingProductPage.selectOptionFromDurationDropdown();
        newPolicyCreatingProductPage.selectOptionFromFrequencyDropdown();
        newPolicyCreatingProductPage.selectOptionFromClassNameDropdown();
        newPolicyCreatingProductPage.setCertificateSerialNumber("123");
        newPolicyCreatingProductPage.clickContinueButton();

        // Fill in customer page fields
        PageLoadHelper.waitForElement(driver, newPolicyCreatingCustomerPage.getFirstNameField());
        newPolicyCreatingCustomerPage.setFirstName("test first name");
        newPolicyCreatingCustomerPage.setLastName("test last name");
        newPolicyCreatingCustomerPage.setEmail("test@test.com");
        newPolicyCreatingCustomerPage.setStreet("Berliner str.");
        newPolicyCreatingCustomerPage.setHouseNumber("10");
        newPolicyCreatingCustomerPage.setPostalCode("10100");
        newPolicyCreatingCustomerPage.setCity("Berlin");
        newPolicyCreatingCustomerPage.setCountry("DE");
        newPolicyCreatingCustomerPage.clickContinueButton();

        // Mark confirmation page checkboxes
        PageLoadHelper.waitForElement(driver, newPolicyCreatingConfirmationPage.getCheckboxes());
        newPolicyCreatingConfirmationPage.checkAllCheckboxes();
        newPolicyCreatingConfirmationPage.clickContinueButton();

        // Continue with card payment
        PageLoadHelper.waitForElement(driver, paymentMethodPage.getContinueButton());
        paymentMethodPage.clickContinueButton();

        // Fill in card details and confirm
        PageLoadHelper.waitForElement(driver, paymentDetailsPage.getPaymentDetailsIframe());
        paymentDetailsPage.choosePaymentDetailsIframe();
        PageLoadHelper.waitForElement(driver, paymentDetailsPage.getCardNumberField());
        paymentDetailsPage.setCardNumber("4242424242424242");
        paymentDetailsPage.setExpiryDate("1125");
        paymentDetailsPage.setCvc("111");
        paymentDetailsPage.leaveIframe();
        paymentDetailsPage.clickContinueButton();
    }

    // Unfortunately, I wasn't finish the test within the given time frame.
    // I intended to create reusable functions for filling in fields on each page, allowing for efficient test case development in the future.
    // Additionally, I planned to implement assertions to verify the successful creation of a new policy and ensure
    // the correctness of the filled data, as well as confirm that the new policy appears in the list on the base page.
}