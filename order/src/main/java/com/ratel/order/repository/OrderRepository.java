package com.ratel.order.repository;

import com.ratel.order.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAllByUserId(Long userId, Pageable pageable);

}
