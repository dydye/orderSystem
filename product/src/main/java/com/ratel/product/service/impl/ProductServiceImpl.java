package com.ratel.product.service.impl;

import com.ratel.common.base.BaseServiceImpl;
import com.ratel.common.exception.ServiceError;
import com.ratel.common.exception.ServiceException;
import com.ratel.product.entity.Product;
import com.ratel.product.entity.ProductClassify;
import com.ratel.product.param.AddProductParam;
import com.ratel.product.repository.ProductRepository;
import com.ratel.product.service.ProductClassifyService;
import com.ratel.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Slf4j
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductClassifyService productClassifyService;

	@Override
	protected JpaRepository<Product, Long> getJpaRepository() {
		return productRepository;
	}

	@Override
	public int deleteByProductClassifyId(Long productClassifyId) {
		Objects.requireNonNull(productClassifyId, "productClassifyId must not be null");
		return productRepository.deleteByProductClassifyId(productClassifyId);
	}

	@Override
	public Long addProduct(AddProductParam param) throws ServiceException {

		ProductClassify productClassify = productClassifyService.findById(param.getProductClassifyId());
		if (productClassify == null) {
			throw new ServiceException(ServiceError.ProductError.PRODUCT_CLASSIFY_NOT_EXISTS);
		}

		Product product = new Product();
		BeanUtils.copyProperties(param, product);
		product.setCreateUserId(param.getUserId());
		product.setUpdateUserId(param.getUserId());
		Date date = new Date();
		product.setCreateTime(date);
		product.setUpdateTime(date);
		product = this.save(product);
		return product.getProductId();
	}

}
