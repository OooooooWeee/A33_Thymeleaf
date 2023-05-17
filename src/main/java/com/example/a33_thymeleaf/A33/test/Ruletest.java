package com.example.a33_thymeleaf.A33.test;

import com.example.a33_thymeleaf.A33.Model.Rule;
import com.example.a33_thymeleaf.A33.util.BaseException;
import com.example.a33_thymeleaf.A33.RuleManager.RuleSelect;

public class Ruletest {
    public static void main(String[] args)throws BaseException {
        Rule rule1 = new Rule();
        rule1 = RuleSelect.AllUsefulRule();
        Rule rule2 = new Rule();
        rule2 = RuleSelect.ShopUsefulRule(102);
        System.out.println(rule1.PrepareDivNum);
        System.out.println(rule2.PrepareDivNum);
        RuleSelect.RuleUpdate(1,2,90,"123456",1,3.8,"123456",1,80,1,"123456",101);
    }
}
