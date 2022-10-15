package jdbc;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC {
    private String url;
    private String user;
    private String pass;
    public JDBC(String url, String user, String pass){
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
// 获得connection
    public Connection getJDBCConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.user, this.pass);
    }
}
