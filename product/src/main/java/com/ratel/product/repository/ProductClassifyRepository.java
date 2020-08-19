package com.ratel.product.repository;

import com.ratel.product.entity.ProductClassify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Repository
public interface ProductClassifyRepository extends JpaRepository<ProductClassify, Long> {

}
