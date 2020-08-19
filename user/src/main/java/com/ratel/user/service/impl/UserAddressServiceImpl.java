package com.ratel.user.service.impl;

import com.ratel.common.base.BaseServiceImpl;
import com.ratel.user.entity.UserAddress;
import com.ratel.user.repository.UserAddressRepository;
import com.ratel.user.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Service
@Slf4j
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddress, Long> implements UserAddressService {

	@Autowired
	private UserAddressRepository userAddressRepository;

	@Override
	protected JpaRepository<UserAddress, Long> getJpaRepository() {
		return userAddressRepository;
	}

}
