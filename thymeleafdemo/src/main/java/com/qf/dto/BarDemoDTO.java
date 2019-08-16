package com.qf.dto;

/**
 * Created by DELL on 2019/8/12.
 */

import lombok.Data;

import java.util.ArrayList;

/**
 * 用于给柱状图做数据传输,对应页面barDemo.html
 */
@Data
public class BarDemoDTO {
    String name;
    String type = "bar";
    int[] data = {};



}
