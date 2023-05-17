package com.example.a33_thymeleaf.A33.MemberManager;

import com.example.a33_thymeleaf.A33.Model.Member;
import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuzzySearch /*员工模糊查询*/{
    public static List<Member> SearchAll() throws DbException/*全部人员*/{
        List<Member> result = new ArrayList<Member>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT member.MemberID,MemberName,ShopName,Position,DayLikeStart,DayLikeEnd,TimeLikeStart,TimeLikeEnd,TimeLongLike,Phone,Mail\n" +
                    "FROM member,prefer,shop\n" +
                    "WHERE member.MemberID = prefer.MemberID\n" +
                    "AND shop.ShopID = member.ShopID";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Member m = new Member();
                m.setID(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setShopName(rs.getString(3));
                m.setPosition(rs.getString(4));
                m.setDaylikeStart(rs.getString(5));
                m.setDaylikeEnd(rs.getString(6));
                m.setTimelikeStart(rs.getString(7));
                m.setTimelikeEnd(rs.getString(8));
                m.setTimelong(rs.getInt(9));
                m.setPhone(rs.getString(10));
                m.setMail(rs.getString(11));
                result.add(m);
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

    public static List<Member> SearchIdel() throws DbException/*空闲人员*/{
        List<Member> result = new ArrayList<Member>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT member.MemberID,MemberName,ShopName,Position,DayLikeStart,DayLikeEnd,TimeLikeStart,TimeLikeEnd,TimeLongLike,Phone,Mail\n" +
                    "FROM member,prefer,shop\n" +
                    "WHERE member.MemberID = prefer.MemberID\n" +
                    "AND shop.ShopID = member.ShopID\n" +
                    "AND isBuzzy = 0";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Member m = new Member();
                m.setID(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setShopName(rs.getString(3));
                m.setPosition(rs.getString(4));
                m.setDaylikeStart(rs.getString(5));
                m.setDaylikeEnd(rs.getString(6));
                m.setTimelikeStart(rs.getString(7));
                m.setTimelikeEnd(rs.getString(8));
                m.setTimelong(rs.getInt(9));
                m.setPhone(rs.getString(10));
                m.setMail(rs.getString(11));
                result.add(m);
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
    public static  Member SearchByMemberID(int ID) throws DbException /*员工ID的模糊查询*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT member.MemberID,MemberName,ShopName,Position,DayLikeStart,DayLikeEnd,TimeLikeStart,TimeLikeEnd,TimeLongLike,Phone,Mail\n" +
                    "FROM member,prefer,shop\n" +
                    "WHERE member.MemberID = prefer.MemberID\n" +
                    "AND shop.ShopID = member.ShopID\n" +
                    "AND member.MemberID LIKE ? ";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ID);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Member m = new Member();
                m.setID(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setShopName(rs.getString(3));
                m.setPosition(rs.getString(4));
                m.setDaylikeStart(rs.getString(5));
                m.setDaylikeEnd(rs.getString(6));
                m.setTimelikeStart(rs.getString(7));
                m.setTimelikeEnd(rs.getString(8));
                m.setTimelong(rs.getInt(9));
                m.setPhone(rs.getString(10));
                m.setMail(rs.getString(11));
                return m;
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
    public static List<Member> SearchByShopID(int ShopID) throws DbException/*门店的模糊查询*/{
        List<Member> result = new ArrayList<Member>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT member.MemberID,MemberName,ShopName,Position,DayLikeStart,DayLikeEnd,TimeLikeStart,TimeLikeEnd,TimeLongLike,Phone,Mail\n" +
                    "FROM member,prefer,shop\n" +
                    "WHERE member.MemberID = prefer.MemberID\n" +
                    "AND shop.ShopID = member.ShopID\n" +
                    "AND shop.ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Member m = new Member();
                m.setID(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setShopName(rs.getString(3));
                m.setPosition(rs.getString(4));
                m.setDaylikeStart(rs.getString(5));
                m.setDaylikeEnd(rs.getString(6));
                m.setTimelikeStart(rs.getString(7));
                m.setTimelikeEnd(rs.getString(8));
                m.setTimelong(rs.getInt(9));
                m.setPhone(rs.getString(10));
                m.setMail(rs.getString(11));
                result.add(m);
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
    public static List<Member> SearchByPosition(String position) throws DbException/*岗位的模糊查询*/{
        List<Member> result = new ArrayList<Member>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT member.MemberID,MemberName,ShopName,Position,DayLikeStart,DayLikeEnd,TimeLikeStart,TimeLikeEnd,TimeLongLike,Phone,Mail\n" +
                    "FROM member,prefer,shop\n" +
                    "WHERE member.MemberID = prefer.MemberID\n" +
                    "AND shop.ShopID = member.ShopID\n" +
                    "AND member.Position like ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, position);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Member m = new Member();
                m.setID(rs.getInt(1));
                m.setName(rs.getString(2));
                m.setShopName(rs.getString(3));
                m.setPosition(rs.getString(4));
                m.setDaylikeStart(rs.getString(5));
                m.setDaylikeEnd(rs.getString(6));
                m.setTimelikeStart(rs.getString(7));
                m.setTimelikeEnd(rs.getString(8));
                m.setTimelong(rs.getInt(9));
                m.setPhone(rs.getString(10));
                m.setMail(rs.getString(11));
                result.add(m);
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
