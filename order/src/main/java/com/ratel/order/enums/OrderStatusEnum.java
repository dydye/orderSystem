package com.ratel.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    TO_BE_DELIVERED(10,"to be delivered"),
    SHIPPED(20,"shipped"),
    COMPLETED(30,"completed"),
    CLOSED(40,"closed");

    private Integer type;
    private  String desc;

    public static String getDescByType(Integer type) {
        for(OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()){
            if (orderStatusEnum.getType().equals(type)){
                return orderStatusEnum.getDesc();
            }
        }
        return null;
    }
}
