package tests;

import PageObjectModel.BasketPage;
import PageObjectModel.HomePage;
import PageObjectModel.OrderPage;
import PageObjectModel.ProductPage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class Test_Without_A_Member extends BaseTest {
    private static Logger logger = Logger.getLogger(Test_Without_A_Member.class.getName());
    HomePage homePage;

    @Test(priority = 1)
    public void search_a_product() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        logger.info("Çerezler Kabul Edildi");
        homePage.typeProductName("kitap");
        homePage.clickSearchButton();
        logger.info("ürün Araması Yapıldı.");
    }

    ProductPage productPage;

    @Test(priority = 2)
    public void clickFirstProduct() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.clickFirstProduct();
    }

    @Test(priority = 3)
    public void clickAllSellers() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.addProductsToBasket();
        logger.info("Tüm Satıcılar Görüntülendi.");
    }

    OrderPage orderPage;

    @Test(priority = 4)
    public void addProductsToBasket() throws InterruptedException {
        orderPage = new OrderPage(driver);
        orderPage.addProductsToBasket();
        logger.info("Sepete gidildi.");
    }

    BasketPage basketPage;

    @Test(priority = 5)
    public void checkProductsInCart() {
        basketPage = new BasketPage(driver);
        basketPage.checkProductsInCart();
        logger.info("Ürünlerin sepette olduğu doğrulandı.");
    }
}
