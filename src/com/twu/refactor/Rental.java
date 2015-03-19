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

    protected int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if (each.movie.isNewRelease(each)
                && each.movie.getDaysRented(each) > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}