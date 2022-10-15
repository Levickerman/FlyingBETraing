import jdbc.JDBC;
import whattoeat.WhatToEat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void testUsers(Connection conn) throws SQLException {
        WhatToEat operator = new WhatToEat();
        operator.addUser(conn, "Z39", "08192932@cumt.edu.cn", "imZ39");
        operator.addUser(conn, "CC", "fakeemail", "imcc");
        operator.addUser(conn, "YY", "fakeemail", "imyy");
        operator.deleteUser(conn, 1);
        operator.getUserlist(conn);
    }

    public static void testFood(Connection conn) throws SQLException {
        WhatToEat operator = new WhatToEat();
        operator.addFood(conn, "chicken", '2', '1');
        operator.addFood(conn, "bread", '1', '1');
        operator.addFood(conn, "other", '0', '0');
        operator.deleteFood(conn, 3);
        operator.getFoodlist(conn);
    }

    public static void testStarsandRandomFood(Connection conn) throws SQLException {
        WhatToEat operator = new WhatToEat();
        operator.getstar(conn, 2, 1);
        operator.getstar(conn, 3, 2);
        operator.getstar(conn, 2, 2);
        operator.randomselectfood(conn);
        operator.showmystar(conn, 2);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/whattoeat";
        String user = "root";
//        Scanner input = new Scanner(System.in);
//        String pass = input.next();
        String pass = "zhxzuibang0205!";
        Connection conn = (new JDBC(url, user, pass)).getJDBCConnection();
        testUsers(conn);
        testFood(conn);
        testStarsandRandomFood(conn);
    }
}