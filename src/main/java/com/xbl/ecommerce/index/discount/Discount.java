package com.xbl.ecommerce.index.discount;

public interface Discount {
    double calculate(double price, int count);
}
