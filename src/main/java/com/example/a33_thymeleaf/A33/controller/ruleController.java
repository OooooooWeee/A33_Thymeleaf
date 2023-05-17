package com.example.a33_thymeleaf.A33.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("rule")
public class ruleController {
    @GetMapping("/")
    public ModelAndView RuleControll(){
        ModelAndView mv = new ModelAndView("guize");
        return mv;
    }
}
