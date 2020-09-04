package com.xbl.ecommerce.sign;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SignVo extends Sign {
    private int point;
    private int totalPoint;
    private boolean repeat;
}
