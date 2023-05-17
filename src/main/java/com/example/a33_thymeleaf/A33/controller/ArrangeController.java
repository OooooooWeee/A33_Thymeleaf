package com.example.a33_thymeleaf.A33.controller;


import com.example.a33_thymeleaf.A33.ArrangePlan.Plan;
import com.example.a33_thymeleaf.A33.MemberManager.FuzzySearch;
import com.example.a33_thymeleaf.A33.Model.Member;
import com.example.a33_thymeleaf.A33.util.BaseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("arrange")
public class ArrangeController {
    @GetMapping("/auto")
    public ModelAndView ForecastAuto() throws BaseException {
        ModelAndView mv =new ModelAndView("zhineng");
        String date1 = "2023/5/10";
        String date2 = "2023/5/11";
        String date3 = "2023/5/12";
        String date4 = "2023/5/14";
        String date5 = "2023/5/14";
        String date6 = "2023/5/15";
        String date7 = "2023/5/16";
        int Limit = 1;
        List<String> plan1 = Plan.WorkingMember(date1,101,Limit);
        List<String> plan2 = Plan.WorkingMember(date2,101,Limit);
        List<String> plan3 = Plan.WorkingMember(date3,101,Limit);
        List<String> plan4 = Plan.WorkingMember(date4,101,Limit);
        List<String> plan5 = Plan.WorkingMember(date5,101,Limit);
        List<String> plan6 = Plan.WorkingMember(date6,101,Limit);
        List<String> plan7 = Plan.WorkingMember(date7,101,Limit);
        mv.addObject("plan1",plan1);
        mv.addObject("plan2",plan2);
        mv.addObject("plan3",plan3);
        mv.addObject("plan4",plan4);
        mv.addObject("plan5",plan5);
        mv.addObject("plan6",plan6);
        mv.addObject("plan7",plan7);
        return mv;
    }
    @GetMapping("/manual")
    public ModelAndView ForecastManual() throws BaseException {
        ModelAndView mv = new ModelAndView("kaifang");
        String date1 = "2023/5/10";
        String date2 = "2023/5/11";
        String date3 = "2023/5/12";
        String date4 = "2023/5/14";
        String date5 = "2023/5/14";
        String date6 = "2023/5/15";
        String date7 = "2023/5/16";
        int Limit = 1;
        List<String> plan1 = Plan.WorkingMember(date1,101,Limit);
        List<String> plan2 = Plan.WorkingMember(date2,101,Limit);
        List<String> plan3 = Plan.WorkingMember(date3,101,Limit);
        List<String> plan4 = Plan.WorkingMember(date4,101,Limit);
        List<String> plan5 = Plan.WorkingMember(date5,101,Limit);
        List<String> plan6 = Plan.WorkingMember(date6,101,Limit);
        List<String> plan7 = Plan.WorkingMember(date7,101,Limit);
        mv.addObject("plan1",plan1);
        mv.addObject("plan2",plan2);
        mv.addObject("plan3",plan3);
        mv.addObject("plan4",plan4);
        mv.addObject("plan5",plan5);
        mv.addObject("plan6",plan6);
        mv.addObject("plan7",plan7);
        List<Member> member = FuzzySearch.SearchIdel();
        mv.addObject("idles",member);
        return mv;
    }
}
