package com.xbl.ecommerce.sign;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilTest {

    @Test
    public void given_same_date_then_return_ture() {
        Date now = new Date();
        boolean result = DateUtil.compare(now, now, "yyyy-MM-dd");
        assertEquals(true, result);
    }

    @Test
    public void given_diff_date_then_return_false() throws ParseException {
        String format = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date first = simpleDateFormat.parse("2019-01-01");
        Date second = simpleDateFormat.parse("2019-01-02");
        boolean result = DateUtil.compare(first, second, format);
        assertEquals(false, result);
    }

    @Test
    public void given_yesterday_date_called_is_yesterday_true() throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        assertEquals(true, DateUtil.isYesterday(cal.getTime()));
    }

    @Test
    public void given_same_date_called_is_yesterday_false() throws ParseException {

        assertEquals(false, DateUtil.isYesterday(new Date()));
    }
}
