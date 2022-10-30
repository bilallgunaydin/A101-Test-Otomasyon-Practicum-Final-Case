package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

   private static Logger logger = Logger.getLogger(LoginPage.class.getName());

    By userNameElement = By.id("txtUserName");
    By passwordElement = By.id("txtPassword");
    By loginNameElement = By.id("btnLogin");
    By loginUserPasswordElement = By.name("btnEmailSelect");

    public void login() throws InterruptedException {
        sendKey(userNameElement, "hepsiburadatestt@outlook.com");
        click(loginNameElement);
        Thread.sleep(2000);
        sendKey(passwordElement, "Hepsiburada15");
        click(loginUserPasswordElement);
    }
}
