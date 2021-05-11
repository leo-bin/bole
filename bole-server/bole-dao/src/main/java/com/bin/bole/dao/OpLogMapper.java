package com.bin.bole.dao;


import com.bin.bole.domain.sys.OpLog;
import org.springframework.stereotype.Repository;

@Repository
public interface OpLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    OpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);
}