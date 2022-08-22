package Convenience_Store_Package.Convenience_Store.src.Convenience_Store_Package;

import java.io.Serializable;

public class Product implements Serializable{
    int serial_no;
    String name;
    int price;
    int quantity;
    String expired;

    public Product(int serial_no, String name, int price, int quantity, String expired) {
        this.serial_no = serial_no;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expired = expired;
    }

    public int getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(int serial_no) {
        this.serial_no = serial_no;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public String toString() {
        return "Product{" +
                "serial_no=" + serial_no +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expired='" + expired + '\'' +
                '}';
    }
}
