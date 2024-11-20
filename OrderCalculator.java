public class OrderCalculator {
    public static final double TAX_RATE = 0.08;
    public static final double WAFFLE_CONE_PRICE = 5.00;

    public double calculateSubtotal(Order order) {
        return order.getItems().stream()
                .mapToDouble(OrderItem::calculateItemCost)
                .sum();
    }

    public double calculateTax(double subtotal) {
        return subtotal * TAX_RATE;
    }

    public double calculateTotal(Order order) {
        double subtotal = calculateSubtotal(order);
        double containerCharge = order.getContainer().equalsIgnoreCase("waffle cone")
                ? WAFFLE_CONE_PRICE
                : 0.00;
        return subtotal + calculateTax(subtotal) + containerCharge;
    }
}
