package com.ratel.user;

import com.ratel.common.response.ApiResponse;
import com.ratel.user.controller.UserAddressController;
import com.ratel.user.controller.UserController;
import com.ratel.user.entity.User;
import com.ratel.user.entity.UserAddress;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	@Autowired
	private UserController userController;

	@Autowired
	private UserAddressController userAddressController;

	@Test
	public void testUserAddress() {
		UserAddress userAddress = new UserAddress();
		userAddress.setAddressId(1L);
		userAddress.setUserId(1L);
		userAddress.setProvince("hunan");
		userAddress.setPhone("18390940098");
		userAddress.setCreateTime(new Date());
		userAddress.setCity("sz");
		userAddressController.addUserAddress(userAddress);

		ApiResponse<UserAddress> userAddressApiResponse = userAddressController.getUserAddress(1L);
		UserAddress dbUserAddress = userAddressApiResponse.getData();
		Assert.assertNotNull(dbUserAddress);
		Assert.assertEquals("hunan", dbUserAddress.getProvince());
	}

	@Test
	public void testUser() {
		User user = new User();
		user.setUserId(1L);
		user.setNickName("dy");
		user.setPhone("18390940098");
		user.setEmail("yun820047889@163.com");
		user.setUserRealName("daiyun");
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		userController.addUser(user);

		ApiResponse<User> userApiResponse = userController.getUser(1L);
		User dbUser = userApiResponse.getData();
		Assert.assertNotNull(dbUser);
		Assert.assertEquals("daiyun", dbUser.getUserRealName());
	}

}
