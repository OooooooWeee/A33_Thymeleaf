package com.example.a33_thymeleaf.A33.ForecastManager;

import com.example.a33_thymeleaf.A33.Model.Forecast;
import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForecastShow {
    public static List<Forecast> ChooseAll() throws DbException/*所有预测数据*/{
        List<Forecast> result = new ArrayList<Forecast>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select forecast.ShopID,shop.ShopName,forecast.Date,forecast.StartTime,forecast.EndTime,forecast.PassengerFlow\n" +
                    "FROM forecast,shop\n" +
                    "WHERE forecast.ShopID = shop.ShopID\n";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Forecast forecast = new Forecast();
                forecast.setShopID(rs.getInt(1));
                forecast.setShopName(rs.getString(2));
                forecast.setDate(rs.getString(3));
                forecast.setStartTime(rs.getInt(4));
                forecast.setEndTime(rs.getInt(5));
                forecast.setPassengerFlow(rs.getInt(6));
                result.add(forecast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(e);
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return result;
    }
    public static List<Forecast> ChooseByShopID(int ShopID) throws DbException/*按门店的ID选择预测数据*/{
        List<Forecast> result = new ArrayList<Forecast>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select forecast.ShopID,shop.ShopName,forecast.Date,forecast.StartTime,forecast.EndTime,forecast.PassengerFlow\n" +
                    "FROM forecast,shop\n" +
                    "WHERE forecast.ShopID = shop.ShopID\n" +
                    "and shop.ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Forecast forecast = new Forecast();
                forecast.setShopID(rs.getInt(1));
                forecast.setShopName(rs.getString(2));
                forecast.setDate(rs.getString(3));
                forecast.setStartTime(rs.getInt(4));
                forecast.setEndTime(rs.getInt(5));
                forecast.setPassengerFlow(rs.getInt(6));
                result.add(forecast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(e);
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return result;
    }
    public static List<Forecast> ChooseByDate(int ShopID,String Date) throws DbException/*按门店的ID和日期选择预测数据*/{
        List<Forecast> result = new ArrayList<Forecast>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select forecast.ShopID,shop.ShopName,forecast.Date,forecast.StartTime,forecast.EndTime,forecast.PassengerFlow\n" +
                    "FROM forecast,shop\n" +
                    "WHERE forecast.ShopID = shop.ShopID\n" +
                    "and shop.ShopID = ? \n" +
                    "AND forecast.Date like ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            pst.setString(2,Date);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Forecast forecast = new Forecast();
                forecast.setShopID(rs.getInt(1));
                forecast.setShopName(rs.getString(2));
                forecast.setDate(rs.getString(3));
                forecast.setStartTime(rs.getInt(4));
                forecast.setEndTime(rs.getInt(5));
                forecast.setPassengerFlow(rs.getInt(6));
                result.add(forecast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(e);
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        return result;
    }
}
