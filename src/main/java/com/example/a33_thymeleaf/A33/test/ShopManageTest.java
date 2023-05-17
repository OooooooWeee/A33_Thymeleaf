package com.example.a33_thymeleaf.A33.test;

import com.example.a33_thymeleaf.A33.Model.Shop;
import com.example.a33_thymeleaf.A33.ShopManager.ShopManage;
import com.example.a33_thymeleaf.A33.util.BaseException;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.util.ArrayList;
import java.util.List;

import static com.example.a33_thymeleaf.A33.ShopManager.ShopManage.*;

public class ShopManageTest {
    public static void main(String[] args)throws BaseException {
        List<Shop> s = new ArrayList<>();
        try {
            s = ShopManage.SearchByShopID(101);
           for(int i=0;i<s.size();i++){
                System.out.println(s.get(i).ShopName+" "+s.get(i).Address);
            }
           //createStore(996,"996","996",996);
           updateStore(996,"007","007",007);
           deleteStore(996);

        } catch (DbException e) {
            throw new RuntimeException(e);
        }

    }

}
