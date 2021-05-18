package com.bin.bole.service;

import com.bin.bole.dao.OpLogMapper;
import com.bin.bole.domain.emp.Employee;
import com.bin.bole.domain.resp.RespPageBean;
import com.bin.bole.domain.sys.OpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author binLi
 * @date 2021/5/17 17:19
 * Description:
 */
@Service
public class OpLogService {

    @Autowired
    private OpLogMapper opLogMapper;

    public RespPageBean getOpLogByPage(Integer page, Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<OpLog> data = opLogMapper.getOpLogByPage(page, size);
        Long total = opLogMapper.getTotal();
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

}
