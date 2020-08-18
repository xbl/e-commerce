package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.discount.Discount;
import com.xbl.ecommerce.index.discount.DiscountFactory;
import com.xbl.ecommerce.index.entity.Index;
import org.springframework.stereotype.Component;

@Component
public class IndexService {
    private IndexRepository indexRepository;
    private DiscountFactory factory;

    public IndexService(IndexRepository indexRepository, DiscountFactory factory) {
        this.indexRepository = indexRepository;
        this.factory = factory;
    }

    public Index get(Integer id) {
        return indexRepository.get(id);
    }

    public double getDiscount() {
        double price = 120;
        int count = 1;
        Discount discount = factory.getInstance();
        return discount.calculate(price, count);
    }
}
