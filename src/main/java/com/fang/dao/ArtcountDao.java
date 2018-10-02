package com.fang.dao;

import com.fang.model.Artcount;

public interface ArtcountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Artcount record);

    int insertSelective(Artcount record);

    Artcount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Artcount record);

    int updateByPrimaryKey(Artcount record);
}