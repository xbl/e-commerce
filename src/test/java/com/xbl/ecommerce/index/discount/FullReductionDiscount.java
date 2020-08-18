package com.xbl.ecommerce.index.discount;

public class FullReductionDiscount implements Discount {
    private double full;
    private double reduction;
    public FullReductionDiscount(double full, double reduction) {
        this.full = full;
        this.reduction = reduction;
    }


    @Override
    public double calculate(double price, int count) {
        double result = price * count;
        if (result >= full) {
            return result - reduction;
        }
        return result;
    }
}
