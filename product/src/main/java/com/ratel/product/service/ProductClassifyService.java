package com.ratel.product.service;

import com.ratel.common.base.BaseService;
import com.ratel.product.entity.ProductClassify;

/**
 * @author daiyun
 * @date 2020/8/19
 */
public interface ProductClassifyService extends BaseService<ProductClassify, Long> {
	/**
	 * delete the productClassify and delete the product
	 * @param productClassifyId
	 * @return
	 */
	int deleteProductClassify(Long productClassifyId);
}
