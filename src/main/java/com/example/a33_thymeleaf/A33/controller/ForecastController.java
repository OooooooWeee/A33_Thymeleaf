package com.example.a33_thymeleaf.A33.controller;

import com.example.a33_thymeleaf.A33.ForecastManager.ForecastShow;
import com.example.a33_thymeleaf.A33.Model.Forecast;
import com.example.a33_thymeleaf.A33.util.DbException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("forecast")
public class ForecastController {
    @GetMapping("/")
    public ModelAndView ForecastControll() throws DbException {
        ModelAndView mv = new ModelAndView("yewu");
        List<Forecast> Forecasts =ForecastShow.ChooseAll();
        mv.addObject("Forecasts",Forecasts);
        return mv;
    }
}
