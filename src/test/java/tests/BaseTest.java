package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


public abstract class BaseTest {
    protected WebDriver driver;
    private static Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeClass
    public void setup() {

        if (driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("–disable-notifications");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--allow-insecure-localhost");
            chromeOptions.addArguments("--acceptInsecureCerts");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            chromeOptions.addArguments("--disable-extensions");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            logger.info("Test Başlatıldı");
            driver.get("https://www.hepsiburada.com/");
            logger.info("Hepsiburada Sitesi Açıldı");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
    }

    @AfterClass
    public void tearDown() {
        logger.info("Test Tamamlandı");
        driver.quit();
    }

}
