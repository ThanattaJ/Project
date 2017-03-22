/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package History;

import ConnectDB.ConnectDatabase;
import Timer.Timer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author January
 */
public class History {
    private static long seqNo = 00000;
    private long historyId;
    private Timer time = new Timer();
    
    
    public void HistoryByAdmin(String input){ //รับจาก ตัวแปรที่ต้องการส่งลง DB เป็น String
        this.historyId = ++seqNo;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter itemId: ");
        String itemIdInt = sc.next();
        System.out.print("Enter userID: ");
        int userIdInt = sc.nextInt();
        System.out.print("Enter OfficerId: ");
        int officerIdInt = sc.nextInt();
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database connecting");
            
            String transId = "\'"+this.historyId+"\'";
            String itemId = "\'"+itemIdInt+"\'";
            String userId = "\'"+userIdInt+"\'";
            String action = "\'"+input+"\'";
            String officerId = "\'"+officerIdInt+"\'";
        
            Statement st = connect.createStatement(); 
            String temp ="INSERT INTO GreenSociety.`Transaction` (`transID`,`itemID`, `userID`, `action`, `officerID`) \n" +
                         "VALUES "
                    + "("+transId+","
                    +itemId + ","
                    +userId+","
                    +action+"," 
                    +officerId+")";

            st.executeUpdate(temp);
            
            String temp2 = "SELECT * FROM GreenSociety.`Transaction` LIMIT 100;";
            ResultSet rs = st.executeQuery(temp2);
            
            while(rs.next()){
                System.out.println("transID: " + rs.getInt("transID"));
                System.out.println("dateTime: " + rs.getTimestamp("dateTime"));
                System.out.println("itemID: " + rs.getString("itemID"));
                System.out.println("userID: " + rs.getInt("userID"));
                System.out.println("action: "+ rs.getString("action"));
                System.out.println("officerID: "+ rs.getInt("officerID"));
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
        
    }

    public String historyRepair(String repair){
        return repair;
    }
    
    public String toString(){
        String output = "";
        output+="historyId: "+historyId;
        return output;
    }
}
