package com.example.a33_thymeleaf.A33.test;

import com.example.a33_thymeleaf.A33.ForecastManager.MemberNumGet;
import com.example.a33_thymeleaf.A33.util.DbException;

public class MemberNeed {

    public static void main(String[] args) throws DbException {
        System.out.println(MemberNumGet.WorkingNumGet("2023/5/10",101,0,8));
    }


}
