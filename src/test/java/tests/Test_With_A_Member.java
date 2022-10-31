package tests;

import PageObjectModel.*;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class Test_With_A_Member extends BaseTest {
    private static Logger logger = Logger.getLogger(Test_With_A_Member.class.getName());
    HomePage homePage;

    @Test(priority = 1)
    public void openHomePage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.acceptCookies();
        logger.info("Çerezler Kabul Edildi");
    }

    @Test(priority = 2)
    public void clickLoginButton() {
        homePage.clickLoginButton();
        logger.info("Login Ekranına Gidildi.");
    }

    LoginPage loginPage;

    @Test(priority = 3)
    public void login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login();
        logger.info("Giriş Yapıldı.");
        homePage.checkUser();
    }

    @Test(priority = 4)
    public void search_a_product() throws InterruptedException {
        homePage.typeProductName("kitap");
        homePage.clickSearchButton();
        logger.info("ürün Araması Yapıldı.");
    }

    ProductPage productPage;

    @Test(priority = 5)
    public void clickFirstProduct() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.clickFirstProduct();
    }

    @Test(priority = 6)
    public void clickAllSellers() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.addProductsToBasket();
        logger.info("Tüm Satıcılar Görüntülendi.");
    }

    OrderPage orderPage;

    @Test(priority = 7)
    public void addProductsToBasket() throws InterruptedException {
        orderPage = new OrderPage(driver);
        orderPage.addProductsToBasket();
        logger.info("Sepete gidildi.");
    }

    BasketPage basketPage;

    @Test(priority = 8)
    public void checkProductsInCart() {
        basketPage = new BasketPage(driver);
        basketPage.checkProductsInCart();
        logger.info("Ürünlerin sepette olduğu doğrulandı.");
    }
}
