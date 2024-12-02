public record Rental(
        Movie movie,
        int daysRented
) {
    boolean isNewRelease() {
        return movie().priceCode() == Movie.NEW_RELEASE;
    }
}