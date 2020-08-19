package com.ratel.product.controller;

import com.ratel.common.response.ApiResponse;
import com.ratel.product.param.AddProductParam;
import com.ratel.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@RestController
@RequestMapping("/product")
@Slf4j
@Api(tags = "product api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("addProduct")
	@ApiOperation(value = "add a product")
	public ApiResponse<Long> addProduct(@RequestBody @Validated AddProductParam param) {
		return ApiResponse.success(productService.addProduct(param));
	}

}
