/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BikeRapair;

import ConnectDB.ConnectDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author January
 */
public class BikeRepairAdminNotSuccess {
    private String asking;
    private String repairing;
    private String status;
    private int itemID;
    private Timestamp startTime;
    private Timestamp endTime;

    public String getAsking() {
        return asking;
    }

    public String getRepairing() {
        return repairing;
    }

    public String getStatus() {
        return status;
    }

    public int getItemID() {
        return itemID;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }
    
    public void repairDetailForNotSuccess(int repairState){
    try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");

            Statement st = connect.createStatement(); 
            //ดึงเอา สิ่งที่ช่างจะซ่อมออกมา
            String aboutRepair = "SELECT Asking,Repairing,Recieving,item_id FROM Repair_State where id= "+repairState;
            ResultSet rs = st.executeQuery(aboutRepair);
            
            while(rs.next()){
                asking = rs.getString("Asking");
                repairing = rs.getString("Repairing");
                status = rs.getString("Recieving");
                itemID= rs.getInt("item_id");
            }
            //ดึงเอาเวลาที่ช่างเริ่มซ่อม กับซ่อมเสร็จออกมา
            String timeForRepair = "SELECT dateTime,return_dateTime FROM Green_Society.Transaction JOIN Prepair_Desctiption "
                    + "ON Transaction.transID = Prepair_Desctiption.transID WHERE Prepair_Desctiption.id = "+itemID;
             ResultSet rs2 = st.executeQuery(timeForRepair);
            while(rs2.next()){
                startTime = rs2.getTimestamp("dateTime");
                endTime = rs2.getTimestamp("return_dateTime");
            }
            //---------------------------------------------------------------------------------------
            if(connect != null){
                    connect.close();
		}
		}catch (SQLException e){
                    e.printStackTrace();
        }
        
        catch(ClassNotFoundException cfe){
            System.out.println(cfe);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
