package com.ratel.product.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Data
@ApiModel("product param")
public class AddProductParam implements Serializable {
	private static final long serialVersionUID = -1987402355393298152L;

	@NotNull(message = "productClassifyId must not be null")
	private Long productClassifyId;

	@NotBlank(message = "productName must not be null or empty")
	@Length(max = 20, message = "the product name cannot more than {max} characters ")
	private String productName;

	@NotNull(message = "productStock must not be null")
	private Integer productStock;

	@NotBlank(message = "productName must not be null or empty")
	@Length(max = 20, message = "the product name cannot more than {max} characters ")
	private String productCode;

	@NotNull(message = "productName must not be null or empty")
	private BigDecimal productPrice;

	@NotBlank(message = "productDesc must not be null or empty")
	@Length(max = 20, message = "the product desc cannot more than {max} characters ")
	private String productDesc;

	@NotBlank(message = "productAddress must not be null or empty")
	@Length(max = 20, message = "the product address cannot more than {max} characters ")
	private String productAddress;

	@NotNull(message = "userId must not be null")
	private Long userId;

	@NotBlank(message = "userName must not be null or empty")
	private String userName;

}
