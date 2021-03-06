package com.ratel.common.exception;

import lombok.AllArgsConstructor;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@AllArgsConstructor
public enum ServiceError implements BaseErrorCode {
	SYSTEM_ERROR(1000, "system_error");

	private final int code;
	private final String msg;

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@AllArgsConstructor
	public enum ProductError implements BaseErrorCode {
		PRODUCT_NOT_EXISTS(2000, "product not exists"),
		PRODUCT_CLASSIFY_NOT_EXISTS(2001, "product classify not exists"),
		PRODUCT_SHORT_STOCK(2002, "product in short stock");

		private final int code;
		private final String msg;

		@Override
		public int getCode() {
			return code;
		}

		@Override
		public String getMsg() {
			return msg;
		}
	}

	@AllArgsConstructor
	public enum UserError implements BaseErrorCode {
		USER_NOT_EXISTS(3000, "user not exists"),
		USER_ADDRESS_NOT_EXISTS(3000, "user address not exists");
		private final int code;
		private final String msg;

		@Override
		public int getCode() {
			return code;
		}

		@Override
		public String getMsg() {
			return msg;
		}
	}

}
