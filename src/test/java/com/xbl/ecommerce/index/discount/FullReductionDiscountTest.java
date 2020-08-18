package com.xbl.ecommerce.index.discount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullReductionDiscountTest {
    @Test
    public void given_price_was_50_and_count_was_1_when_FullReductionDiscount_then_return_50() {
        Discount discount = new FullReductionDiscount(100, 10);
        double result = discount.calculate(50, 1);
        assertEquals(50, result);
    }

    @Test
    public void given_price_was_50_and_count_was_2_when_FullReductionDiscount_then_return_90() {
        Discount discount = new FullReductionDiscount(100, 10);
        double result = discount.calculate(50, 2);
        assertEquals(90, result);
    }
}
