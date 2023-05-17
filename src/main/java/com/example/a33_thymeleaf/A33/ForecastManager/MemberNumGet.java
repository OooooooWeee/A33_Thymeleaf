package com.example.a33_thymeleaf.A33.ForecastManager;

import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public class MemberNumGet {
    public static int CheckPassengerFlow(String Date,int ShopID,int StartTime,int EndTime) throws DbException/*判断客流量是否为0*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT\n" +
                    "\t* \n" +
                    "FROM\n" +
                    "\tforecast \n" +
                    "WHERE\n" +
                    " forecast.ShopID = ?\n" +
                    "\tAND forecast.Date LIKE ?\n" +
                    "\tAND forecast.StartTime = ?\n" +
                    "\tAND forecast.EndTime = ?\n" +
                    "\tAND forecast.PassengerFlow = 0.0";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,Date);
            pst.setInt(2,ShopID);
            pst.setInt(3,StartTime);
            pst.setInt(4,EndTime);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return 1;
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
        return 0;
    }
    public static int GetEmptyMemNum(int ShopID) throws DbException/*获得无人时店铺所需要的人数*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT EmptyMemNum from rule where ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int n = rs.getInt(1);
                return n;
            }else{
                sql = "SELECT EmptyMemNum from rule where ShopID = 0";
                java.sql.PreparedStatement pst2 = conn.prepareStatement(sql);
                java.sql.ResultSet rs2 = pst.executeQuery();
                if(rs2.next()){
                    int m = rs2.getInt(1);
                    return m;
                }
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
        return 0;
    }
    public static int PrepareNumGet(String Date,int ShopID,int StartTime,int EndTime) throws DbException/*取得开店前所需人数*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT ROUND(AVG(shop.Size/rule.PrepareDivNum))\n" +
                    "FROM forecast,shop,rule\n" +
                    "WHERE  forecast.Date = ?\n" +
                    "AND forecast.ShopID = shop.ShopID=rule.ShopID\n" +
                    "AND forecast.ShopID =?\n" +
                    "AND forecast.StartTime >= ?\n" +
                    "AND forecast.EndTime <= ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,Date);
            pst.setInt(2,ShopID);
            pst.setInt(3,StartTime);
            pst.setInt(4,EndTime);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int Num = rs.getInt(1);
                return Num;
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
        return 100;
    }
    public static int WorkingNumGet(String Date,int ShopID,int StartTime,int EndTime) throws DbException/*取得工作时前所需人数*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT ROUND(AVG(forecast.PassengerFlow/rule.WorkDivNum))\n" +
                    "FROM forecast,shop,rule\n" +
                    "WHERE  forecast.Date = ?\n" +
                    "AND forecast.ShopID = shop.ShopID=rule.ShopID\n" +
                    "AND forecast.ShopID =?\n" +
                    "AND forecast.StartTime >= ?\n" +
                    "AND forecast.EndTime <= ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,Date);
            pst.setInt(2,ShopID);
            pst.setInt(3,StartTime);
            pst.setInt(4,EndTime);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int Num = rs.getInt(1);
                return Num;
            }
            if (CheckPassengerFlow(Date,ShopID,StartTime,EndTime)==1){
                int n = GetEmptyMemNum(ShopID);
                return n;
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
        return 100;
    }
    public static int CloseNumGet(String Date,int ShopID,int StartTime,int EndTime) throws DbException/*取得关店时前所需人数*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT ROUND(AVG(shop.Size/rule.CloseDivNum)) + rule.CloseAddNum\n" +
                    "FROM forecast,shop,rule\n" +
                    "WHERE  forecast.Date = ?\n" +
                    "AND forecast.ShopID = shop.ShopID=rule.ShopID\n" +
                    "AND forecast.ShopID = ?\n" +
                    "AND forecast.StartTime >= ?\n" +
                    "AND forecast.EndTime <= ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,Date);
            pst.setInt(2,ShopID);
            pst.setInt(3,StartTime);
            pst.setInt(4,EndTime);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int Num = rs.getInt(1);
                return Num;
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
        return 100;
    }
}
