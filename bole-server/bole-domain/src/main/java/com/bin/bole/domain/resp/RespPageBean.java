package com.bin.bole.domain.resp;

import lombok.Data;

import java.util.List;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote
 */
@Data
public class RespPageBean {

    private Long total;
    private List<?> data;
}
