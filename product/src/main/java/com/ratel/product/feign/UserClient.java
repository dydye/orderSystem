package com.ratel.product.feign;

import com.ratel.common.base.ServerConfig;
import com.ratel.common.response.ApiResponse;
import com.ratel.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author daiyun
 * @date 2020/8/20
 */
@FeignClient(ServerConfig.USER_NAME)
public interface UserClient {

	@PostMapping("/user/addUser")
	ApiResponse<User> addUser(@RequestBody User user);

	@GetMapping("/user/getUser")
	ApiResponse<User> getUser(@RequestParam Long userId);
}
