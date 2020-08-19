package com.ratel.common.response;

import com.ratel.common.exception.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author daiyun
 * @date 2020/8/19
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -703399492847094638L;

    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "success";

    /**
     * success: 200
     */
    private Integer retCode;

    /**
     * success tip: success
     */
    private String retMsg;

    /**
     * result
     */
    private T data;

    /**
     * success
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success() {
        return new ApiResponse<T>().setRetCode(SUCCESS_CODE).setRetMsg(SUCCESS_MSG);
    }

    /**
     * success
     * @param data return data
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>().setRetCode(SUCCESS_CODE).setRetMsg(SUCCESS_MSG).setData(data);
    }

    /**
     * failure
     * @param baseErrorCode
     * @param <T>
     * @return
     */
    public static <T> ApiResponse<T> failure(BaseErrorCode baseErrorCode) {
        return new ApiResponse<T>().setRetCode(baseErrorCode.getCode()).setRetMsg(baseErrorCode.getMsg());
    }
}
