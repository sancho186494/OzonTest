package managers;


import pages.CartPage;
import pages.SearchResultPage;
import pages.StartPage;

public class PageManager {

    private static PageManager pageManager;

    private StartPage startPage;
    private SearchResultPage searchResultPage;
    private CartPage cartPage;

    private PageManager(){}

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public SearchResultPage getSearchResultPage() {
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage();
        }
        return searchResultPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }


}
