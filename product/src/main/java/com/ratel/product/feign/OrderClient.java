package com.ratel.product.feign;

import com.ratel.common.base.ServerConfig;
import com.ratel.common.response.ApiResponse;
import com.ratel.order.param.AddOrderParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@FeignClient(ServerConfig.ORDER_NAME)
public interface OrderClient {

	@PostMapping("/order/addOrder")
	ApiResponse<Long> addOrder(@RequestBody @Validated AddOrderParam params);
}
