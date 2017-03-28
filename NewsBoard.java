/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.news;

/**
 *
 * @author user
 */
import int105.news.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewsBoard {
    private String nameNews;
    private String descrip;

    public NewsBoard(String nameNews, String descrip) {
        this.nameNews = nameNews;
        this.descrip = descrip;
    }

    public String getNameNews() {
        return nameNews;
    }

    public void setNameNews(String nameNews) {
        this.nameNews = nameNews;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public void keepNews(){
        try{
            Database cndb = new Database();
            Connection connect = Database.connectDb("win", "win016");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database connecting");
        
            Statement st = connect.createStatement(); 
            String temp = "SELECT * FROM GreenSociety.News";
            
            ResultSet rs = st.executeQuery(temp);
            
//            while(rs.next()){
//                System.out.println("newsID: " + rs.getInt("newsID"));
//                System.out.println("newsDescription: " + rs.getString("newsDescription"));
//                System.out.println("newslDetails: " + rs.getString("manualDetails"));
//                System.out.println("----------------------------------------------");
//            }
            
            try {
		if(connect != null){
                    connect.close();
		}
		}catch (SQLException e){
                    e.printStackTrace();
		}
        }
        
        catch(ClassNotFoundException cfe){
            System.out.println(cfe);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("");
    }
    public void showNews(){
        try{
            Database cndb = new Database();
            Connection connect = Database.connectDb("win", "win016");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database connecting");
        
            Statement st = connect.createStatement(); 
            String temp = "SELECT * FROM GreenSociety.News";
            ResultSet rs = st.executeQuery(temp);
    
            while(rs.next()){
                System.out.println("newsID: " + rs.getInt("newsID"));
                System.out.println("newsDescription: " + rs.getString("newsDescription"));
                System.out.println("newslDetails: " + rs.getString("manualDetails"));
                System.out.println("----------------------------------------------");
            }
            
            try {
		if(connect != null){
                    connect.close();
		}
		}catch (SQLException e){
                    e.printStackTrace();
		}
        }
        
        catch(ClassNotFoundException cfe){
            System.out.println(cfe);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        System.out.println("");
                                 
    }
}
//    public int showNews(int listNews){
//        switch(listNews){
//            case 0:     
//                System.out.println("Latest News");
//                break;
//            case 1:
//                System.out.println("All News");
//                
//                break;
//            
//        }
//        return listNews;
//    }