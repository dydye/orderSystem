package com.ratel.common.exception;

/**
 * @author daiyun
 * @date 2020/8/19
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 3869002098988476867L;

	private ErrorMsg errorMsg;

	public ServiceException(ErrorMsg errorMsg) {
		super(errorMsg.getMsg());
		this.errorMsg = errorMsg;
	}

	public ServiceException(int code, String msg) {
		super(msg);
		this.errorMsg = new ErrorMsg(code, msg);
	}

	public ServiceException(String msg, Exception cause) {
		super(msg, cause);
	}

	public ServiceException(BaseErrorCode baseErrorCode) {
		this.errorMsg = new ErrorMsg(baseErrorCode.getCode(), baseErrorCode.getMsg());
	}

	public ErrorMsg getErrorMsg() {
		return errorMsg;
	}
}
