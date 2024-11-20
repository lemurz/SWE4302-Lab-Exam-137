import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<OrderItem> items;
    private String container;

    public Order() {
        this.items = new ArrayList<>();
        this.container = "paper cup";
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getContainer() {
        return container;
    }
}
