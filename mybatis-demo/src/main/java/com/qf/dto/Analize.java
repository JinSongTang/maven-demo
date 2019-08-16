package com.qf.dto;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author tangjinsong
 * @Classname Analize
 * @Description TODO
 * @Date 2019/8/13 15:46
 * @Created by tangjinsong
 */
@Data
public class Analize {

    long log_id;
    Integer result_num;
    ArrayList<Analize2>result;
}
