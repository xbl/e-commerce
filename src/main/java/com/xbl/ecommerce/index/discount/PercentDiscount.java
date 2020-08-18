package com.xbl.ecommerce.index.discount;

public class PercentDiscount implements Discount {
    private double off;
    public PercentDiscount(double off) {
        this.off = off;
    }

    @Override
    public double calculate(double price, int count) {
        return price * count * off;
    }
}
