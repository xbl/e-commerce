package com.xbl.ecommerce.index.discount;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class NinetyPercentDiscountTest {

    @Test
    public void give_zero_price_and_count_0_when_call_NinetyPercentDiscount_return_0() {
        Discount discount = new NinetyPercentDiscount();
        double result =  discount.calculate(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void give_100_price_and_count_1_when_call_NinetyPercentDiscount_return_90() {
        Discount discount = new NinetyPercentDiscount();
        double result =  discount.calculate(100, 1);
        assertEquals(90, result);
    }
}
