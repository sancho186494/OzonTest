package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Product;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage extends BasePage {

    private ElementsCollection searchResults = $$x("//div[@class='a1h8 a1i1 a1i0']");
    private ElementsCollection filtersBlocks = $$x("//div[contains(@class, 'filter-block')]");
    private ElementsCollection options = $$x("//span[@class='b9o5' or @class='cn6' or @class='b8m8']");
    private ElementsCollection colors = $$x("//div[@class='b9i5']");
    private SelenideElement cartButton = $x("//span[text()='Корзина']");

    private String inputFromToMarks = ".//p";
    private String input = ".//input";
    private String cartString = ".//div[text()='В корзину']";
    private String productName = ".//a[@class='a2i4 tile-hover-target']";
    private String productPrice = ".//span[@class='a2q6 a2q7' or @class='a2q6']";

    public SearchResultPage selectFromOrTofilter(String filter, String fromOrTo, String value) {
        filtersBlocks.
                findBy(Condition.text(filter)).parent().
                $$x(inputFromToMarks).findBy(Condition.text(fromOrTo)).
                parent().find(By.xpath(input)).doubleClick().sendKeys(value, Keys.ENTER);

        getPageReadyFlag().shouldBe(Condition.disappear);
        getSearchBox().scrollTo();
        return this;
    }

    public SearchResultPage selectOptionFilter(String option) {
        options.findBy(Condition.text(option)).scrollTo().click();
        getSearchBox().scrollTo();
        return this;
    }

    public SearchResultPage selectColorFilter(String color) {
        colors.findBy(Condition.text(color)).scrollTo().click();
        getPageReadyFlag().shouldBe(Condition.disappear);
        getSearchBox().scrollTo();
        return this;
    }

    public SearchResultPage addToCart() {
        getPageReadyFlag().shouldBe(Condition.disappear);

        for (int i = 0; i < 16; i += 2) {
            searchResults.get(i + 1).find(By.xpath(cartString)).click();
            cart.add(new Product(
                    searchResults.get(i + 1).find(By.xpath(productName)).getText(),
                    searchResults.get(i + 1).find(By.xpath(productPrice)).getText()
            ));
        }
        return this;
    }

    public SearchResultPage addToCartAll() {
        getPageReadyFlag().shouldBe(Condition.disappear);
        System.out.println("КОлво:" + searchResults.size());
        for (int i = 0; i < searchResults.size(); i += 2) {
            System.out.println(i);
            searchResults.get(i + 1).find(By.xpath(cartString)).click();
            cart.add(new Product(
                    searchResults.get(i + 1).find(By.xpath(productName)).getText(),
                    searchResults.get(i + 1).find(By.xpath(productPrice)).getText()
            ));
        }
        return this;
    }

    public CartPage goToCart () {
        cartButton.parent().click();
        getPageReadyFlag().shouldBe(Condition.disappear);
        sleep(5000);
        return pageManager.getCartPage();
    }
}
