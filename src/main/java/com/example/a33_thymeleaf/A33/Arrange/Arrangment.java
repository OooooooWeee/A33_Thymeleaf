package com.example.a33_thymeleaf.A33.Arrange;

import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Arrangment {
    public static List<Integer> ArrangeByTime(int Day, int StartTime, int EndTime, int Limit) throws DbException /*按时间偏好筛选员工,返回员工ID集合*/ {
        Connection conn = null;
        List<Integer> result = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT DISTINCT \n" +
                    "prefer.MemberID\n" +
                    "FROM\n" +
                    "\tprefer \n" +
                    "WHERE\n" +
                    "  ? > prefer.DayLikeStart \n" +
                    "\tOR ? < prefer.DayLikeEnd \n" +
                    "\tAND ? > prefer.TimeLikeStart\n" +
                    "\tAND ? < prefer.TimeLikeEnd\n" +
                    "\tOR prefer.DayLikeStart = prefer.DayLikeEnd = NULL\n" +
                    "\tOR prefer.TimeLikeStart = prefer.TimeLikeEnd = NULL\n" +
                    "\tOR prefer.TimeLongLike = NULL\n" +
                    "LIMIT ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Day);
            pst.setInt(2, Day);
            pst.setInt(3, StartTime);
            pst.setInt(4, EndTime);
            pst.setInt(5, Limit);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                result.add(id);
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
    public static List<Integer> ArrangeByPosition(String Position, int Limit) throws DbException /*按时间偏好筛选员工,返回员工ID集合*/ {
        Connection conn = null;
        List<Integer> result = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM prefer WHERE prefer.PositionLike LIKE ?\n" +
                    "OR prefer.PositionLike = NULL\n" +
                    "OR prefer.PositionLike = \" \"\n" +
                    "LIMIT ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, '%' + Position + '%');
            pst.setInt(2, Limit);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                result.add(id);
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
    public static List<Integer> ArrangeWhenIdel(int Limit) throws DbException /*按是否空闲筛选员工,返回员工ID集合*/ {
        Connection conn = null;
        List<Integer> result = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM member WHERE member.isBuzzy = 0" +
                    "LIMIT ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, Limit);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                result.add(id);
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
