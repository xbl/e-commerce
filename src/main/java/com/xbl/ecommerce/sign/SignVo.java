package com.xbl.ecommerce.sign;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SignVo {
    private int point;
    private int totalPoint;
    private boolean repeat;
}
