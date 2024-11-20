import java.io.FileWriter;
import java.io.IOException;

public class InvoiceGenerator {
    public void generateInvoice(Order order, OrderCalculator calculator, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Ice Cream Shop Invoice\n");
            for (OrderItem item : order.getItems()) {
                writer.write(item.getName() + " - " + item.getQuantity() + " time(s): $"
                        + String.format("%.2f", item.calculateItemCost()) + "\n");
            }
            writer.write("Container: " + order.getContainer() + "\n");
            double subtotal = calculator.calculateSubtotal(order);
            writer.write("Subtotal: $" + String.format("%.2f", subtotal) + "\n");
            writer.write("Tax: $" + String.format("%.2f", calculator.calculateTax(subtotal)) + "\n");
            writer.write("Total Amount Due: $" + String.format("%.2f", calculator.calculateTotal(order)) + "\n");
        }
    }
}
