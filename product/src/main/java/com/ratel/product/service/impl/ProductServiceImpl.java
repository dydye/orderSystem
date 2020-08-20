package com.ratel.product.service.impl;

import com.ratel.common.base.BaseServiceImpl;
import com.ratel.common.exception.ServiceError;
import com.ratel.common.exception.ServiceException;
import com.ratel.common.response.ApiResponse;
import com.ratel.order.param.AddOrderParam;
import com.ratel.product.entity.Product;
import com.ratel.product.entity.ProductClassify;
import com.ratel.product.feign.OrderClient;
import com.ratel.product.feign.UserAddressClient;
import com.ratel.product.feign.UserClient;
import com.ratel.product.param.AddProductParam;
import com.ratel.product.param.BuyProductParam;
import com.ratel.product.repository.ProductRepository;
import com.ratel.product.service.ProductClassifyService;
import com.ratel.product.service.ProductService;
import com.ratel.user.entity.User;
import com.ratel.user.entity.UserAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private UserClient userClient;

	@Autowired
	private UserAddressClient userAddressClient;

	@Autowired
	private OrderClient orderClient;

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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean buyProduct(BuyProductParam buyProductParam) throws ServiceException {

		ApiResponse<User> userApiResponse = userClient.getUser(buyProductParam.getUserId());
		User user = ApiResponse.successData(userApiResponse);
		if (user == null) {
			throw new ServiceException(ServiceError.UserError.USER_NOT_EXISTS);
		}

		synchronized (this) {
			Product product = this.findById(buyProductParam.getProductId());
			if (product == null) {
				throw new ServiceException(ServiceError.ProductError.PRODUCT_NOT_EXISTS);
			}

			if (buyProductParam.getBuyNum() > product.getProductStock()) {
				throw new ServiceException(ServiceError.ProductError.PRODUCT_SHORT_STOCK);
			} else {
				product.setProductStock(product.getProductStock() - buyProductParam.getBuyNum());
				this.save(product);
			}

			createOrder(product, user);
		}

		return true;
	}

	private void createOrder(Product product, User user) {

		ApiResponse<UserAddress> userAddressApiResponse = userAddressClient.getUserAddress(user.getUserId());
		UserAddress userAddress = ApiResponse.successData(userAddressApiResponse);
		if (userAddress == null) {
			throw new ServiceException(ServiceError.UserError.USER_ADDRESS_NOT_EXISTS);
		}

		AddOrderParam addOrderParam = new AddOrderParam();
		addOrderParam.setReceiverAddress(userAddress.getAddress());
		addOrderParam.setReceiverName(user.getUserRealName());
		addOrderParam.setReceiverPhone(userAddress.getPhone());
		addOrderParam.setReceiverPostCode(userAddress.getPostCode());
		addOrderParam.setUserId(user.getUserId());
		addOrderParam.setProductId(product.getProductId());
		orderClient.addOrder(addOrderParam);
	}
}
