package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static Logger logger = Logger.getLogger(BasketPage.class.getName());

    By products = By.cssSelector(".product_name_3Lh3t>a");

    public void checkProductsInCart() {
        List<WebElement> productsList = findElements(products);
        List<String> ExpectedList = new ArrayList<>();
        ExpectedList.add("Vazgeçilmez Olmanın Sırrı - Esra Ezmeci");
        ExpectedList.add("Vazgeçilmez Olmanın Sırrı - Esra Ezmeci");
        List<String> actualList = new ArrayList<String>();

        for (int i = 0; i < productsList.size(); i++)
            actualList.add(productsList.get(i).getText());

        checkStringList(ExpectedList, actualList);
    }
}
