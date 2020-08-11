package stepdefs;

import io.cucumber.java.ru.Когда;

import static managers.PageManager.*;

public class Steps {

    @Когда("^Выполнить поиск \"(.*)\"")
    public void search(String search) {
        getPageManager().getStartPage().search(search);
    }

    @Когда("^Указать \"([а-яА-Яa-zA-Z]+)\" \"(от|до)\" \"([0-9]+)\"")
    public void selectFromOrTofilter(String filter, String fromOrTo, String value) {
        getPageManager().getSearchResultPage().selectFromOrTofilter(filter, fromOrTo, value);
    }

    @Когда("^Отметить \"(.*)\"")
    public void selectOptionFilter(String option) {
        getPageManager().getSearchResultPage().selectOptionFilter(option);
    }

    @Когда("^Отметить цвет \"(.*)\"")
    public void selectColorFilter(String color) {
        getPageManager().getSearchResultPage().selectColorFilter(color);
    }

    @Когда("Добавить в корзину первые 8 четных товаров")
    public void addToCart() {
        getPageManager().getSearchResultPage().addToCart();
    }

    @Когда("Добавить в корзину все четные товары")
    public void addToCartAll() {
        getPageManager().getSearchResultPage().addToCartAll();
    }

    @Когда("Перйти в корзину")
    public void goToCart() {
        getPageManager().getSearchResultPage().goToCart();
    }

    @Когда("Проверить, что все добавленные ранее товары находятся в корзине")
    public void checkCart() {
        getPageManager().getCartPage().checkCart();
    }

    @Когда("^Проверить, что отображается текст \"(.*)\" \"(.*)\"")
    public void checkProductCount(String yourCart, String productCount) {
        getPageManager().getCartPage().checkProductCount(yourCart, productCount);
    }

    @Когда("Удалить все товары из корзины")
    public void deleteAllProducts() {
        getPageManager().getCartPage().deleteAllProducts();
    }

    @Когда("Проверить, что корзина не содержит никаких товаров")
    public void checkEmptyCart() {
        getPageManager().getCartPage().checkEmptyCart();
    }

    @Когда("Добавить отчет")
    public void generateReport() {
        getPageManager().getStartPage().addReport();
    }
}
