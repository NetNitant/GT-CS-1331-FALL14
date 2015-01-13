import java.util.Random;

public class Customer implements Comparable<Customer> {
    private Order order;
    private int money;
    private static final Random GENERATOR = new Random();

    public Customer(Order order) {
        this.order = order;

        this.money = Driver.RANDOM.ints(5, 35).iterator().nextInt();
    }

    public Order getOrder() {
        return order;
    }

    public boolean isAbleToPay() {
        return money >= order.getValue();
    }

    public int compareTo(Customer other) {
        return -1 * (this.order.getValue() - other.order.getValue());
    }
}
