package com.jinsong.service;


import com.jinsong.pojo.Fruit;

import java.util.ArrayList;

/**
 * @author tangjinsong
 * @Classname FruitService
 * @Description TODO
 * @Date 2019/8/12 16:47
 * @Created by tangjinsong
 */

public interface FruitService {

    Fruit selectByPrimaryKey(Integer id);

    ArrayList<Fruit> select();
}
