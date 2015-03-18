package com.twu.refactor;

public class Rental {

    Movie movie;

    protected int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        return movie.getPriceCode().getCostFor(daysRented);
    }

    public boolean isNewRelease() {
        return (getMovie().getPriceCode() == MoviePricingCategory.NEW_RELEASE);
    }

    protected int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (each.isNewRelease()
                && each.movie.getDaysRented(each) > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}