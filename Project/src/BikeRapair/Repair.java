package BikeRapair;


import ConnectDB.ConnectDatabase;
import Timer.Timer;
import History.History;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author January
 */
public class Repair{
    private String problem;//ปัญหาของการซ่อมจักรยาน เช่น ยางแตก ช่างกรอก Asking
    private String detail;//รายละเอียด เช่น ต้องเปลี่ยนยาง ช่างกรอก Repairing
    private Timer t;//เก็บเวลาที่จะต้องเสร็จ
    private String ans;//ตอบ
    private int hours;
    private int minute;
    private int secound;
    private String timeDetail;//เวลาที่ช่างซ่อมจะซ่อมเสร็จ
    private Notification notic = new Notification();
    private String repairOutput=""; //ข้อมูลทั้งหมด
    private String increaseDetail="";
    private History historyRp = new History();
    private String bike="";//รับจาก GUI ให้ user กรอก
    private String whyRepair="";//ให้ user กรอกว่าทำไมถึงต้องส่งซ่อม
    private String color="";
    private long peairId;
    private long countTransId;
    private Date time = new Date();
    private String showTime="";
    private long repairStateId;
    private String status="";
    private String asking="";
    private String repairing="";
    private boolean statusThread = false;
    
    public Repair() {
        
    }
    
    public void timeDiffStop(Date stopTime){
        Date current = new Date();
        t = new Timer(stopTime,current);
        t.differentTime();
        showTime = t.showDetail();
    }
    
    public ArrayList<Integer> connextDBforAdminCheakAddRepeir(){
       ArrayList<Integer> prepair = new ArrayList<Integer>();
       ArrayList<Integer> repair = new ArrayList<Integer>();       
       ArrayList<Integer> diff = new ArrayList<Integer>();       
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            Statement st = connect.createStatement(); 
            
            String temp ="SELECT id FROM  Green_Society.`Prepair_Desctiption`";
            ResultSet rs = st.executeQuery(temp);
            while(rs.next()){
                prepair.add(rs.getInt("id"));
            }
            
            String temp2 = "SELECT item_id FROM `Repair_State`";
            ResultSet rs2 = st.executeQuery(temp2);
            while(rs2.next()){
                repair.add(rs2.getInt("item_id"));
            }
            
            for (int i = 0; i < prepair.size(); i++) {
                boolean check = true;
                for (int j = 0; j < repair.size(); j++) {
                    if(prepair.get(i).equals(repair.get(j))){
                        check = false;
                        break;
                    }
                }
                if(check){
                        diff.add(prepair.get(i));
                    }
            }
            
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
        return diff;
    }
    
    public long ConnectDBReturnTransIDForUpdateTimr(long prepairID){
        long transID=0;
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("..connectDBFromAdminToUser");
            Statement st = connect.createStatement(); 
            //ดึงเอา id ที่มาที่สุดออกมา เพื่อให้มันสามารถ insert ลง table ให้ไม่ซ้ำกันได้
            String temp = "SELECT Prepair_Desctiption.transID FROM `Prepair_Desctiption` "
                    + "JOIN Repair_State ON Prepair_Desctiption.id = Repair_State.item_id "
                    + "WHERE Prepair_Desctiption.id= "+prepairID;
            ResultSet rs = st.executeQuery(temp);
            
            while(rs.next()){
                transID = rs.getInt("transID");
            }
            
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
        return transID;
    }

    
    public ArrayList<String> connectDBforListUserSentToRepair(){
        ArrayList<String> list = new ArrayList<String>();
        String format="";
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("...connectDBFomeUserToAdmin");
            Statement st = connect.createStatement(); 
            String temp = "SELECT Prepair_Desctiption.id,User.firstName,User.lastName,User.userID FROM Green_Society.Prepair_Desctiption " +
                            "JOIN Transaction ON Prepair_Desctiption.transID=Transaction.transID " +
                            "INNER JOIN User ON Transaction.userID=User.userID " +
                            "LEFT JOIN Green_Society.Repair_State ON Prepair_Desctiption.id = Repair_State.item_id " +
                            "WHERE Repair_State.item_id IS NULL";
            ResultSet rs = st.executeQuery(temp);
            while(rs.next()){
                int idPrepair = rs.getInt("id");
                String name = rs.getString("firstName");
                String surname = rs.getString("lastName");
                int id = rs.getInt("userID");
                format = idPrepair+"    |     Name: "+name+"    |   Surname: "+surname+"    |   ID: "+id;
                list.add(format);
            }
            
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
        return list;
    }
    
