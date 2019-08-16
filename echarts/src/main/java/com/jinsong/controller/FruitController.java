package com.jinsong.controller;


import com.jinsong.dto.FruitDemo2;

import com.jinsong.pojo.Fruit;
import com.jinsong.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author tangjinsong
 * @Classname FruitController
 * @Description TODO
 * @Date 2019/8/12 16:49
 * @Created by tangjinsong
 */
@RestController

public class FruitController {

    @Autowired
    private FruitService fruitService;
@RequestMapping("echarts")
    public ArrayList<FruitDemo2> Fruit(){

    ArrayList<FruitDemo2>list=new ArrayList<>();

    ArrayList<Fruit>fruitList=fruitService.select();

    FruitDemo2 f1=new FruitDemo2();
    f1.setName(fruitList.get(0).getName());
    f1.setValue(fruitList.get(0).getNum());

    FruitDemo2 f2=new FruitDemo2();
    f2.setName(fruitList.get(1).getName());
    f2.setValue(fruitList.get(1).getNum());

    FruitDemo2 f3=new FruitDemo2();
    f3.setName(fruitList.get(2).getName());
    f3.setValue(fruitList.get(2).getNum());

    FruitDemo2 f4=new FruitDemo2();
    f4.setName(fruitList.get(3).getName());
    f4.setValue(fruitList.get(3).getNum());

    FruitDemo2 f5=new FruitDemo2();
    f5.setName(fruitList.get(4).getName());
    f5.setValue(fruitList.get(4).getNum());

    list.add(f1);
    list.add(f2);
    list.add(f3);
    list.add(f4);
    list.add(f5);
        return list;
    }
}
