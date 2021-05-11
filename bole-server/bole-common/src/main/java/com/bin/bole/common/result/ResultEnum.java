package com.bin.bole.common.result;

import lombok.Getter;

/**
 * @author binLi
 * @date 2021/3/10 5:36 下午
 * Description：result enum
 **/
@Getter
public enum ResultEnum {

    SUCCESS(200, "成功"),
    ERROR(-200, "请求失败"),
    SQL_ERROR(-301, "数据库错误");

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;
}
