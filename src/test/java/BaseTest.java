import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.ConsoleLogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.CopyOnWriteArrayList;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    CopyOnWriteArrayList<ConsoleLogEntry> logs = new CopyOnWriteArrayList<>();

    @BeforeSuite
    protected void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.setProperty("webdriver.chrome.driver", "/Users/viktoriiaignateva/Projects/simplesurance/src/test/resources/chromedriver");
    }

    @AfterSuite
    protected void tearDown() {
        driver.quit();
    }
}
