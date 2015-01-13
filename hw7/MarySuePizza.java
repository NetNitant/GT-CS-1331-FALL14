import java.util.PriorityQueue;
import java.util.Set;

public class MarySuePizza extends AbstractPizzeria {
    private static final String NAME = "Mary Sue Pizza";

    public MarySuePizza(Set<Order> menu) {
        super(menu);
        this.queue = new PriorityQueue<Customer>();
    }

    public String getName() {
        return NAME;
    }
}
