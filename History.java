package History;

import ConnectDB.ConnectDatabase;
import java.sql.*;
import java.util.Scanner;
public class History {
    private long historyId;
    
    public void HistoryByAdmin(String itemId,Timestamp date,String input){ //รับจาก ตัวแปรที่ต้องการส่งลง DB เป็น String
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter userID: ");
        int userIdInt = sc.nextInt();
        System.out.print("Enter OfficerId: ");
        int officerIdInt = sc.nextInt();
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            
            Statement st = connect.createStatement(); 
            
            String temp3 = "SELECT * FROM GreenSociety.`Transaction` ";
            ResultSet rs1 = st.executeQuery(temp3);
            
            int i=0;
            while(rs1.next()){
                i = rs1.getRow(); //ดึงแถวก่อนหน้ามาก่อนมา ว่าเป็นแถวที่เท่าไร
            }
            this.historyId=++i; //แล้วให้ historyId บวกเพิ่มทีละหนึ่ง
            
            String transId = "\'"+this.historyId+"\'";
            itemId = "\'"+itemId+"\'";
            String userId = "\'"+userIdInt+"\'";
            String action = "\'"+input+"\'";
            String officerId = "\'"+officerIdInt+"\'";
        
            
            String temp ="INSERT INTO GreenSociety.`Transaction`\n" +
                         "VALUES " //set ค่าให้กับ Database
                    + "("+transId+","
                    +"'"+date+"',"
                    +itemId + ","
                    +userId+","
                    +action+"," 
                    +officerId+")";

            st.executeUpdate(temp);
                   
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
    
    public String showActionUser(long id){ //user ใส่ไอดีตัวเองที่ต้องการรู้ประวัติการใช้งานของตัวเอง
        String output="";
        int statUser=0;
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            
            Statement st = connect.createStatement();
            String temp4 = "select * from `Transaction` where UserId LIKE "+id;
            ResultSet rs4 = st.executeQuery(temp4);
            while(rs4.next()){
                output+=("UserId: "+id+"\n");
                output+=("dateTime: " + rs4.getTimestamp("dateTime")+"\n");
                output+=("itemID: " + rs4.getString("itemID")+"\n");
                output+=("action: "+ rs4.getString("action")+"\n");
                statUser++;
                output+=("----------------------------------------------\n");
            }
            output+=("userID: "+id+"\n"+"The stat of user: "+statUser+"\n");
            
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
        return output;
    }
    
    public String statGreensociety(){
        String output="";
        int statRepair=0;
        int statBorrow=0;
        int statReturn=0;
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
        
            Statement st = connect.createStatement();
            
            String temp5 = "select * from `Transaction` where action='repair'";
            ResultSet rs5 = st.executeQuery(temp5);
            output+=("-------------------STAT-GREEN-SOCIETY---------------------\n");
            while(rs5.next()){
                statRepair++;
            }
            output+=("The stat of repir: "+statRepair+"\n");
            output+=("-----------------------------------------------\n");
            
            String temp6 = "select * from `Transaction` where action='barrow'";
            ResultSet rs6 = st.executeQuery(temp6);
            while(rs6.next()){
                statBorrow++;
            }
            output+=("The stat of borrow: "+statBorrow+"\n");
            output+=("-----------------------------------------------\n");
            
            String temp7 = "select * from `Transaction` where action='barrow'";
            ResultSet rs7 = st.executeQuery(temp6);
            while(rs7.next()){
                statReturn++;
            }
            output+=("The stat of return: "+statReturn+"\n");
            output+=("-----------------------------------------------");
            
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
        return output;
    }

    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }

    
    public String toString(){
        String output = "";
        output+="historyId: "+historyId;
        return output;
    }
    
    
}
