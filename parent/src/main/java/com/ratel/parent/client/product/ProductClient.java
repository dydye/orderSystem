package com.ratel.parent.client.product;

import com.ratel.parent.client.config.ServerConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@FeignClient(ServerConfig.PRODUCT_NAME)
public interface ProductClient {

}
