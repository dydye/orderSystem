package com.ratel.order.service.impl;

import com.ratel.common.base.BaseServiceImpl;
import com.ratel.common.enums.DeleteStatusEnum;
import com.ratel.order.entity.Order;
import com.ratel.order.param.AddOrderParam;
import com.ratel.order.repository.OrderRepository;
import com.ratel.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Service
@Slf4j
public class OrderServiceImpl extends BaseServiceImpl<Order, Long> implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	protected JpaRepository<Order, Long> getJpaRepository() {
		return orderRepository;
	}

	@Override
	public Order addOrder(AddOrderParam param) {
		Order order = new Order();
		Date date = new Date();
		order.setCreateTime(date);
		order.setUpdateTime(date);
		order.setDeleteStatus(DeleteStatusEnum.DELETED.getStatus());
		return orderRepository.save(order);
	}

}
