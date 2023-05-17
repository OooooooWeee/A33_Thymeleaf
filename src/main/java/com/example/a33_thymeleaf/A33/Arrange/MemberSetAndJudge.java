package com.example.a33_thymeleaf.A33.Arrange;

import com.example.a33_thymeleaf.A33.util.BaseException;
import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.SQLException;

public class MemberSetAndJudge {
    public static int CheckBuzzy(int id) throws DbException/*判断员工是否忙碌*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM member WHERE member.isBuzzy = 0 AND MemberID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
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
    public static void SetBuzzy(int MemberID)throws BaseException/*将员工设为忙碌*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE member SET isBuzzy = 1 WHERE MemberID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, MemberID);
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
    public static void SetIdel(int MemberID)throws BaseException/*将员工设为空闲*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE member SET isBuzzy = 0 WHERE MemberID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, MemberID);
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
    public static void DayWorkTimeRes(int MemberID)throws BaseException/*日工作时间清零*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE member set member.DayTime = 0 WHERE member.MemberID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, MemberID);
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
    public static void WeekWorkTimeRes(int MemberID)throws BaseException/*周工作时间清零*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE member set member.WeekTime = 0 WHERE member.MemberID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, MemberID);
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
    public static void SetBuzzyIfOverTime(int MemberID)throws BaseException/*周工作时间清零*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT * FROM member WHERE member.DayTime>8 OR member.WeekTime>40 AND member.MemberID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,MemberID);
            java.sql.ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                SetBuzzy(MemberID);
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
    }
    public static void updataAllBuzzy(int ShopID)throws BaseException/*将全体员工设为空闲*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE member SET isBuzzy = 0 WHERE ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, ShopID);
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
