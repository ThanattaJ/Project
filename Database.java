/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.news;
import java.sql.*;
public class Database {
    public static Connection connectDb(String user,String pass) {
        String url = "jdbc:mysql://139.59.231.113:3306/test";
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url,user,pass);
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
