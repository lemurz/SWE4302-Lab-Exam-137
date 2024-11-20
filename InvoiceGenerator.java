import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InvoiceGenerator {
    public void generateInvoice(Order order, String filePath) throws IOException {
        try(FileWriter fw = new FileWriter(filePath)){
            fw.write("Ice Cream Shop Invoice\n");

            for(OrderItem item : order.getItems()){
                fw.write(item.getName() + " - " + item.getQuantity() + " time(s): $"
                        + String.format("%.2f", item.calculateItemCost()) + "\n");
            }

            fw.write("Subtotal: $" + String.format("%.2f", order.calculateSubTotal()) + "\n");
            fw.write("Tax: $" + String.format("%.2f", order.calculateTax()) + "\n");
            fw.write("Total Amount Due: $" + String.format("%.2f", order.calculateTotal()) + "\n");
        }
    }
}