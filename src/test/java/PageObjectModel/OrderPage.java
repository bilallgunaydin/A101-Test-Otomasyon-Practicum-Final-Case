package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private static Logger logger = Logger.getLogger(ProductPage.class.getName());
    By firstSellerElement = By.xpath("(//button[@class='add-to-basket button'])[1]");
    By secondSellerElement = By.xpath("(//button[@class='add-to-basket button'])[2]");
    By cancelButtonElement = By.xpath("//a[@class='checkoutui-Modal-2iZXl']");
    By continueElement = By.xpath("//button[contains(text(),'Sepete git')]");
    public void addProductsToBasket() throws InterruptedException {
        WebElement firstSeller = findElement(firstSellerElement);
        scrollToElement(firstSeller);
        Thread.sleep(2000);
        click(firstSellerElement);
        logger.info("Ürün birinci satıcıdan alındı.");
        Thread.sleep(2000);
        click(cancelButtonElement);
        Thread.sleep(2000);
        logger.info("İkinci satıcıdan ürünü almak için form kapatıldı.");
        WebElement secondSeller = findElement(secondSellerElement);
        scrollToElement(secondSeller);
        click(secondSellerElement);
        Thread.sleep(2000);
        logger.info("Ürün ikinci satıcıdan alındı.");
        Thread.sleep(2000);
        click(continueElement);
        Thread.sleep(2000);
    }
}
