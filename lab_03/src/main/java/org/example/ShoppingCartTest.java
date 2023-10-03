package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;


class ShoppingCartTest {

    @Test
    void testAddProductInCart() {
        Cart cart = new Cart();
        Product product1 = new Product(1, "Cheese", 50.0);
        Product product2 = new Product(2, "Ketchup", 28.50);
        cart.addProduct(product1);
        cart.addProduct(product2);
        assertEquals(2, cart.getProducts().size());
    }

    @Test
    void testRemoveProductFromCart() {
        Cart cart = new Cart();
        Product product3 = new Product(3, "Milk", 40.25);
        cart.addProduct(product3);
        cart.removeProduct(product3);
        assertEquals(0, cart.getProducts().size());
    }

    @Test
    void testPlaceOrderAndGetStatus() {
        Cart cart = new Cart();
        Product product4 = new Product(4, "Bread", 32.99);
        cart.addProduct(product4);
        Order order = new Order(1, new ArrayList<>(cart.getProducts()), "Pending");

        assertEquals(1, order.getProducts().size());
        assertEquals("Pending", order.getStatus());
    }
}