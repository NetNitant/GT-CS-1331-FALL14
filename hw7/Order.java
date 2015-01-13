import java.util.HashSet;
import java.util.Iterator;

public class Order extends HashSet<Ingredient> implements
    Comparable<Order> {
    public int getValue() {
        int value = 0;

        Iterator<Ingredient> iterator = this.iterator();

        while (iterator.hasNext()) {
            Ingredient ingredient = iterator.next();
            value += ingredient.getPrice();
        }

        return value;
    }

    public int compareTo(Order other) {
        return this.getValue() - other.getValue();
    }
}
