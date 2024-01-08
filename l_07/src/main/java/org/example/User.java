package org.example;
import java.util.HashMap;
import java.util.Map;

public class User {
    private Integer id;
    private String username;
    private Map<Product, Integer> cart;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.cart = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCart(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    public void addToCart(Product product, int quantity) {
        if (quantity > 0) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        }
    }

    public void removeFromCart(Product product, int quantity) {
        if (quantity > 0) {
            int currentQuantity = cart.getOrDefault(product, 0);
            if (quantity >= currentQuantity) {
                cart.remove(product);
            } else {
                cart.put(product, currentQuantity - quantity);
            }
        }
    }

    public void clearCart() {
        cart.clear();
    }

    public void viewCart() {
        System.out.println("Корзина для користувача " + username + ":");
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + " - Кількість: " + quantity);
        }
        System.out.println("Всього товарів у кошику: " + cart.size());
    }
}
