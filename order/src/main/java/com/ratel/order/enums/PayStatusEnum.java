package com.ratel.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {

    UNPAID(1,"unpaid"),
    PAID(2,"paid");

    private Integer state;
    private String msg;

}
