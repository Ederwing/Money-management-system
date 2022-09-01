package dao.impl;

import dao.Dao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component("userDao")
public class UserDao implements Dao {
    @Autowired
    private DBUtil dbu;
    public LinkedList<User> select_all() {
        String sql = "select * from user";
        LinkedList<User> users = new LinkedList<User>();
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getString("id"));
                user.setPassword(rs.getString("password"));
                user.setSuper(rs.getBoolean("issuper"));
                users.add(user);
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbu.closeConnection(conn);
        }
        return users;
    }

    @Override
    public Object select(Object tar) {
        User user = (User) tar;
        String sql = "select * from user where id = ?";
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getID());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setSuper(rs.getBoolean("issuper"));
                user.setPassword(rs.getString("password"));
            }else {
                user = null;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
          dbu.closeConnection(conn);
        }
        return user;
    }

    @Override
    public int insert(Object user) {
        int result = 0;
        User tem = (User) user;
        String sql = "insert into user values(?,?,?)";
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tem.getID());
            ps.setString(2,tem.getPassword());
            ps.setBoolean(3,tem.isSuper());
            result = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbu.closeConnection(conn);
        }
        return result;
    }

    @Override
    public int delete(Object user) {
        int result = 0;
        User tem = (User) user;
        String sql = "delete from user where id = ?";
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tem.getID());
            result = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            dbu.closeConnection(conn);
        }
        return result;
    }
}