    public void connectDBForChangeToSuccessFromPerpair(long perpairID){
         try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("...connectDBFomeUserToAdmin");
            Statement st = connect.createStatement(); 
            String temp = "UPDATE Repair_State JOIN Prepair_Desctiption ON Repair_State.item_id = Prepair_Desctiption.id "
                    + "SET Repair_State.Recieving = 'Success' WHERE Prepair_Desctiption.id = "+perpairID;
            
            st.executeUpdate(temp);
            
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

    
    public void connectDBForChangeToSuccess(long idRepairState){
         try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("...connectDBFomeUserToAdmin");
            Statement st = connect.createStatement(); 
            String temp = "UPDATE Repair_State SET Repair_State.Recieving = 'Success' WHERE id= "+idRepairState;
            
            st.executeUpdate(temp);
            
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
    
    public ArrayList<String> connectDBForCheckRepairNotSucceess(){
        ArrayList<String> notSuccess = new ArrayList<String>();
        String name;
        String action;
        Timestamp remaining;
        String format;
        int id;
         try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("...connectDBFomeUserToAdmin");
            Statement st = connect.createStatement(); 
            String temp = "SELECT Repair_State.id,User.firstName,Repair_State.Repairing,Transaction.dateTime FROM Green_Society.User " +
                            "JOIN Repair_State ON User.userID = Repair_State.userID " +
                            "INNER JOIN Prepair_Desctiption ON Repair_State.item_id=Prepair_Desctiption.id " +
                            "INNER JOIN Transaction ON Prepair_Desctiption.transID=Transaction.transID " +
                            "WHERE Repair_State.Recieving = 'Not Success!'";
            ResultSet rs = st.executeQuery(temp);
            while(rs.next()){
                id = rs.getInt("id");
                name=rs.getString("firstName");
                action=rs.getString("Repairing");
                remaining=rs.getTimestamp("dateTime");
                format=id+"   |   "+name+"   |   "+action+"       "+remaining;
                notSuccess.add(format);
            }
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
         return notSuccess;
    }

    
    public long connectDBFomeUserToAdmin(long userID,Timestamp startDate,Timestamp returnDate){
//        Timestamp startDate = new Timestamp(t.getBorrowTime().getTime());
//        Timestamp returnDate = new Timestamp(t.getReturnTime().getTime());
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("...connectDBFomeUserToAdmin");
            Statement st = connect.createStatement(); 
            //ดึงเอา id ที่มาที่สุดออกมา เพื่อให้มันสามารถ insert ลง table ให้ไม่ซ้ำกันได้
            String temp = "SELECT MAX(id) AS countId FROM Prepair_Desctiption ";
            ResultSet rs = st.executeQuery(temp);
            int count=0;
            while(rs.next()){
                count = rs.getInt("countId");
            }
            peairId = ++count;
            //------------------------------------------------------------------
            //ดึง transId ว่ามีมากที่สุดเท่าไร เพื่อให้มัน กรอกลง DB ได้ และไม่ซ้ำกับ transID
            String temp1 = "SELECT MAX(transId) AS countTransId FROM Transaction ";
            ResultSet rs1 = st.executeQuery(temp1);
            int countTrans=0;
            while(rs1.next()){
                countTrans = rs1.getInt("countTransId");
            }
            countTransId = ++countTrans;
            //------------------------------------------------------------------
            //เอาข้อมูลลง DB prapair_Desctiption
            String sqlid = "\'"+this.peairId+"\'";
            String brand = "\'"+bike+"\'";
            String sqlcolor = "\'"+color+"\'";
            String sqlWhy = "\'"+whyRepair+"\'";
            String sqlTransId = "\'"+countTransId+"\'";
            
            String temp2 ="INSERT INTO `Prepair_Desctiption` (`id`, `brand`, `color`, `other`, `transID`) "
                    + "VALUES"+" ("+sqlid+","
                    + brand +","
                    + sqlcolor + ","
                    + sqlWhy + ","
                    + sqlTransId +")";
            
            st.executeUpdate(temp2);
            //---------------------------------------------------------------------------------------
            //เอาข้อมูลลง transaction ด้วย 
            String userId = "\'"+userID+"\'";
            String action = "\'Repair\'";
            String officerId = "\'"+200+"\'";
            System.out.println("..insert into To Prepair_Desctiption calling by connectDBFomeUserToAdmin");
            
            String temp3 ="INSERT INTO Transaction VALUES " //set ค่าให้กับ Database
                    + "("+this.countTransId+","
                    +"'"+startDate+"','"
                     +returnDate+"',"
                      +0+ ","
                      +userId+","
                      +action+"," 
                      +officerId+")";
             
            st.executeUpdate(temp3);
            System.out.println(".insert into To Transaction calling by connectDBFomeUserToAdmin");
            //------------------------------------------------------------------
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
        return peairId;
    }

    public long getCountTransId() {
        return countTransId;
    }
    
     public void connectDBFromAdminToUser(long itemId,int user){//เพื่อที่ User จะสามารถติดตามดารซ่อมของตัวเองได้ ใส่ itemId
         System.out.println("itemId: "+itemId);
         try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("..connectDBFromAdminToUser");
            Statement st = connect.createStatement(); 
            //ดึงเอา id ที่มาที่สุดออกมา เพื่อให้มันสามารถ insert ลง table ให้ไม่ซ้ำกันได้
            String temp = "SELECT MAX(id) AS countId FROM Repair_State ";
            ResultSet rs = st.executeQuery(temp);
            int count=0;
            while(rs.next()){
                count = rs.getInt("countId");
            }
             System.out.println("coundId: "+count);
            repairStateId = ++count;
            //------------------------------------------------------------------
            //เอาข้อมูลลง DB Repair_State
            String sqlid = "\'"+repairStateId+"\'";
            String sqlAsking = "\'"+problem+"\'";
            String sulRepairing = "\'"+detail+"\'";
            String sqlRecieving = "\'"+Status(false)+"\'";
            String sqlItemId = "\'"+itemId+"\'";
            
            String temp2 ="INSERT INTO Repair_State "
                    + "VALUES"+" ("+sqlid+","
                    + sqlAsking +","
                    + sulRepairing + ","
                    + sqlRecieving + ","
                    + sqlItemId + ","
                    + user+")";
            
            st.executeUpdate(temp2);
            System.out.println(".insert to Repair_State calling By connectDBFromAdminToUser");
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
     
    public void connectDBShowRepairForUserFollowing(long itemId){//เพื่อที่ User จะสามารถดูและติดตามดารซ่อมของตัวเองได้
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            
            Statement st = connect.createStatement(); 
            //ดึงเอา id ที่มาที่สุดออกมา เพื่อให้มันสามารถ insert ลง table ให้ไม่ซ้ำกันได้
            String temp = "SELECT Asking,Repairing,Recieving FROM Repair_State where item_id= "+itemId;
            ResultSet rs = st.executeQuery(temp);
           
            while(rs.next()){
                asking = rs.getString("Asking");
                repairing = rs.getString("Repairing");
                status = rs.getString("Recieving");
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
    
   public void connectDBForAdminUpdateTime(long transId,Timestamp startTime,Timestamp endTime){
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            
            Statement st = connect.createStatement(); 
            
            String temp = "update `Transaction` set return_dateTime = '"+endTime
                    + "' ,dateTime = '" + startTime
                    + "' WHERE transID ="+transId;
            st.executeUpdate(temp);
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

    public void sentDatabaseHistory(){//เอาค่าจาก gui ลง db เพื่อให้ admin สามารถดึงข้อมูลไปแสดงได้
        Timestamp dateRepair = new Timestamp(t.getBorrowTime().getTime());//เวลาที่เริ่มต้นให้ช่างซ่อม
        Timestamp dateSuccess = new Timestamp(t.getReturnTime().getTime());//เวลาที่ช่างจะซ่อมเสร็จ
        historyRp.HistoryByAdmin("000", dateRepair,dateSuccess, "Repair");
    }

    public String submitRepair(){
        repairOutput+="Problem: "+getProblem()+"\n"+"Detail: "+getDetail();
        repairOutput += "\n"+increaseDetail;
        repairOutput +=showTime;
        return repairOutput;
    }
    
//    public String increaseTimeRepair(int hr,int min,int sec) throws InterruptedException{//เมธอดเพิ่มเวลาเมื่อช่างซ่อมซ่อมไม่เสร็จ
//        String oldTime = timeDetail;
//        plusDay(hr,min,sec);
//        String newTime="";
//        String increaseTime = "Increase Time : "+hr+":"+min+":"+sec; //เวลาที่ช่างซ่อมต้องการเพิ่ม
//        String output = notic.notiRepairIncreseTime(oldTime, increaseTime, newTime); //เรียก Notic
//        timeDetail= newTime;
//        return output;
//    }
    
    public String increaseTimeRepair(String newProblem,String newDetail,int hr,int min,int sec) throws InterruptedException{
//เมธอดเพิ่มปัญหาที่ช่างซ่อมพบเจอใหม่ พร้อมกับประเมินเวลาที่จะซ่อมเสร็จด้วย
        String oldTime = timeDetail;
//        plusDay(hr,min,sec);
        String newTime=t.showDetail();
//        ---------------------------------------------------------------------
        String increaseTime = "Increase Time : "+hr+":"+min+":"+sec;
        String detail = "RepairProblem: "+newProblem+"\n"
                +"RepairDetail: "+newDetail+"\n"
                +increaseTime; 
        String output = notic.notiRepairIncreseTime(oldTime,detail, newTime);
//        -------------------------------------------------------------------
        timeDetail= newTime;
        showTime="Start: "+t.getBorrowTime()+"\nStop: "+t.getReturnTime()+"\n"+timeDetail;
        increaseDetail = "Problem: "+newProblem+"\n"
                +"Detail: "+newDetail+"\n";
        setShowTime(showTime);
        return showTime;
    }
    
    
    public Timer time() throws InterruptedException{//set ค่า time ก่อน
        Calendar time = Calendar.getInstance();
        int realHour = time.get(Calendar.HOUR_OF_DAY)+hours;//เวลาเป็นชั่วโมงจริงของวันนี้บวกกับชั่วโมงที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        int realMinute=time.get(Calendar.MINUTE)+minute; // เวลาเป็นนาทีของวันนี้บวกกับนาทีที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        int realSecound=time.get(Calendar.SECOND)+secound;// เวลาเป็นวินาทีของวันนี้บวกกับวินาทีที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        t = new Timer(time.get(Calendar.DATE),time.get(Calendar.MONTH)+1,time.get(Calendar.YEAR), 
                realHour,realMinute,realSecound); //ส่งค่าผ่าน Constructor ไปให้ Class Timer กำหนดวัน เดือน ปี เป็นของวันที่ปัจจุบัน
        t.differentTime();
        timeDetail=t.showDetail();
        showTime="Start: "+t.getBorrowTime()+"\nStop: "+t.getReturnTime()+"\n"+timeDetail;
        return t;
    }
    
     public void startTime() throws InterruptedException{
        t.start(this);
//        Date userDate = endTimeToRepair();
//        Date current = new Date();
//        t = new Timer(userDate,current);
//        t.differentTime();
//        t = getTime();
//        
    }
    
    public void stopTime(){
        t.stop();
//        timeDetail = t.showDetail();
        statusThread = true;
    }

    
    public Date startTimeToRepair(){
        Date startDate = t.getBorrowTime();
        return startDate;
    }
    
    public Date endTimeToRepair(){
        Date endDate = t.getReturnTime();
        return endDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    
   
    public void setStatusThread(boolean statusThread) {
        this.statusThread = statusThread;
    }

    public boolean isStatusThread() {
        return statusThread;
    }
    
    public void plusDay(int h,int m,int s){ //เมธอดคำนวณชั่วโมง นาที วินาที ไม่ให้มันเกินตามความเป็นจริง
        System.out.println("plusDay...");
//        System.out.println("returnTime: "+returnTime);
        hours+=h;
        minute+=m;
        secound+=s;
        
//        t.increaseTime(returnTime,h, m, s);
    }
    
    public String Status(boolean tem){ // รับมาจากปุ่มกด ถ้าเสร็จเป็น true ไม่เสร็จเป็น false
        if(tem==false){
            status="Not success!";
        }else if(tem==true){
            status="Success!";
        }
        return status;  
    }
    
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecound() {
        return secound;
    }

    public void setSecound(int secound) {
        this.secound = secound;
    }

    public String getBike() {
        return bike;
    }

    public void setBike(String bike) {
        this.bike = bike;
    }
    
    public Timer getTime() {
        return t;
    }

    public void setRepairOutput(String repairOutput) {
        this.repairOutput = repairOutput;
    }
   
    public String getRepairOutput() {
        return repairOutput;
    }

    public String getStatus() {
        return status;
    }
    
    public Repair(String problem, String detail) {
        this.problem = problem;
        this.detail = detail;
    }

    public String getWhyRepair() {
        return whyRepair;
    }

    public void setWhyRepair(String whyRepair) {
        this.whyRepair = whyRepair;
    }

    public String getAsking() {
        return asking;
    }

    public String getRepairing() {
        return repairing;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTimeDetail() {
        return timeDetail;
    }
    
    public long getRepairStateId() {
        return repairStateId;
    }
    
    @Override
    public String toString() {
        return "Problem: " + problem 
                + "\nDetail: " + detail+"\n";
    }
    
    
}
