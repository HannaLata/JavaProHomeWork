package coffee.order;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders;
    private int orderNumber;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        orderNumber = 1;
    }

    public void add(String name) {
        Order order = new Order(orderNumber, name);
        orders.add(order);
        orderNumber++;
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            return null;
        }

        Order nextOrder = orders.get(0);
        orders.remove(0);
        return nextOrder;
    }

    public Order deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getNumber() == orderNumber) {
                orders.remove(order);
                return order;
            }
        }
        return null;
    }

    public void draw() {
        if (orders.isEmpty()) {
            System.out.println("No orders on the board.");
        } else {
            System.out.println("Num | Name");
            for (Order order : orders) {
                System.out.println(order.getNumber() + " | " + order.getName());
            }
        }
    }
}
