package org.example.Barnes;

import static org.mockito.Mockito.*;

import org.example.Barnes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BarnesAndNobleTest {

    @Mock
    private BookDatabase bookDatabase;

    @Mock
    private BuyBookProcess process;

    private BarnesAndNoble barnesAndNoble;

    @BeforeEach
    void setUp() {
        // Initialize all @Mock fields manually
        MockitoAnnotations.openMocks(this);
        barnesAndNoble = new BarnesAndNoble(bookDatabase, process);
    }

    @Test
    @DisplayName("specification-based")
    void testGetPriceForCart_specification() {
        // Arrange
        Book book = new Book("123", 10, 5);
        when(bookDatabase.findByISBN("123")).thenReturn(book);

        Map<String, Integer> order = Map.of("123", 2);

        // Act
        PurchaseSummary result = barnesAndNoble.getPriceForCart(order);

        // Assert
        assertNotNull(result);
        assertEquals(20.0, result.getTotalPrice(), 0.001);
        verify(process, times(1)).buyBook(book, 2);
    }

    @Test
    @DisplayName("structural-based")
    void testGetPriceForCart_structural() {
        // Arrange - request more than available
        Book book = new Book("456", 15, 3);
        when(bookDatabase.findByISBN("456")).thenReturn(book);

        Map<String, Integer> order = Map.of("456", 5);

        // Act
        PurchaseSummary result = barnesAndNoble.getPriceForCart(order);

        // Assert
        assertNotNull(result);
        assertEquals(45.0, result.getTotalPrice(), 0.001); // 3 * 15.0
        verify(process, times(1)).buyBook(book, 3);
    }
}
