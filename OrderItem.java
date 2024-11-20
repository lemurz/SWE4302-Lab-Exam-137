public class OrderItem {
    private String name;
    private int quantity;
    private double unitPrice;

    public OrderItem(String name, int quantity, double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double calculateItemCost() {
        return quantity * unitPrice;
    }
}
