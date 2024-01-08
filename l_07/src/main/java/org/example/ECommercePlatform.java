package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public Order getOrderById(Integer orderId) {
        return orders.get(orderId);
    }

    public void addProductToCart(User user, Product product, int quantity) {
        if (!products.containsKey(product.getId()) || quantity <= 0) {
            System.out.println("Недійсний товар або кількість для користувача " + user.getUsername() + ".");
            return;
        }

        int availableStock = product.getStock();
        if (quantity > availableStock) {
            System.out.println("Немає в наявності для користувача" + user.getUsername() + ".");
            return;
        }

        user.addToCart(product, quantity);
        product.setStock(availableStock - quantity);
    }


    public List<Product> recommendProducts(User user) {
        List<Product> recommendedProducts = new ArrayList<>();
        Map<Product, Integer> userCart = user.getCart();

        for (Product product : products.values()) {
            if (!userCart.containsKey(product) && product.getStock() > 0) {
                recommendedProducts.add(product);
            }
        }

        return recommendedProducts;
    }


    public void addUser(User user) {
        users.put(user.getId(), user);
    }


    public User getUserById(Integer userId) {
        return users.get(userId);
    }


    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }


    public Product getProductById(Integer productId) {
        return products.get(productId);
    }


    public Order createOrder(User user, Product product, int quantity) {
        if (!products.containsKey(product.getId()) || quantity <= 0) {
            System.out.println("Недійсний товар або кількість.");
            return null;
        }

        int availableStock = product.getStock();
        if (quantity > availableStock) {
            System.out.println("Немає в наявності.");
            return null;
        }

        int orderId = orders.size() + 1;
        Order order = new Order(orderId, user.getId());
        order.getOrderDetails().put(product, quantity);
        order.calculateTotalPrice();


        product.setStock(availableStock - quantity);


        orders.put(orderId, order);
        return order;
    }


    public List<Product> getAvailableProducts() {
        List<Product> availableProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getStock() > 0) {
                availableProducts.add(product);
            }
        }
        return availableProducts;
    }


    public List<User> getUsersList() {
        return new ArrayList<>(users.values());
    }


    public List<Order> getOrdersList() {
        return new ArrayList<>(orders.values());
    }


    public void updateProductStock(Product product, int additionalStock) {
        int currentStock = product.getStock();
        product.setStock(currentStock + additionalStock);
    }
}
