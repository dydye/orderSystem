package com.ratel.product.controller;

import com.ratel.common.response.ApiResponse;
import com.ratel.product.entity.Product;
import com.ratel.product.param.AddProductParam;
import com.ratel.product.param.BuyProductParam;
import com.ratel.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("buyProduct")
	@ApiOperation(value = "buy product")
	public ApiResponse<Boolean> buyProduct(@RequestBody @Validated BuyProductParam buyProductParam) {
		boolean isSuccess = productService.buyProduct(buyProductParam);
		return ApiResponse.success(isSuccess);
	}


	@GetMapping("getProduct")
	@ApiOperation(value = "get an product")
	public ApiResponse<Product> getProduct(
			@ApiParam(value = "productId", required = true) @RequestParam Long productId) {
		Product product = productService.findById(productId);
		return ApiResponse.success(product);
	}

}
