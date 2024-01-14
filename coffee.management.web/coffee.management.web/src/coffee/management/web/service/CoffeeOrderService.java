package coffee.management.web.service;

import java.util.ArrayList;
import java.util.List;

import coffee.management.web.data.CoffeeOrder;

public class CoffeeOrderService {

    private static List<CoffeeOrder> coffeeOrders = new ArrayList<>();

    public List<CoffeeOrder> getAllCoffeeOrders() {
        return coffeeOrders;
    }

    public CoffeeOrder getCoffeeOrderById(int orderId) {
        for (CoffeeOrder order : coffeeOrders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public CoffeeOrder createCoffeeOrder(CoffeeOrder coffeeOrder) {
        int orderId = generateOrderId();
        coffeeOrder.setOrderId(orderId);
        coffeeOrders.add(coffeeOrder);
        return coffeeOrder;
    }

    public boolean deleteCoffeeOrder(int orderId) {
        CoffeeOrder orderToRemove = null;
        for (CoffeeOrder order : coffeeOrders) {
            if (order.getOrderId() == orderId) {
                orderToRemove = order;
                break;
            }
        }

        if (orderToRemove != null) {
            coffeeOrders.remove(orderToRemove);
            return true;
        } else {
            return false;
        }
    }

    private int generateOrderId() {
        // Your logic to generate a unique order ID
        // For simplicity, we'll just use the current size of the list + 1
        return coffeeOrders.size() + 1;
    }
}