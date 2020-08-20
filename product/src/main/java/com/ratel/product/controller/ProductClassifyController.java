package com.ratel.product.controller;

import com.ratel.common.response.ApiResponse;
import com.ratel.product.entity.ProductClassify;
import com.ratel.product.param.AddProductClassifyParam;
import com.ratel.product.service.ProductClassifyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@RestController
@RequestMapping("/productClassify")
@Slf4j
@Api(tags = "productClassify api")
public class ProductClassifyController {

	@Autowired
	private ProductClassifyService productClassifyService;

	@PostMapping("addProductClassify")
	@ApiOperation(value = "add productClassify")
	public ApiResponse<Long> addProductClassify(@RequestBody @Validated AddProductClassifyParam param) {
		ProductClassify productClassify = new ProductClassify();
		BeanUtils.copyProperties(param, productClassify);
		Date date = new Date();
		productClassify.setCreateTime(date);
		productClassify.setUpdateTime(date);
		productClassify = productClassifyService.save(productClassify);
		return ApiResponse.success(productClassify.getProductClassifyId());
	}

	@GetMapping("getProductClassifyById")
	@ApiOperation(value = "get an productClassify")
	public ApiResponse<ProductClassify> getProductClassifyById(
			@ApiParam(value = "productClassifyId", required = true) @RequestParam Long productClassifyId) {
		ProductClassify productClassify = productClassifyService.findById(productClassifyId);
		return ApiResponse.success(productClassify);
	}

	@PostMapping("deleteProductClassify")
	@ApiOperation(value = "delete the productClassify and delete the product ")
	public ApiResponse<Integer> deleteProductClassify(
			@ApiParam(value = "productClassifyId", required = true) @RequestParam Long productClassifyId) {
		int count = productClassifyService.deleteProductClassify(productClassifyId);
		return ApiResponse.success(count);
	}



}
