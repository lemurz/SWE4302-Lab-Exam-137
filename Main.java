import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create flavors and toppings
        IceCreamFlavor mint = new IceCreamFlavor("Mint Chocolate Chip", 2.80);
        IceCreamFlavor fudge = new IceCreamFlavor("Chocolate Fudge", 3.00);
        Topping sprinkles = new Topping("Sprinkles", 0.30);
        Topping strawberries = new Topping("Fresh Strawberries", 1.00);

        // Create an order
        Order order = new Order();
        order.addItem(new OrderItem(mint.getName(), 2, mint.getPricePerScoop())); // 2 scoops of Mint
        order.addItem(new OrderItem(fudge.getName(), 1, fudge.getPricePerScoop())); // 1 scoop of Fudge
        order.addItem(new OrderItem(sprinkles.getName(), 1, sprinkles.getPricePerUnit())); // 1 unit of Sprinkles
        order.addItem(new OrderItem(strawberries.getName(), 2, strawberries.getPricePerUnit())); // 2 units of Strawberries
        order.setContainer("waffle cone");

        // Print total cost
        System.out.println("Total Amount Due: $" + String.format("%.2f", order.calculateTotal()));

        // Generate invoice
        InvoiceGenerator generator = new InvoiceGenerator();
        try {
            generator.generateInvoice(order, "invoice.txt");
            System.out.println("Invoice generated successfully.");
        } catch (IOException e) {
            System.err.println("Failed to generate invoice: " + e.getMessage());
        }
    }
}
