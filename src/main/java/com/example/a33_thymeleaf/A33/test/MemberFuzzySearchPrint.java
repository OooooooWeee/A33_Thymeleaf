package com.example.a33_thymeleaf.A33.test;

import com.example.a33_thymeleaf.A33.MemberManager.FuzzySearch;
import com.example.a33_thymeleaf.A33.Model.Member;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.util.ArrayList;
import java.util.List;

//用来测试模糊查询的返回结果
public class MemberFuzzySearchPrint {
    public static void main(String[] args){
         Member m1 = new Member();
        List<Member> m2 = new ArrayList<Member>();
        List<Member>m3 = new ArrayList<Member>();
        try {
            m1 = FuzzySearch.SearchByMemberID(1);
            m2 = FuzzySearch.SearchByShopID(101);
            m3 = FuzzySearch.SearchByPosition("1");
        } catch (DbException e) {
            throw new RuntimeException(e);
        }
        System.out.println(m1.ID+" "+m1.TimelikeStart);
        for(int i=0;i<m2.size();i++){
            System.out.println(m2.get(i).ShopName+" "+m2.get(i).Position);
        }
        for(int i=0;i<m3.size();i++){
            System.out.println(m3.get(i).ShopName+" "+m3.get(i).Position);
        }
    }
}

