package com.qf.controller;

import com.qf.pojo.UserInfo;
import com.qf.vo.ThymeleafUserInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/8/8.
 */
@Controller
public class ThymeleafController {

    @RequestMapping("demoOne")
    public String thymeleafDemoOne(Model model){
        model.addAttribute("message","许可笑得很慈祥");
        model.addAttribute("linkMessage","<a href='https://baike.baidu.com/item/%E8%BF%AA%E4%B8%BD%E7%83%AD%E5%B7%B4/1180418?fr=aladdin'>严博的女神</a>");
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("严博");
        userInfo.setPassword("123456");
        model.addAttribute("user",userInfo);
        ThymeleafUserInfoVO thymeleafUserInfoVO = new ThymeleafUserInfoVO();
        thymeleafUserInfoVO.setName("张三");
        thymeleafUserInfoVO.setRole("manager");

        model.addAttribute("userinfo",thymeleafUserInfoVO);

        ThymeleafUserInfoVO thymeleafUserInfoVO1 = new ThymeleafUserInfoVO();
        thymeleafUserInfoVO1.setName("王涛");
        thymeleafUserInfoVO1.setRole("admin");
        ThymeleafUserInfoVO thymeleafUserInfoVO2 = new ThymeleafUserInfoVO();
        thymeleafUserInfoVO2.setName("李杰");
        thymeleafUserInfoVO2.setRole("manager");
        ThymeleafUserInfoVO thymeleafUserInfoVO3 = new ThymeleafUserInfoVO();
        thymeleafUserInfoVO3.setName("刘松");
        thymeleafUserInfoVO3.setRole("emp");
        List<ThymeleafUserInfoVO> emps = new ArrayList<ThymeleafUserInfoVO>();
        emps.add(thymeleafUserInfoVO1);
        emps.add(thymeleafUserInfoVO2);
        emps.add(thymeleafUserInfoVO3);
        model.addAttribute("emps",emps);

        return "thymeleafdemo1";
    }

    @RequestMapping("testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("name","严博");
        return "thymeleafdemo2";
    }

    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(ModelAndView modelAndView){
        modelAndView.addObject("name","博哥爱热巴");
        modelAndView.setViewName("thymeleafdemo2");
        return modelAndView;
    }
}
