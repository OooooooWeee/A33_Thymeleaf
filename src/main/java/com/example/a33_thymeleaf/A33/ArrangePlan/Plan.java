package com.example.a33_thymeleaf.A33.ArrangePlan;

import com.example.a33_thymeleaf.A33.Arrange.MemberSetAndJudge;
import com.example.a33_thymeleaf.A33.ForecastManager.MemberNumGet;
import com.example.a33_thymeleaf.A33.MemberManager.FuzzySearch;
import com.example.a33_thymeleaf.A33.Model.Member;
import com.example.a33_thymeleaf.A33.util.BaseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Plan {
    /**
     * 重置表格,需传入门店信息,
     */
    public static void ResetTable(int shopID) throws BaseException {
        MemberSetAndJudge.updataAllBuzzy(shopID);

    }

    /**
     * 确定每个时间段的人选.需要店铺代号和一周的每一天日期的数组，格式：xxxx/xx/xx
     */
    public static List<String> WorkingMember(String Date, int shopID, int Limit) throws BaseException {
        String NameAll = " ";
        List<String> rs = new ArrayList<>();
        List<Member> whiteMouse = FuzzySearch.SearchByShopID(shopID);
        for (int i = 0; i < 7; i++) {
            NameAll = " ";
            ResetTable(shopID);
            int People = MemberNumGet.WorkingNumGet(Date, shopID, 4 * i, 4 * i + 3);
            Collections.shuffle(whiteMouse);
            if (People == 0) {
                for (int k = 0; k < Limit; k++) {
                    if (MemberSetAndJudge.CheckBuzzy(whiteMouse.get(k).getID()) == 1) {
                        System.out.println(whiteMouse.get(k).Name);
                        NameAll = NameAll + " " + whiteMouse.get(k).Name;
                        MemberSetAndJudge.SetBuzzy(whiteMouse.get(k).getID());
                    }
                }
            }
                for (int j = 0; j < People; j++) {
                    if (MemberSetAndJudge.CheckBuzzy(whiteMouse.get(j).getID()) == 1) {
                        System.out.println(whiteMouse.get(j).Name);
                        NameAll = NameAll + " " + whiteMouse.get(j).Name;
                        MemberSetAndJudge.SetBuzzy(whiteMouse.get(j).getID());
                    }
                }
            rs.add(i, NameAll);
        }
        return rs;

//    public static void


    }
}


