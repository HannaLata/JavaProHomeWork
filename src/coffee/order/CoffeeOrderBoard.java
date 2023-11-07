package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orders;
    private int next = 1;

    public CoffeeOrderBoard() {
        orders = new LinkedList<>();
    }

    public void add(String name) {
        Order order = new Order(next, name);
        orders.add(order);
        next++;
    }

    public Order deliver() {
        if (orders.isEmpty()) {
            return null;
        }

        return orders.poll();
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
