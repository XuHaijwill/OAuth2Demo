package cn.xhjc.mapper;

import cn.xhjc.model.Func;

public interface FuncMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Func record);

    int insertSelective(Func record);

    Func selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Func record);

    int updateByPrimaryKey(Func record);
}