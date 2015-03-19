package com.twu.refactor;

import java.util.Iterator;

/**
 * Created by suparnad on 3/19/2015.
 */
public class TextStatement {
    static String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    static String getFooterLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }


    public static String statement(Customer customer) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        TextStatement ts = new TextStatement();
        Iterator<Rental> rentals = customer.rentalList.iterator();
        String result = getHeader(customer);
        while (rentals.hasNext()) {
            double thisAmount;
            Rental rental = rentals.next();
            thisAmount = rental.movie.getRentalAmount(rental);
            frequentRenterPoints += rental.getFrequentRenterPoints(rental);
            result = customer.getRentalSubTotal(result, thisAmount, rental);
            totalAmount += thisAmount;
        }
        result += ts.getFooterLines(totalAmount, frequentRenterPoints);
        return result;
    }
}
