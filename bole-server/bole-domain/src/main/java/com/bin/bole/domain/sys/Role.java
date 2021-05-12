package com.bin.bole.domain.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * @author leo-bin
 * @date 2021/5/11 15:25
 * @apiNote
 */
@Data
public class Role implements Serializable {

    private Integer id;
    private String name;
    private String nameZh;
}
