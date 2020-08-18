package com.xbl.ecommerce;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum ECommerceFeatures implements Feature {

    @EnabledByDefault
    @Label("启用满减折扣")
    FULL_REDUCTION_DISCOUNT;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
