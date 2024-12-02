import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String generateStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";


        while (rentals.hasMoreElements()) {
            double rentalPrice = 0;
            Rental each = rentals.nextElement();

            // determines the amount for each line
            switch (each.movie().priceCode()) {
                case Movie.REGULAR:
                    rentalPrice += 2;
                    if (each.daysRented() > 2)
                        rentalPrice += (each.daysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    rentalPrice += each.daysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    rentalPrice += 1.5;
                    if (each.daysRented() > 3)
                        rentalPrice += (each.daysRented() - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (each.movie().priceCode() == Movie.NEW_RELEASE
                    && each.daysRented() > 1)
                frequentRenterPoints++;

            result += "\t" + each.movie().title() + "\t"
                    + rentalPrice + "\n";
            totalAmount += rentalPrice;

        }

        result += "You owed " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";


        return result;
    }

}