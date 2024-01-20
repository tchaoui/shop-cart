import fr.pmu.coursepmu.entity.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ShoppingCartTest {
    @Test
    void testAddItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Pen", 3, 1.50);
        cart.addItem("Book", 2, 8.00);

        assertEquals(2, cart.cartItems.size());
    }

    @Test
    void testGenerateJsonFile() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Pen", 3, 1.50);
        cart.addItem("Book", 2, 8.00);

        cart.generateJsonFile();


    }
}

