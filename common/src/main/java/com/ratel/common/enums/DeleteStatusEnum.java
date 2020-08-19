package com.ratel.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Getter
@AllArgsConstructor
public enum DeleteStatusEnum {

	NORMAL(0,"normal"),
	DELETED(1,"deleted");

	private Integer status;
	private String desc;

}
