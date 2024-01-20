import fr.pmu.coursepmu.entity.ShoppingCart;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


public class ShopCartApplication {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();

		cart.addItem("Pen", 3, 1.50);
		cart.addItem("Book", 2, 8.00);

		cart.printCart();
	}

}
