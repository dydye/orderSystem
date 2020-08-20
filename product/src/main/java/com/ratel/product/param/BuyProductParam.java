package com.ratel.product.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author daiyun
 * @date 2020/8/20
 */
@Data
@ApiModel("BuyProductParam")
public class BuyProductParam implements Serializable {
	private static final long serialVersionUID = 2740080014807723745L;

	@ApiModelProperty("productId")
	@NotNull
	private Long productId;

	@ApiModelProperty("buy num")
	@NotNull
	private Integer buyNum;

	@ApiModelProperty("user id")
	@NotNull
	private Long userId;

}
