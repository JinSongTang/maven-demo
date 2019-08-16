package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author tangjinsong
 * @Classname PictureLoadController
 * @Description TODO
 * @Date 2019/8/14 11:54
 * @Created by tangjinsong
 */
@Controller
@RequestMapping("picture")
public class PictureLoadController {

    @ResponseBody
    @RequestMapping("picture")//picture/picture
    public Map<String, String> getPath(@RequestBody Map<String,String> map){

        System.out.println(map);
        return map;
    }
}
