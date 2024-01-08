import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import org.example.ECommercePlatform;
import org.example.User;
import org.example.Order;
import org.example.Product;

public class ECommerceDemo {

    private ECommercePlatform platform;

    @Before
    public void setUp() {
        platform = new ECommercePlatform();
        initializeTestData();
    }

    @Test
    public void testAddUser() {
        assertEquals(0, platform.getUsers().size());

        User user = new User(1, "Хтось");
        platform.addUser(user);

        assertEquals(1, platform.getUsers().size());
        assertEquals(user, platform.getUserById(1));
    }

    @Test
    public void testAddProduct() {
        assertEquals(0, platform.getProducts().size());

        Product product = new Product(1, "Товар А", 20.0, 50);
        platform.addProduct(product);

        assertEquals(1, platform.getProducts().size());
        assertEquals(product, platform.getProductById(1));
    }

    @Test
    public void testCreateOrder() {
        User user = new User(1, "Хтось");
        platform.addUser(user);

        Product product = new Product(1, "Товар А", 20.0, 50);
        platform.addProduct(product);

        assertEquals(0, platform.getOrders().size());

        Order order = platform.createOrder(user, product, 5);

        assertEquals(1, platform.getOrders().size());
        assertEquals(order, platform.getOrderById(1));
        assertEquals(45, product.getStock());
    }

    @Test
    public void testRecommendProducts() {
        User user = new User(1, "Хтось");
        platform.addUser(user);

        Product product1 = new Product(1, "Товар А", 20.0, 50);
        Product product2 = new Product(2, "Товар B", 15.0, 30);

        platform.addProduct(product1);
        platform.addProduct(product2);

        platform.addProductToCart(user, product1, 3);

        assertEquals(1, platform.recommendProducts(user).size());
    }


    private void initializeTestData() {
    }
}