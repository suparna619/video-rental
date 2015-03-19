package com.twu.refactor;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by suparnad on 3/19/2015.
 */
public class TextStatementTest {
    @Test
    public void testGetFooterLinesShouldGiveFooterLines(){
        String statement = TextStatement.getFooterLines(13.5, 2);
        String expected = "Amount owed is 13.5\nYou earned 2 frequent renter points";
        assertTrue(statement.equals(expected));
    }

    @Test
    public void testGetHeaderShouldGiveHeaderLine(){
        Customer customer = new Customer("Babaji");
        String statement = TextStatement.getHeader(customer);
        String expected = "Rental Record for Babaji\n";
        assertTrue(statement.equals(expected));
    }

}
