package com.bin.bole.domain.sys;

import lombok.Data;

import java.io.Serializable;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote
 */
@Data
public class Meta implements Serializable {

    private Boolean keepAlive;
    private Boolean requireAuth;
}
