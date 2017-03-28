/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.news;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

public class adminNews {

    private String header;
    private String description;
    private String author;
    private String dateUser;
    private long newsId = 00000;
    private Database db = new Database();
    private Date date = new Date();
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public adminNews(String header, String description) {
        this.header = header;
        this.description = description;
    }

    public adminNews() {
        
    }
    
    public String showNews(){
        return "----"+header +"----\nContent : "+description;
    }

    public void insertNews(String head, String detail) {
        Connection c = null;
        date = new Date();
        dateUser = df.format(date);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = Database.connectDb("win", "win016");
            Statement s = c.createStatement();
            newsId++;
            String sql = "insert into GreenSociety.News VALUES ('"+newsId+"','"+head+"','"+detail+"','1111','"+date+"')";
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();    //โชว์ข้อผิดพลาดทั้งหมด
        }
        try{
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteNews(long newsId){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = Database.connectDb("win", "win016");
            Statement s = c.createStatement();
//            newsId++;
            String sql = "DELETE FROM GreenSociety.News WHERE newsId='"+newsId+"'";
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();    //โชว์ข้อผิดพลาดทั้งหมด
        }
        try{
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void editNews(String head, String detail, long newsId) {
        Connection c = null;
//        user = new Date();
//        date = df.format(user);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = Database.connectDb("win", "win016");
            Statement s = c.createStatement();
//            newsId++;
            String sql = "update GreenSociety.News SET newsDescription='"+head+"',newsDetails='"+detail+"'WHERE newsId='"+newsId+"'";
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();    //โชว์ข้อผิดพลาดทั้งหมด
        }
        try{
            c.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void submitButton(int yesNo) {
        switch (yesNo) {
            case 1:
                System.out.println("Submit");
                insertNews(header, description);
            case 2:
                System.out.println("Close");
                header = "";
                description = "";
            //ทุกค่าเป็นค่าเริ่มต้น     
        }
    }
}
