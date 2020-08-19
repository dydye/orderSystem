package com.ratel.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * error msg
 *
 * @author daiyun
 * @date 2020/8/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String msg;
}
