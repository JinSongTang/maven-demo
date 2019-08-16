package com.qf.controller;


import com.qf.dto.BarDemoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by DELL on 2019/8/12.
 */
@RestController
public class EChartsController {

    @RequestMapping("getBarChartsData")
    public Object getBarChartsData(){
        ArrayList<BarDemoDTO> barDemoDTOArrayList = new ArrayList<BarDemoDTO>();
        BarDemoDTO barDemoDTO1 = new BarDemoDTO();
        barDemoDTO1.setName("2011年");
        int[] data1 = {18203, 23489, 29034, 104970, 131744, 630230};
        barDemoDTO1.setData(data1);
        barDemoDTOArrayList.add(barDemoDTO1);

        BarDemoDTO barDemoDTO2 = new BarDemoDTO();
        barDemoDTO2.setName("2012年");
        int[] data2 = {19325, 23438, 31000, 121594, 134141, 681807};
        barDemoDTO2.setData(data2);
        barDemoDTOArrayList.add(barDemoDTO2);


        BarDemoDTO barDemoDTO3 = new BarDemoDTO();
        barDemoDTO3.setName("2018年");
        int[] data3 = {19325, 23438, 31000, 130594, 139541, 681807};
        barDemoDTO3.setData(data3);
        barDemoDTOArrayList.add(barDemoDTO3);


        return barDemoDTOArrayList;
    }
}
