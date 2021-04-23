package com.bin.bole.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author binLi
 * @date 2021/3/10 5:34 下午
 * Description：union result
 **/
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5882662533480341434L;

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String msg;
    /**
     * 消息体
     */
    private T data;

    /**
     * success
     */
    public static <T> Result<T> success(Integer code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> success(T data) {
        return success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    /**
     * error
     */
    public static <T> Result<T> error(Integer code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(T data) {
        return error(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(), data);
    }

    public static <T> Result<T> error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static <T> Result<T> error(Integer code, String msg) {
        return error(code, msg, null);
    }
}
