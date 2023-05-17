package com.example.a33_thymeleaf.A33.RuleManager;

import com.example.a33_thymeleaf.A33.Model.Rule;
import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public class RuleSelect /*筛选出合适的规则*/{
    public static Rule AllUsefulRule() throws DbException /*筛选通用规则*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT rule.PrepareTime,rule.PrepareDivNum,rule.PreparePow,rule.EmptyMemNum,rule.WorkDivNum,rule.WorkPow,rule.CloseTime,rule.CloseDivNum,rule.CloseAddNum,rule.ClosePow\n" +
                    "from rule\n" +
                    "WHERE rule.RuleID = 1";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Rule r = new Rule();
                r.setPrepareTime(rs.getInt(1));
                r.setPrepareDivNum(rs.getInt(2));
                r.setPreparePow(rs.getString(3));
                r.setEmptyMemNum(rs.getInt(4));
                r.setWorkDivNum(rs.getDouble(5));
                r.setWorkPow(rs.getString(6));
                r.setCloseTime(rs.getInt(7));
                r.setCloseDivNum(rs.getInt(8));
                r.setCloseAddNum(rs.getInt(9));
                r.setClosePow(rs.getString(10));
                return r;
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
        return null;
    }
    public static Rule ShopUsefulRule(int ShopID) throws DbException /*筛选店铺规则*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT rule.PrepareTime,rule.PrepareDivNum,rule.PreparePow,rule.EmptyMemNum,rule.WorkDivNum,rule.WorkPow,rule.CloseTime,rule.CloseDivNum,rule.CloseAddNum,rule.ClosePow\n" +
                    "from rule\n" +
                    "WHERE rule.ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Rule r = new Rule();
                r.setPrepareTime(rs.getInt(1));
                r.setPrepareDivNum(rs.getInt(2));
                r.setPreparePow(rs.getString(3));
                r.setEmptyMemNum(rs.getInt(4));
                r.setWorkDivNum(rs.getDouble(5));
                r.setWorkPow(rs.getString(6));
                r.setCloseTime(rs.getInt(7));
                r.setCloseDivNum(rs.getInt(8));
                r.setCloseAddNum(rs.getInt(9));
                r.setClosePow(rs.getString(10));
                return r;
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
        return null;
    }
    public static void RuleUpdate(int RuleID,int PrepareTime,int PrepareDivNum,String PreparePow,int EmptyMemNum,double WorkDivNum,String WorkPow,int CloseTime,int CloseDivNum,int CloseAddNum,String ClosePow ,int ShopID) throws DbException/*更新规则*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE rule SET rule.PrepareTime = ?,rule.PrepareDivNum = ?,PreparePow = ?,EmptyMemNum = ?,WorkDivNum = ?,WorkPow = ?,closetime = ?,CloseDivNum = ?,CloseAddNum = ?,ClosePow = ? \n" +
                    "WHERE rule.ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setInt(1,PrepareTime);
            pst.setInt(2,PrepareDivNum);
            pst.setString(3,PreparePow);
            pst.setInt(4,EmptyMemNum);
            pst.setDouble(5,WorkDivNum);
            pst.setString(6,WorkPow);
            pst.setInt(7,CloseTime);
            pst.setInt(8,CloseDivNum);
            pst.setInt(9,CloseAddNum);
            pst.setString(10,ClosePow);
            pst.setInt(11,ShopID);
            pst.execute();
            pst.close();
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
    }
}
