package utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class DBUtil {
    Connection conn = null;
    @Value("${className}")
    private String className;
    @Value("${dbUserName}")
    private String userName;
    @Value("${dbUserPasswd}")
    private String password;
    @Value("${dbURL}")
    private String url;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(className);
        conn = DriverManager.getConnection(url,userName,password);
        return conn;
    }
    public void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
