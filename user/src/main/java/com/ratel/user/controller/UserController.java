package com.ratel.user.controller;

import com.ratel.common.response.ApiResponse;
import com.ratel.user.entity.User;
import com.ratel.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("addUser")
	public ApiResponse<User> addUser(@RequestBody User user){
		Date date = new Date();
		user.setCreateTime(date);
		user.setUpdateTime(date);
		user = userService.save(user);
		return ApiResponse.success(user);
	}

	@GetMapping("getUser")
	public ApiResponse<User> getUser(@RequestParam Long userId) {
		User user = userService.findById(userId);
		return ApiResponse.success(user);
	}
}
