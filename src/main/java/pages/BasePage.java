package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import managers.PageManager;
import utils.Product;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    protected static List<Product> cart = new ArrayList<>();

    private SelenideElement searchBox = $x("//input[@placeholder='Искать на Ozon']");
    private SelenideElement pageReadyFlag = $x("//div[@class='a9' or @class='a']");

    protected PageManager pageManager = PageManager.getPageManager();

    public SelenideElement getSearchBox() {
        return searchBox;
    }

    public SelenideElement getPageReadyFlag() {
        return pageReadyFlag;
    }

    public void addReport() {
        StringBuilder result = new StringBuilder();
        cart.forEach(element -> {
            result.append(element).append("\n");
        });

        result.append("\nСамый дорогой товар:\n");
        result.append(cart.stream().max(Product::compare).get().toString());

        Allure.addAttachment("Report", "text/plain", String.valueOf(result), "txt");
    }

    public static List<Product> getCart() {
        return cart;
    }
}
