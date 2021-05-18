package com.bin.bole.dao;



import com.bin.bole.domain.sys.OpLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OpLog record);

    int insertSelective(OpLog record);

    OpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpLog record);

    int updateByPrimaryKey(OpLog record);

    List<OpLog> getOpLogByPage(@Param("page") Integer page, @Param("size") Integer size);

    long getTotal();

}