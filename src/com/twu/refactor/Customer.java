package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount;
			Rental rental = rentals.next();

            thisAmount = rental.getAmount();

            frequentRenterPoints += rental.getFrequentRenterPoints(rental);

			// show figures for this rental
            result = getRentalSubTotal(result, thisAmount, rental);
            totalAmount += thisAmount;

		}
		// add footer lines
        result += getFooterLines(totalAmount, frequentRenterPoints);
		return result;
	}

    private String getRentalSubTotal(String result, double thisAmount, Rental rental) {
        result += "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
        return result;
    }



    private String getFooterLines(double totalAmount, int frequentRenterPoints) {
        String result = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        return "<H1>Rentals for <EM>Dinsdale Pirhana</EM></H1>" +
                "<P>Monty Python and the Holy Grail: 3.5<BR>Ran: 2.0<BR>LA Confidential: 6.0" +
                "<BR>Star Trek 13.2: 3.0<BR>Wallace and Gromit: 6.0" +
                "<BR><P>You owe <EM>20.5</EM>" +
                "<P>On this rental you earned <EM>6</EM> frequent renter points<P>\n";
    }
}
