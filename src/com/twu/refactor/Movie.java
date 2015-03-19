package com.twu.refactor;

public class Movie {

    private String title;
	private MoviePricingCategory priceCode;

	public Movie(String title, MoviePricingCategory priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public MoviePricingCategory getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(MoviePricingCategory arg) {
    	priceCode = arg;
	}

	public String getTitle () {
		return title;
	}

    public int getDaysRented(Rental rental) {
        return rental.daysRented;
    }

    public double getRentalAmount(Rental rental) {
        return getPriceCode().getCostFor(rental.daysRented);
    }

    public boolean isNewRelease(Rental rental) {
        return (rental.getMovie().getPriceCode() == MoviePricingCategory.NEW_RELEASE);
    }
}

