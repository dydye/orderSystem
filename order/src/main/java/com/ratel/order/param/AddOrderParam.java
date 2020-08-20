package com.ratel.order.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Data
@ApiModel("order param")
public class AddOrderParam implements Serializable {

	private static final long serialVersionUID = 8852898393165695101L;

	private Long userId;

	private Long productId;

	private String receiverName;

	private String receiverPhone;

	private String receiverAddress;

	private String receiverPostCode;

	private String remark;
}
