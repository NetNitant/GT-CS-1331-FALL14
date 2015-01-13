import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;

public class PizzaShack extends AbstractPizzeria {
    private static final String NAME = "Pizza Shack";

    public PizzaShack(Set<Order> menu) {
        super(menu);
        this.queue = new PriorityQueue<Customer>(new Comparator<Customer>() {
            public int compare(Customer c1, Customer c2) {
                if (c1.isAbleToPay() != c2.isAbleToPay()) {
                    return c1.isAbleToPay() ? -1 : 1;
                }

                return c1.compareTo(c2);
            }
        });
    }

    public String getName() {
        return NAME;
    }
}
