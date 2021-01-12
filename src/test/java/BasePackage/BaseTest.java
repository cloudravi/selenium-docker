package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver(ITestContext context) throws MalformedURLException {
//        String path = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", path + "/drivers/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String host = "localhost";
        DesiredCapabilities dc;

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        } else {
            dc = new DesiredCapabilities(DesiredCapabilities.chrome());
        }

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http:" + host + ":4444/wd/hub";
        dc.setCapability("name", context.getCurrentXmlTest().getName());
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);
    }

    @AfterTest
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }
}
