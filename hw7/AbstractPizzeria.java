import java.util.Collections;
import java.util.Queue;
import java.util.Set;

public abstract class AbstractPizzeria implements Pizzeria {
    private Set<Order> menu;
    protected Queue<Customer> queue;
    private int successfulOrders;
    private int attemptedOrders;
    private int placedOrders;
    private double revenue;

    public AbstractPizzeria(Set<Order> menu) {
        this.menu = menu;
        this.successfulOrders = 0;
        this.attemptedOrders = 0;
        this.placedOrders = 0;
        this.revenue = 0.00;
    }

    public void placeOrder(Customer customer) {
        queue.add(customer);
        placedOrders++;
    }

    public Order getCheapestMenuItem() {
        return Collections.min(menu);
    }

    public Order getMostExpensiveMenuItem() {
        return Collections.max(menu);
    }

    public String status() {
        double totalSuccessPercentage = (double) successfulOrders
                                        / (double) placedOrders;
        double attemptedSuccessPercentage = (double) successfulOrders
                                        / (double) attemptedOrders;
        return String.format("We delivered %.0f%% of our orders! We delivered "
            + "%.0f%% of our attempted orders and made $%,03.2f"
            , totalSuccessPercentage * 100, attemptedSuccessPercentage * 100
            , revenue);
    }

    public abstract String getName();

    public void processOrder() {
        if (!queue.isEmpty()) {
            attemptedOrders++;
            Customer customer = queue.remove();

            if (customer.isAbleToPay() && menu.contains(customer.getOrder())) {
                successfulOrders++;
                revenue += customer.getOrder().getValue();
            }
        }
    }
}
