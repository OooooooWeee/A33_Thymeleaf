package com.example.a33_thymeleaf.A33.test;

import com.example.a33_thymeleaf.A33.Model.Forecast;
import com.example.a33_thymeleaf.A33.util.BaseException;
import com.example.a33_thymeleaf.A33.ForecastManager.ForecastShow;

import java.util.ArrayList;
import java.util.List;

public class ForecastTest {
    public static void main(String[] args)throws BaseException {
        List<Forecast> f= ForecastShow.ChooseByDate(102,"2023/5/10");
        List<Double> f2 = new ArrayList<>();
        for(int i=0;i<f.size();i++){
            System.out.println(f.get(i).PassengerFlow/6);
        }

    }
}
