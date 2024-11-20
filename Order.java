import java.util.ArrayList;
import java.util.List;

public class Order {
    private final double TAX = 0.08;
    private final double WAFFLE_CONE = 5.00;
    private List<OrderItem> items;
    private String container;

    public Order(){
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void setContainer(String container){
        this.container = container;
    }

    public double calculateSubTotal(){
        return items.stream().mapToDouble(OrderItem::calculateItemCost).sum();
    }

    public double calculateTax(){
        return calculateSubTotal() * TAX;
    }

    public double calculateTotal() {
        double containerCharge = container.equalsIgnoreCase("waffle cone") ? WAFFLE_CONE : 0.00;
        return calculateSubTotal() + calculateTax() + containerCharge;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}