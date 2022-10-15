package whattoeat;

import java.sql.*;

public class WhatToEat {
    public int addUser(Connection conn, String username, String email, String password) throws SQLException {
        String sql = "insert into Users(username, email, password) value ";
        sql = sql + "(\""+username+"\", \""+email+"\", \""+password+"\");";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int rs = pstm.executeUpdate();
        pstm.close();
        return rs;
    }
    public int deleteUser(Connection conn, int id) throws SQLException {
        String sql = "delete from Users where id = "+id+";";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int rs = pstm.executeUpdate();
        pstm.close();
        return rs;
    }
    public int updateUser(Connection conn, int id ){
        return 1;
    }
    public void getUserlist(Connection conn) throws SQLException {
        String sql = "select id, username, email from Users";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String username = rs.getString(2);
            String email = rs.getString(3);
            System.out.println(id+"\t"+username+"\t"+email);
        }
        pstm.close();
    }
    public int addFood(Connection conn, String name, char canteen, char floor) throws SQLException {
        String sql = "insert into Food(name, canteen, floor) value ";
        sql = sql + "(\""+name+"\", \""+canteen+"\", \""+floor+"\");";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int rs = pstm.executeUpdate();
        pstm.close();
        return rs;
    }
    public int deleteFood(Connection conn, int id) throws SQLException {
        String sql = "delete from Food where id = "+id+";";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int rs = pstm.executeUpdate();
        pstm.close();
        return rs;
    }
    public int updateFood(Connection conn, int id ){
        return 1;
    }
    public void getFoodlist(Connection conn) throws SQLException {
        String sql = "select id, name, canteen, floor from Food";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String canteen = rs.getString(3);
            String floor = rs.getString(4);
            System.out.println(id+"\t"+name+"\t"+canteen+"\t"+floor);
        }
        pstm.close();
    }
    public int getstar(Connection conn, int userid, int foodid) throws SQLException {
        String sql = "insert into Stars value (" + userid + ", " + foodid + ");";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int rs = pstm.executeUpdate();
        return rs;
    }
    public int cancelstar(Connection conn, int userid, int foodid) throws SQLException {
        String sql = "drop from Stars where user_id=" + userid + " and food_id=" + foodid + ";";
        PreparedStatement pstm = conn.prepareStatement(sql);
        int rs = pstm.executeUpdate();
        return rs;
    }
    public void showmystar(Connection conn, int userid) throws SQLException {
        String sql = "select food_id from Stars where user_id=" + userid +";";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }
    }
    public void randomselectfood(Connection conn) throws SQLException {
        String sql = "select max(id), min(id) from Food;";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        rs.next();
        int randseed = (int) Math.floor((rs.getInt(1) - rs.getInt(2) + 1)*Math.random() + rs.getInt(2));
        sql = "select * from Food where id>=" + randseed + " limit 1;";
        pstm = conn.prepareStatement(sql);
        rs = pstm.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
    }
}
