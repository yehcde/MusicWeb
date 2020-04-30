package com.yhc.music.dao;

import com.yhc.music.bean.User;
import com.yhc.music.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDAO
 *
 * @author yehaocheng
 * @version 1.0
 */
public class UserDAO {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 成功返回用户Bean，失败返回null
     */
    public User login(String username, String password) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            assert conn != null;
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("登录失败。");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return user;
    }
    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println("查询用户信息失败。");
            e.printStackTrace();
        } finally {
            ConnectionUtil.release(rs, stmt, conn);
        }
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean updateUser(User user) {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "UPDATE user SET username = ?, password = ?,phone = ?WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getPhone());
            stmt.setLong(4, user.getId());
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("查询用户信息失败。");
            e.printStackTrace();
            return false;
        } finally {
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;
    }

    /**
     * 注册用户
     *
     * @return
     */
    public boolean register(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 获得连接:
            conn = ConnectionUtil.getConnection();
            // 编写SQL:
            String sql = "insert into user values (null,?,?,null,null)";
            // 预处理SQL:
            stmt = conn.prepareStatement(sql);
            // 设置参数的值:
            stmt.setString(1, username);
            stmt.setString(2, password);
            // 执行SQL:
            int num = stmt.executeUpdate();
            if (num > 0) {
                System.out.println("保存成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 释放资源
            ConnectionUtil.release(null, stmt, conn);
        }
        return true;

    }

}




