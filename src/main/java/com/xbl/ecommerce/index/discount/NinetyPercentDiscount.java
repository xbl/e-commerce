package com.xbl.ecommerce.index.discount;

public class NinetyPercentDiscount implements Discount {

    private double off = 0.9;

    @Override
    public double calculate(double price, int count) {
        return price * count * off;
    }
}
