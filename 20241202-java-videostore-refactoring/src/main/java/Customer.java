import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : this.rentals) {
            double thisAmount = 0;

            // determines the amount for each line
            switch (rental.movie().priceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.daysRented() > 2) {
                        thisAmount += (rental.daysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.daysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.daysRented() > 3) {
                        thisAmount += (rental.daysRented() - 3) * 1.5;
                    }
                    break;
            }

            result += "\t" + rental.movie().title() + "\t"
                    + thisAmount + "\n";
            totalAmount += thisAmount;

        }

        result += "You owed " + totalAmount + "\n";

        result += "You earned " + calculateFrequentRenterPoints() + " frequent renter points\n";

        return result;
    }

    private int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : this.rentals) {
            frequentRenterPoints++;

            if (rental.isNewRelease() && rental.daysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }

}