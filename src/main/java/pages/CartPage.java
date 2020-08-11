package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import utils.Product;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CartPage extends BasePage {

    private ElementsCollection cartBlocks = $$x("//div[@class='a8l5']//span[@style='color: rgb(0, 26, 52);']");
    private SelenideElement cartInfo = $x("//div[@class='a2p8']");
    private SelenideElement deleteButton = $x("//span[contains(text(), 'Удалить выбранные')]");
    private SelenideElement deleteConfirmButton = $x("//div[text()='Удалить']");
    private SelenideElement emptyCartHeader = $x("//h1[contains(text(), 'Корзина пуста')]");

    public CartPage checkCart () {
        List<String> temp = new ArrayList<>();
        System.out.println(cartBlocks.size());
        cartBlocks.forEach(el -> temp.add(el.getText()));
        System.out.println(temp);
        for (Product res : cart) {
            System.out.println(res.getName());
            Assertions.assertTrue(temp.contains(res.getName()), "ОШИБОЧКА ВЫШЛА");
        }

        return this;
    }

    public CartPage checkProductCount (String yourCart, String productCount) {
        cartInfo.shouldHave(Condition.text(yourCart));
        cartInfo.shouldHave(Condition.text(productCount));
        return this;
    }

    public CartPage deleteAllProducts () {
        deleteButton.click();
        deleteConfirmButton.click();
        getPageReadyFlag().shouldBe(Condition.disappear);
        return this;
    }

    public CartPage checkEmptyCart () {
        emptyCartHeader.shouldBe(Condition.appear);
        return this;
    }




}
