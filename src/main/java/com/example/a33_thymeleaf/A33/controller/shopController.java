package com.example.a33_thymeleaf.A33.controller;

import com.example.a33_thymeleaf.A33.Model.Shop;
import com.example.a33_thymeleaf.A33.ShopManager.ShopManage;
import com.example.a33_thymeleaf.A33.util.DbException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("shop")
public class shopController {

    @GetMapping("/")
    public ModelAndView ShopSelect() throws DbException {
        ModelAndView mv = new ModelAndView("mendian");
        List<Shop> shops = new ArrayList<>();
        shops = ShopManage.SearchAll();
//        List<String> names = new ArrayList<>();
//        List<String> address = new ArrayList<>();
//        List<Integer> size = new ArrayList<>();
//        for(int i=0;i<shops.size();i++){
//            names.add(i,shops.get(i).getShopName());
//            address.add(i,shops.get(i).getAddress());
//            size.add(i,shops.get(i).getSize());
//        }
//        mv.addObject("names",names);
//        mv.addObject("address",address);
//        mv.addObject("size",size);
        mv.addObject("shops",shops);
        return mv;

    }

}
