package coffee.management.web.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CoffeeOrder {
    private int orderId;
    private String coffeeName;
    private double price;
    private int quantity;

    public CoffeeOrder() {
        // Default constructor required for JAXB
    }

    public CoffeeOrder(int orderId, String coffeeName, double price, int quantity) {
        this.orderId = orderId;
        this.coffeeName = coffeeName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public CoffeeOrder(String coffeeName, double price, int quantity) {
        this.coffeeName = coffeeName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "orderId=" + orderId +
                ", coffeeName='" + coffeeName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}