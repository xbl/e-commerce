package com.xbl.ecommerce.sign;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Sign {
    private int point;
    private Date date;

    public boolean getRepeat() {
        return DateUtil.compare(getDate(), new Date(), "yyyy-MM-dd");
    }

    public boolean getContinues() {
        return DateUtil.isYesterday(getDate());
    }
}
