package com.twu.refactor;

import junit.framework.TestCase;
import org.junit.Test;

public class MoviePricingCategoryTest extends TestCase {
    @Test
    public void test_kids_category_gives_correct_cost_for_4_days_rented() {
        double actualCost = MoviePricingCategory.KIDS.getCostFor(4);
        assertEquals(3.0,actualCost,0.0);
    }

    @Test
    public void test_kids_category_gives_correct_cost_for_less_than_3_days_rented() {
        double actualCostFor1Days = MoviePricingCategory.KIDS.getCostFor(1);
        double actualCostFor2Days = MoviePricingCategory.KIDS.getCostFor(2);
        assertEquals(1.5,actualCostFor1Days,0.0);
        assertEquals(1.5,actualCostFor2Days,0.0);
    }

    @Test
    public void test_new_release_category_gives_correct_cost_for_less_than_6_days_rented() {
        double actualCostFor6Days = MoviePricingCategory.NEW_RELEASE.getCostFor(6);
        assertEquals(18,actualCostFor6Days,0.0);
    }
}