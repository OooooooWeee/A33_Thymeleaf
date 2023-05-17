package com.example.a33_thymeleaf.A33.ShopManager;

import com.example.a33_thymeleaf.A33.Model.Shop;
import com.example.a33_thymeleaf.A33.util.BaseException;
import com.example.a33_thymeleaf.A33.util.BusinessException;
import com.example.a33_thymeleaf.A33.util.DBUtil;
import com.example.a33_thymeleaf.A33.util.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopManage/*门店信息管理*/ {
    public static List<Shop> SearchAll() throws DbException/*门店查询*/{
        List<Shop> result = new ArrayList<Shop>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT ShopName,Address,Size FROM shop ";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Shop shop = new Shop();
                shop.setShopName(rs.getString(1));
                shop.setAddress(rs.getString(2));
                shop.setSize(rs.getInt(3));
                result.add(shop);
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
    public static List<Shop> SearchByShopID(int ShopID) throws DbException/*门店ID的模糊查询*/{
        List<Shop> result = new ArrayList<Shop>();
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "SELECT ShopName,Address,Size FROM shop WHERE ShopID LIKE ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            java.sql.ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                Shop shop = new Shop();
                shop.setShopName(rs.getString(1));
                shop.setAddress(rs.getString(2));
                shop.setSize(rs.getInt(3));
                result.add(shop);
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
    public static void createStore(int ShopID,String ShopName,String Address,int Size)throws BaseException/*增加门店*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from shop where ShopID=?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ShopID);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) throw new BusinessException("ID已经被占用");
            rs.close();
            pst.close();
            sql = "insert INTO shop(ShopID,ShopName,Address,Size,isDelete) VALUES (?,?,?,?,0)";
            pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            pst.setString(2,ShopName);
            pst.setString(3,Address);
            pst.setInt(4,Size);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                throw new DbException(e);
            } catch (DbException ex) {
                throw new RuntimeException(ex);
            }
        } catch (BusinessException e) {
            throw new RuntimeException(e);
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
    public static void updateStore(int ShopID,String ShopName,String Address,int Size)throws BaseException/*更新门店*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE shop SET ShopName = ?,Address = ?,Size = ? WHERE ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst = conn.prepareStatement(sql);
            pst.setString(1, ShopName);
            pst.setString(2, Address);
            pst.setInt(3,Size);
            pst.setInt(4,ShopID);
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
    public static void deleteStore(int ShopID)throws BaseException/*删除门店（将isDelete更新为1即删除）*/{
        Connection conn = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "UPDATE shop SET isDelete = 1 WHERE ShopID = ?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
            pst = conn.prepareStatement(sql);
            pst.setInt(1,ShopID);
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