package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import utils.CustomListener;

import static com.codeborne.selenide.Selenide.*;
import static managers.PageManager.*;

public class StartPage extends BasePage {

    private ElementsCollection listViewAllButtons = $$x("//span[contains(text(), 'Посмотреть все')]");

    public SearchResultPage search(String search) {
        getSearchBox().sendKeys(search, Keys.ENTER);
        getPageReadyFlag().shouldBe(Condition.appear).shouldBe(Condition.disappear);
        CustomListener.addScreenshot();
        listViewAllButtons.forEach(SelenideElement::click);
        return getPageManager().getSearchResultPage();
    }
}