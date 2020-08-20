package com.ratel.order.controller;

import com.ratel.common.response.ApiResponse;
import com.ratel.order.entity.Order;
import com.ratel.order.param.AddOrderParam;
import com.ratel.order.service.OrderService;
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
@RequestMapping("order")
@Slf4j
@Api(tags = "order api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("addOrder")
	@ApiOperation(value = "add order")
	public ApiResponse<Long> addOrder(@RequestBody @Validated AddOrderParam params) {
		Order order = orderService.addOrder(params);
		return ApiResponse.success(order != null ? order.getOrderId() : null);
	}

	@GetMapping("getOrderById")
	@ApiOperation(value = "get an order")
	public ApiResponse<Order> getOrderById(@ApiParam(name = "orderId", required = true) @RequestParam Long orderId) {
		Order order = orderService.findById(orderId);
		return ApiResponse.success(order);
	}

	@PostMapping("deleteOrderById")
	@ApiOperation(value = "delete an order")
	public ApiResponse<Order> delete(@ApiParam(name = "orderId", required = true) @RequestParam Long orderId) {
		orderService.deleteById(orderId);
		return ApiResponse.success();
	}

}
