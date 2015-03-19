package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer implements Billable {

	private String name;
	ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}


    String getRentalSubTotal(String result, double thisAmount, Rental rental) {
        result += "\t" + rental.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
        return result;
    }

}
