package com.ratel.parent.client.user;

import com.ratel.parent.client.config.ServerConfig;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@FeignClient(ServerConfig.USER_NAME)
public interface UserClient {
}