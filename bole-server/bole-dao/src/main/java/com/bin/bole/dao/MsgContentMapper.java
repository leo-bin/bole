package com.bin.bole.dao;


import com.bin.bole.domain.sys.MsgContent;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsgContent record);

    int insertSelective(MsgContent record);

    MsgContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MsgContent record);

    int updateByPrimaryKey(MsgContent record);
}