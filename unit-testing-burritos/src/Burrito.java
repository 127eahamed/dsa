import java.util.ArrayList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Burrito {
    @Nested
    class BurritoTest {
        private static Burrito burrito;

        @BeforeAll
        static void initBurrito() {
            burrito = new Burrito();
        }

        @Test
        void testBowl() {
            burrito.bowl();
            assertTrue(burrito.bowl);
            burrito.bowl = false;
            burrito.bowl();
            assertTrue(burrito.bowl);
        }
        @Test
        void testBurrito() {
            burrito.burrito();
            assertFalse(burrito.bowl);
            burrito.bowl = true;
            burrito.burrito();
            assertFalse(burrito.bowl);
        }
    }

    private String protein;
    private ArrayList<String> toppings;
    private String drink;
    private double cost;
    private boolean bowl;
    private String sides;
    private double percentOff;
    private double coupon;
    private boolean taxExempt;

    /* methods are not actually implemented,
    only unit tests above are implemented */
    public void addTopping(String topping) {}
    public void setProtein(String protein) {}
    public void setDrink(String drink) {}
    public void setSide(String side) {}
    public void bowl() {}
    public void burrito() {}
    public void percentOff(double) {}
    public void coupon(double) {}
    public void removeTopping(String) {}
    public void taxExempt(boolean) {}
    public double getCost() {
        return 0.0;
    }
}
