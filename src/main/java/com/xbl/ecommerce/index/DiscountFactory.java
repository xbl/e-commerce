package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.discount.Discount;
import com.xbl.ecommerce.index.discount.FullReductionDiscount;
import com.xbl.ecommerce.index.discount.NinetyPercentDiscount;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@Component
public class DiscountFactory {
    private FeatureManager manager;

    public DiscountFactory(FeatureManager manager) {
        this.manager = manager;
    }

    public Discount getInstance() {
        if (manager.isActive(new NamedFeature("FOO"))) {
            return new FullReductionDiscount(100, 10);
        }
        return new NinetyPercentDiscount();
    }
}
