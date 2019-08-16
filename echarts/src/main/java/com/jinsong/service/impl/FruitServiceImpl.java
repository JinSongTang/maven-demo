package com.jinsong.service.impl;

import com.jinsong.dao.FruitMapper;
import com.jinsong.pojo.Fruit;
import com.jinsong.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author tangjinsong
 * @Classname FruitServiceImpl
 * @Description TODO
 * @Date 2019/8/12 16:47
 * @Created by tangjinsong
 */
@Service
public class FruitServiceImpl implements FruitService {


    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public Fruit selectByPrimaryKey(Integer id) {


        return fruitMapper.selectByPrimaryKey(id);
    }

    @Override
    public ArrayList<Fruit> select() {
        return fruitMapper.select();
    }
}
