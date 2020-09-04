package com.xbl.ecommerce.sign;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static boolean isYesterday(Date date) {
        if (date == null) return false;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        Calendar inputCal = Calendar.getInstance();
        inputCal.setTime(date);
        if (now.get(Calendar.YEAR) != inputCal.get(Calendar.YEAR)) {
            return false;
        }

        if (now.get(Calendar.MONTH) != inputCal.get(Calendar.MONTH)) {
            return false;
        }

        if (now.get(Calendar.DATE) - inputCal.get(Calendar.DATE) == 1) {
            return true;
        }

        return false;
    }

    public static boolean compare(Date first, Date second, String format) {
        if (first == null || second == null) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String firstStr = simpleDateFormat.format(first);
        String secondStr = simpleDateFormat.format(second);
        return firstStr.equals(secondStr);
    }
}
