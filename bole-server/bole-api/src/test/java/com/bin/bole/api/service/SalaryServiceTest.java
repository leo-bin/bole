package com.bin.bole.api.service;

import com.bin.bole.api.BoleApplicationTests;
import com.bin.bole.dao.EmpSalaryMapper;
import com.bin.bole.domain.resp.EmpSalaryResp;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
class SalaryServiceTest extends BoleApplicationTests {

    @Autowired
    EmpSalaryMapper empSalaryMapper;

    @Test
    public void testGetByWorkId() {
        EmpSalaryResp empSalaryResp = empSalaryMapper.selectByWorkId("00000001");
        if (empSalaryResp != null) {
            log.info("result={}", empSalaryResp);
        } else {
            log.info("结果为空");
        }
    }
}