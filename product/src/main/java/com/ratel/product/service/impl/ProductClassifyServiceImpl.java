package com.ratel.product.service.impl;

import com.ratel.common.base.BaseServiceImpl;
import com.ratel.product.entity.ProductClassify;
import com.ratel.product.repository.ProductClassifyRepository;
import com.ratel.product.service.ProductClassifyService;
import com.ratel.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Slf4j
@Service
public class ProductClassifyServiceImpl extends BaseServiceImpl<ProductClassify, Long> implements ProductClassifyService {

	@Autowired
	private ProductClassifyRepository productClassifyRepository;

	@Autowired
	private ProductService productService;

	@Override
	protected JpaRepository<ProductClassify, Long> getJpaRepository() {
		return productClassifyRepository;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteProductClassify(Long productClassifyId) {

		Objects.requireNonNull(productClassifyId, "productClassifyId must not be null");

		ProductClassify productClassify = this.findById(productClassifyId);
		if (productClassify == null) {
			return 0;
		}

		this.deleteById(productClassifyId);
		int deleteProductCount = productService.deleteByProductClassifyId(productClassifyId);
		log.info("delete product classify:{}, delete product:{}", 1, deleteProductCount);
		return 1;
	}
}
