import java.util.ArrayDeque;
import java.util.Set;

public class CascadePizza extends AbstractPizzeria {
    private static final String NAME = "Cascade Pizza";

    public CascadePizza(Set<Order> menu) {
        super(menu);
        this.queue = new ArrayDeque<Customer>();
    }

    public String getName() {
        return NAME;
    }
}
