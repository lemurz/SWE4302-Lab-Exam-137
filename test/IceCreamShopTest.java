package test;

import org.junit.Test;
import src.*;
import src.MenuItem;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IceCreamShopTest {
    @Test
    public void testBasicOrderWithOneFlavor(){
        MenuItem mint = new IceCreamFlavor("Mint Chocolate Chip", 2.80);

        Order order = new Order();
        order.addItem(new OrderItem(mint, 1));
        order.setContainer("paper cup");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        assertEquals(3.02, total, 0.01, "Total should include 8% tax on $2.80");
    }

    @Test
    public void testOrderWithMultipleFlavorsAndToppings() {
        MenuItem fudge = new IceCreamFlavor("Chocolate Fudge", 3.00);
        MenuItem pistachio = new IceCreamFlavor("Pistachio Delight", 3.25);
        MenuItem marshmallow = new Topping("Marshmallow", 0.70);

        Order order = new Order();
        order.addItem(new OrderItem(fudge, 2));
        order.addItem(new OrderItem(pistachio, 1));
        order.addItem(new OrderItem(marshmallow, 3));
        order.setContainer("waffle cone");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        assertEquals(17.258, total, 0.01, "Total includes waffle cone price, tax, and item costs");
    }

    @Test
    public void testEmptyOrder() {
        Order order = new Order();
        order.setContainer("paper cup");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        assertEquals(0.00, total, 0.01, "Total should be 0 for an empty order with paper cup");
    }

    @Test
    public void testOrderWithOnlyWaffleCone() {
        Order order = new Order();
        order.setContainer("waffle cone");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        assertEquals(5.00, total, 0.01, "Total should include only waffle cone price");
    }

    @Test
    public void testHighQuantitySingleFlavor() {
        IceCreamFlavor strawberry = new IceCreamFlavor("Strawberry Swirl", 2.75);

        Order order = new Order();
        order.addItem(new OrderItem(strawberry, 100)); // 100 scoops
        order.setContainer("paper cup");

        OrderCalculator calculator = new OrderCalculator();
        double total = calculator.calculateTotal(order);

        assertEquals(297.00, total, 0.01, "Total should account for 100 scoops with tax");
    }
}