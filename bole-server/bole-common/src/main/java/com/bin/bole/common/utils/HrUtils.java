package com.bin.bole.common.utils;

import com.bin.bole.domain.hr.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author binLi
 * @date 2021/5/11 5:34 下午
 * Description：
 **/
public class HrUtils {

    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
