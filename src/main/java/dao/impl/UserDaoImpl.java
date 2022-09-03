package dao.impl;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component("userDao")
public class UserDaoImpl implements UserDao {
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
    public User selectById(String tar) {
        User user = new User();
        String sql = "select * from user where id = ?";
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tar);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user.setID(rs.getString("id"));
                user.setSuper(rs.getBoolean("issuper"));
                user.setPassword(rs.getString("password"));
            }else {
                user = null;
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
        return user;
    }

    @Override
    public int insert(User user) {
        int result = 0;
        String sql = "insert into user values(?,?,?)";
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getID());
            ps.setString(2,user.getPassword());
            ps.setBoolean(3,user.isSuper());
            result = ps.executeUpdate();
            ps.close();
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
    public int deleteById(String id) {
        int result = 0;
        String sql = "delete from user where id = ?";
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            result = ps.executeUpdate();
            ps.close();
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
