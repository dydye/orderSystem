package com.ratel.product.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Data
@ApiModel("product classify param")
public class AddProductClassifyParam implements Serializable {

	private static final long serialVersionUID = -1987402355393298152L;

	@ApiModelProperty("product classify name")
	@NotBlank(message = "productClassifyName must not be null or empty")
	private String productClassifyName;

}
