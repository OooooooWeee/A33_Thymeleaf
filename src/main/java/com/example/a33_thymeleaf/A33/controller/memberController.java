package com.example.a33_thymeleaf.A33.controller;


import com.example.a33_thymeleaf.A33.MemberManager.FuzzySearch;
import com.example.a33_thymeleaf.A33.Model.Member;
import com.example.a33_thymeleaf.A33.util.DbException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("member")
public class memberController {

    @GetMapping("/")
    public ModelAndView membercontroll() throws DbException {
        ModelAndView mv = new ModelAndView("renyuan");
        List<Member> member = FuzzySearch.SearchAll();
        mv.addObject("members",member);
        return mv;
    }

}
