import java.util.ArrayList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        @Test
        void setProtein() {
            burrito.setProtein("beef");
            assertEquals("beef", burrito.protein);
            burrito.setProtein("chicken");
            assertEquals("chicken", burrito.protein);
            burrito.setProtein(null);
            assertEquals(null, burrito.protein);
        }
        @Test
        void setSide() {
            burrito.setSide("chips");
            assertEquals("chips", burrito.side);
            burrito.setSide("salad");
            assertEquals("salad", burrito.side);
            burrito.setSide(null);
            assertEquals(null, burrito.side);
        }
        @Test
        void setDrink() {
            burrito.setDrink("cola");
            assertEquals("cola", burrito.drink);
            burrito.setDrink("lemonade");
            assertEquals("lemonade", burrito.drink);
            burrito.setDrink(null);
            assertEquals(null, burrito.drink);
        }
        @Test
        void coupon() {
            burrito.coupon(5);
            assertEquals(5, burrito.coupon);
            assertThrows(
                NegativeCouponException.class,
                burrito.coupon(-2)
            );
            assertEquals(5, burrito.coupon);
            burrito.coupon(0.99);
            assertEquals(5.99, burrito.coupon);
            burrito.coupon(100);
            assertEquals(105.99, burrito.coupon);
            burrito.coupon = 0.0;
            burrito.coupon(7.99);
            assertEquals(7.99, burrito.coupon);
            burrito.coupon(1.23);
            assertEquals(9.22, burrito.coupon);
        }
        @Test
        void percentOff() {
            burrito.percentOff(0);
            assertEquals(0, burrito.percentOff);
            burrito.percentOff(10);
            assertEquals(10, burrito.percentOff);
            assertThrows(
                TooLargePercentOffException.class,
                burrito.percentOff(200)
            );
            assertEquals(10, burrito.percentOff);
            assertThrows(
                NegativePercentOffException.class,
                burrito.percentOff(-20)
            );
            assertEquals(10, burrito.percentOff);
        }
        @Test
        void addTopping() {
            burrito.addTopping("cheese");
            burrito.addTopping("sour cream");
            burrito.addTopping("corn");
            assertEquals(3, burrito.toppings.size());
        }
    }

    private String protein;
    private ArrayList<String> toppings;
    private String drink;
    private double cost;
    private boolean bowl;
    private String side;
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
    public void percentOff(double) throws
        NegativePercentOffException,
        TooLargePercentOffException {}
    public void coupon(double) throws
        NegativeCouponException {}
    public void removeTopping(String) throws
        RemoveMissingToppingException {}
    public void taxExempt(boolean) {}
    public double getCost() {
        return 0.0;
    }

    public class NegativeCouponException extends Exception {
        public NegativeCouponException() {
            super("Coupon can't be negative");
        }

        public NegativeCouponException(Throwable cause) {
            super("Coupon can't be negative", cause);
        }
    }

    public class TooLargePercentOffException extends Exception {
        public TooLargePercentOffException() {
            super("Percent off can't be over 100%");
        }

        public TooLargePercentOffException(Throwable cause) {
            super("Percent off can't be over 100%", cause);
        }
    }

    public class NegativePercentOffException extends Exception {
        public NegativePercentOffException() {
            super("Percent off can't be negative");
        }

        public NegativePercentOffException(Throwable cause) {
            super("Percent off can't be negative", cause);
        }
    }

    public class RemoveMissingToppingException extends Exception {
        public RemoveMissingToppingException() {
            super("Cannot remove missing topping");
        }

        public RemoveMissingToppingException(Throwable cause) {
            super("Cannot remove missing topping", cause);
        }
    }
}
