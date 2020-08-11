package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private String name;
    private String price;
    private int priceInt;

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
        this.priceInt = convertPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int convertPrice(String price) {
        StringBuilder numb = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(price);
        while(matcher.find()) {
            numb.append(matcher.group());
        }
        return Integer.parseInt(numb.toString());
    }

    public static int compare (Product p1, Product p2){
        if(p1.getPriceInt() > p2.getPriceInt())
            return 1;
        return -1;
    }

    public int getPriceInt() {
        return priceInt;
    }

    public void setPriceInt(int priceInt) {
        this.priceInt = priceInt;
    }

    @Override
    public String toString() {
        return  "Товар: " + name + ", Стоимость: " + price ;
    }
}
