package com.bin.bole.common.exception;

import com.bin.bole.common.result.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author binLi
 * @date 2021/3/11 5:46 下午
 * Description：
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalException extends RuntimeException {

    private Integer code;

    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public GlobalException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
}
