package com.xbl.ecommerce.index;

import com.xbl.ecommerce.ECommerceFeatures;
import com.xbl.ecommerce.index.discount.Discount;
import com.xbl.ecommerce.index.discount.FullReductionDiscount;
import com.xbl.ecommerce.index.discount.NinetyPercentDiscount;
import org.junit.jupiter.api.Test;
import org.togglz.testing.TestFeatureManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountFactoryTest {

    @Test
    public void given_toggle_active_when_getInstance_return_FullReductionDiscount() {

        TestFeatureManager featureManager = new TestFeatureManager(ECommerceFeatures.class);
        featureManager.enable(ECommerceFeatures.FULL_REDUCTION_DISCOUNT);

        DiscountFactory discountFactory = new DiscountFactory(featureManager);
        Discount discount = discountFactory.getInstance();

        assertEquals(true, discount instanceof FullReductionDiscount);
    }

    @Test
    public void given_toggle_active_when_getInstance_return_NinetyPercentDiscount() {

        TestFeatureManager featureManager = new TestFeatureManager(ECommerceFeatures.class);
        featureManager.disable(ECommerceFeatures.FULL_REDUCTION_DISCOUNT);

        DiscountFactory discountFactory = new DiscountFactory(featureManager);
        Discount discount = discountFactory.getInstance();

        assertEquals(true, discount instanceof NinetyPercentDiscount);
    }
}
