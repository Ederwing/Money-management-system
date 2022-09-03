package dao.impl;

import dao.RecordDao;
import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component("recordDao")
public class RecordDaoImpl implements RecordDao {
    @Autowired
    DBUtil dbu;
    @Override
    public LinkedList<Record> select_all() {
        String sql = "select * from record";
        LinkedList<Record> ret = new LinkedList<Record>();
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Record record = new Record();
                record.setID(rs.getString("id"));
                record.setIncome(rs.getBoolean("isincome"));
                record.setValue(rs.getInt("value"));
                record.setType(rs.getString("type"));
                //???
                record.setTime(rs.getString("time"));
                ret.add(record);
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
        return ret;
    }

    @Override
    public LinkedList<Record> selectById(String id) {
        String sql = "select * from record where id = ?";
        LinkedList<Record> ret = new LinkedList<Record>();
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Record record = new Record();
                record.setTime(rs.getString("time"));
                record.setType(rs.getString("type"));
                record.setValue(rs.getInt("value"));
                record.setIncome(rs.getBoolean("isincome"));
                record.setID(rs.getString("id"));
                ret.add(record);
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
        return ret;
    }

    @Override
    public LinkedList<Record> selectByIsIncome(String id, Boolean isIncome) {
        String sql = "select * from record where id = ? and isincome = ?";
        LinkedList<Record> ret = new LinkedList<Record>();
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setBoolean(2,isIncome);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Record record = new Record();
                record.setTime(rs.getString("time"));
                record.setType(rs.getString("type"));
                record.setValue(rs.getInt("value"));
                record.setIncome(rs.getBoolean("isincome"));
                record.setID(rs.getString("id"));
                ret.add(record);
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
        return ret;
    }

    @Override
    public int insert(Record tar) {
        String sql = "insert into record values(?,?,?,?,?)";
        int result = 0;
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tar.getID());
            ps.setBoolean(2,tar.isIncome());
            ps.setDouble(3,tar.getValue());
            ps.setString(4,tar.getType());
            ps.setString(5,tar.getTime());
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
    public int delete(Record tar) {
        //By primary key
        String sql = "delete from record where id=? and time=?";
        int result = 0;
        Connection conn = null;
        try {
            conn = dbu.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,tar.getID());
            ps.setString(2,tar.getTime());
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
        String sql = "delete from record where id=?";
        int result = 0;
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
