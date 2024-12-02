import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VideoStoreTest {
    @BeforeEach
	public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void singleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        assertEquals("""
                Rental Record for Fred
                \tThe Cell\t9.0
                You owed 9.0
                You earned 2 frequent renter points
                """, customer.statement());
    }

    @Test
    public void dualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
        assertEquals("""
                Rental Record for Fred
                \tThe Cell\t9.0
                \tThe Tigger Movie\t9.0
                You owed 18.0
                You earned 4 frequent renter points
                """, customer.statement());
    }

    @Test
    public void singleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));
        assertEquals("""
                Rental Record for Fred
                \tThe Tigger Movie\t1.5
                You owed 1.5
                You earned 1 frequent renter points
                """, customer.statement());
    }

    @Test
    public void multipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertEquals("""
                Rental Record for Fred
                \tPlan 9 from Outer Space\t2.0
                \t8 1/2\t2.0
                \tEraserhead\t3.5
                You owed 7.5
                You earned 3 frequent renter points
                """, customer.statement());
    }

    private Customer customer;
}
