package coffee.management.web.resource;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import coffee.management.web.data.CoffeeOrder;

@Path("/coffee-orders")
public class CoffeeOrderResource {

    private static Map<Integer, CoffeeOrder> ORDER_DATA = new HashMap<>();

    private int getNewOrderId() {
        int newId = 0;
        for (int id : ORDER_DATA.keySet()) {
            if (newId < id)
                newId = id;
        }
        return ++newId;
    }

    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoffeeOrder(@PathParam("orderId") int orderId) {
        CoffeeOrder coffeeOrder = ORDER_DATA.get(orderId);
        if (coffeeOrder != null) {
            return Response.ok(coffeeOrder).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCoffeeOrder(CoffeeOrder coffeeOrder) {
        int orderId = getNewOrderId();
        coffeeOrder.setOrderId(orderId);
        ORDER_DATA.put(orderId, coffeeOrder);
        return Response.status(Response.Status.CREATED).entity(coffeeOrder).build();
    }

    @DELETE
    @Path("/{orderId}")
    public Response deleteCoffeeOrder(@PathParam("orderId") int orderId) {
        CoffeeOrder coffeeOrder = ORDER_DATA.get(orderId);
        if (coffeeOrder != null) {
            ORDER_DATA.remove(orderId);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}