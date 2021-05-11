package com.bin.bole.dao;


import com.bin.bole.domain.sys.SysMsg;
import org.springframework.stereotype.Repository;

@Repository
public interface SysMsgMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysMsg record);

    int insertSelective(SysMsg record);

    SysMsg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMsg record);

    int updateByPrimaryKey(SysMsg record);
}