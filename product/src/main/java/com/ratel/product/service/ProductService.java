package com.ratel.product.service;

import com.ratel.common.base.BaseService;
import com.ratel.common.exception.ServiceException;
import com.ratel.product.entity.Product;
import com.ratel.product.param.AddProductParam;

/**
 * @author daiyun
 * @date 2020/8/19
 */
public interface ProductService extends BaseService<Product, Long> {

	/**
	 * delete by productClassifyId
	 * @param productClassifyId
	 * @return					  Number of deletions
	 */
	int deleteByProductClassifyId(Long productClassifyId);

	/**
	 * add a product
	 * @param param
	 * @return		 primary key id
	 */
	Long addProduct(AddProductParam param) throws ServiceException;
}
