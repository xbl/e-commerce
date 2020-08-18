package com.xbl.ecommerce.index.discount;

import java.math.BigDecimal;

public interface Discount {
    double calculate(double price, int count);
}
