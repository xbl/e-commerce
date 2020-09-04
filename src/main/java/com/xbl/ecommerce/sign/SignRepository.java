package com.xbl.ecommerce.sign;

public interface SignRepository {
    boolean getIsHoliday();
    int getTotalPoint();
    Sign getLastSign();
    int getSignCount();
    void save(Sign sign);

}
