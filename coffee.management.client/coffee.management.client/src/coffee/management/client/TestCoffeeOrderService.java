package coffee.management.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import coffee.management.web.data.CoffeeOrder;

public class TestCoffeeOrderService {

    private static String webServiceUrl = "http://localhost:8080/coffee.management.web/api/coffee-orders";

    public static void main(String[] args) {
        // Test Creating Coffee Order
        CoffeeOrder espressoOrder = new CoffeeOrder();
        espressoOrder.setCoffeeName("Espresso");
        espressoOrder.setPrice(2.5);
        espressoOrder.setQuantity(1);

        createCoffeeOrder(espressoOrder);

        // Test Deleting Coffee Order
        deleteCoffeeOrder(1); // Assuming the order id is 1, replace it with the actual order id
    }

    private static void createCoffeeOrder(CoffeeOrder coffeeOrder) {
        System.out.println("Creating Coffee Order...");

        WebClient webClient = WebClient.create(webServiceUrl + "/create")
                .type(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE);

        Response response = webClient.post(coffeeOrder);

        System.out.println("HTTP status: " + response.getStatus());

        if (response.getStatus() == Response.Status.CREATED.getStatusCode()) {
            System.out.println("Coffee Order created successfully.");
        } else {
            System.out.println("Failed to create Coffee Order. HTTP status: " + response.getStatus());
        }
    }

    private static void deleteCoffeeOrder(int orderId) {
        System.out.println("Deleting Coffee Order...");

        WebClient webClient = WebClient.create(webServiceUrl + "/" + orderId);
        webClient.accept(MediaType.APPLICATION_JSON);

        Response response = webClient.delete();

        System.out.println("HTTP status: " + response.getStatus()); // Add this line

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            System.out.println("Coffee Order deleted successfully.");
        } else {
            System.out.println("Failed to delete Coffee Order. HTTP status: " + response.getStatus());
        }
    }
}