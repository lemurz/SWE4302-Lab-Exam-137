package src;

public class OrderItem {
    private final MenuItem menuItem;
    private final int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public String getName() {
        return menuItem.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public double calculateItemCost() {
        return quantity * menuItem.getPrice();
    }
}
