package org.example.Amazon;

import org.example.Amazon.Cost.ItemType;
import org.example.Amazon.Cost.PriceRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AmazonUnitTest {

    private Amazon amazon;
    private ShoppingCart mockCart;
    private PriceRule mockRule;

    @BeforeEach
    void setUp() {
        mockCart = mock(ShoppingCart.class);
        mockRule = mock(PriceRule.class);
        amazon = new Amazon(mockCart, List.of(mockRule));
    }

    @Test
    @DisplayName("specification-based")
    void testCalculateWithMockRule() {
        when(mockCart.getItems()).thenReturn(List.of(
                new Item(ItemType.OTHER, "Book1", 2, 10.0)
        ));
        when(mockRule.priceToAggregate(mockCart.getItems())).thenReturn(20.0);

        double total = amazon.calculate();

        assertEquals(20.0, total);
        verify(mockRule, times(1)).priceToAggregate(mockCart.getItems());
    }

    @Test
    @DisplayName("structural-based")
    void testAddToCartCallsCart() {
        Item item = new Item(ItemType.OTHER, "Book2", 1, 15.0);

        amazon.addToCart(item);

        verify(mockCart, times(1)).add(item);
    }
}
