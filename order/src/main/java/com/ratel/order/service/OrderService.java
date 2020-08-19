package com.ratel.order.service;

import com.ratel.common.base.BaseService;
import com.ratel.order.entity.Order;
import com.ratel.order.param.AddOrderParam;

/**
 * @author daiyun
 * @date 2020/8/19
 */
public interface OrderService extends BaseService<Order, Long> {

	/**
	 * add order
	 * @param param order param
	 * @return		 order detail
	 */
	Order addOrder(AddOrderParam param);
}
