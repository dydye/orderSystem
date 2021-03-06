package com.ratel.user.repository;

import com.ratel.user.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

}
