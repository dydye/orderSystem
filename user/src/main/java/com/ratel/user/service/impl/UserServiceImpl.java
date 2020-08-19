package com.ratel.user.service.impl;

import com.ratel.common.base.BaseServiceImpl;
import com.ratel.user.entity.User;
import com.ratel.user.repository.UserRepository;
import com.ratel.user.service.UserService;
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
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected JpaRepository<User, Long> getJpaRepository() {
		return userRepository;
	}
}
