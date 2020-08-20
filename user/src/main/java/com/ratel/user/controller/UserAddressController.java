package com.ratel.user.controller;

import com.ratel.common.response.ApiResponse;
import com.ratel.user.entity.UserAddress;
import com.ratel.user.service.UserAddressService;
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
 * @date 2020/8/20
 */
@RestController
@RequestMapping("userAddress")
@Slf4j
public class UserAddressController {

	@Autowired
	private UserAddressService userAddressService;

	@PostMapping("addUserAddress")
	public ApiResponse<UserAddress> addUserAddress(@RequestBody UserAddress userAddress){
		Date date = new Date();
		userAddress.setCreateTime(date);
		userAddress.setUpdateTime(date);
		userAddress = userAddressService.save(userAddress);
		return ApiResponse.success(userAddress);
	}

	@GetMapping("getUserAddress")
	public ApiResponse<UserAddress> getUserAddress(@RequestParam Long userAddressId) {
		UserAddress userAddress = userAddressService.findById(userAddressId);
		return ApiResponse.success(userAddress);
	}
}
