package com.jinsong.dao;


import com.jinsong.pojo.Fruit;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface FruitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fruit record);

    int insertSelective(Fruit record);

    Fruit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fruit record);

    int updateByPrimaryKey(Fruit record);

    @Select("select * from fruit")
    ArrayList<Fruit> select();
}