package org.example.Amazon;

import org.example.Amazon.Cost.ItemType;
import org.example.Amazon.Cost.PriceRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonIntegrationTest {

    private Amazon amazon;
    private ShoppingCartAdaptor cart;
    private Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
        db.resetDatabase();  // clean the DB before each test
        cart = new ShoppingCartAdaptor(db);

        PriceRule rule = items -> items.stream()
                .mapToDouble(i -> i.getQuantity() * i.getPricePerUnit())
                .sum();

        amazon = new Amazon(cart, List.of(rule));
    }

    @Test
    @DisplayName("specification-based")
    void testCalculateTotalPrice() {
        cart.add(new Item(ItemType.OTHER, "Book1", 2, 10.0));
        cart.add(new Item(ItemType.OTHER, "Book2", 1, 20.0));

        double total = amazon.calculate();

        assertEquals(40.0, total);
    }

    @Test
    @DisplayName("structural-based")
    void testCalculateEmptyCart() {
        double total = amazon.calculate();
        assertEquals(0.0, total);
    }
}
