package com.bin.bole.service;

import com.bin.bole.dao.PoliticsStatusMapper;
import com.bin.bole.domain.emp.PoliticsStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsStatusService {

    @Autowired
    PoliticsStatusMapper politicsstatusMapper;

    public List<PoliticsStatus> getAllPoliticsstatus() {
        return politicsstatusMapper.getAllPoliticsstatus();
    }
}
