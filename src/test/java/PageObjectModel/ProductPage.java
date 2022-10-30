package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static Logger logger = Logger.getLogger(ProductPage.class.getName());

    By firstProductElement = By.xpath("//li[@class=\"productListContent-zAP0Y5msy8OHn5z7T_K_\"][1]");

    public void clickFirstProduct() throws InterruptedException {
        Thread.sleep(1000);
        WebElement firstProduct = findElement(firstProductElement);
        scrollToElement(firstProduct);
        click(firstProductElement);
        logger.info("İlk Ürün Seçildi.");
    }

    By allSellersElement = By.xpath("//a[@class='optionsLength']");

    public void addProductsToBasket() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement allSellers = findElement(allSellersElement);
                scrollToElement(allSellers);
                click(allSellersElement);
                logger.info("Tüm Satıcılar Görüldü.");
            }
        }
    }
}
