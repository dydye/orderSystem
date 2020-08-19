package com.ratel.product.repository;

import com.ratel.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    int deleteByProductClassifyId(Long productClassifyId);
}
