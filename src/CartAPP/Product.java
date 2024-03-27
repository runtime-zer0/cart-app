package CartAPP;

import java.util.Objects;

public class Product {

    private int key;
    private String name;
    private int price;

    public Product (int key, String name, int price) {
        this.key = key;
        this.name = name;
        this.price = price;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }
}
