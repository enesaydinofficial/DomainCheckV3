package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;

    @BeforeTest
    public void Initialize() {

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.DAYS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);

    }

    @AfterTest
    public void TearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}
