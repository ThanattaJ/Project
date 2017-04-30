package bike;

import java.sql.*;
import java.util.Date;
public class Sharing {
    private Date[] returnTime;
    private History his = new History();
    private Timer time = new Timer(); //เวลา
    private String timeDetail = ""; //รายละเอียด
    private int[] numBikeUser; //จำนวนที่ user ยืมแต่ละอุปกรณ์
    private String[] nameItem;
    private String[] pathImgItem;
    private static int[] availableItem; //จำนวนไอเทมที่สามารถใช้ได้
    private String itemID[];
    private int itemCP[];
    private String[] itemReturnUser;
    private int[] itemAmountReturnUser;
    private int countType;
    private int countEquip;
    private CanCounter cp; //ซีพี
    
    public Sharing() { //constructors
        cp = new CanCounter();
        cp.selectCP();
    }
    
    public void setDataOfItem(){
        int temp = 0,i = 0;
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT COUNT(itemID) AS num FROM Items";
            
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                temp = rs.getInt("num");
            }
            
            numBikeUser = new int[temp];
            nameItem= new String[temp];
            availableItem = new int[temp];
            pathImgItem = new String[temp];
            itemCP = new int[temp];
            
            sql = "SELECT * FROM Items WHERE itemID LIKE 'B%'";
            rs = s.executeQuery(sql);
            while(rs.next()){
                nameItem[i] = rs.getString("itemName");
                availableItem[i] = rs.getInt("availableNumber");
                pathImgItem[i]=rs.getString("img");
                itemCP[i] = rs.getInt("CP_cost");
                i++;
            }
            countType = i;
            countEquip = temp-i;

            sql = "SELECT * FROM Items WHERE itemID LIKE 'E%'";
            rs = s.executeQuery(sql);
            while(rs.next()){
                nameItem[i] = rs.getString("itemName");
                availableItem[i] = rs.getInt("availableNumber");
                pathImgItem[i]=rs.getString("img");
                itemCP[i] = rs.getInt("CP_cost");
                i++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int[] getItemCP() {
        return itemCP;
    }

    private void borrowItem(){
        Timestamp borrowDate = new Timestamp(time.getBorrowTime().getTime());
        Timestamp returnDate = new Timestamp(time.getReturnTime().getTime());   
        String sql;
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            for (int i = 0; i < countType; i++) {
                
                sql = "UPDATE Items SET availableNumber='"+availableItem[i]+"' WHERE itemID LIKE 'B%"+(i+1)+"'";
                s.execute(sql);
                if(numBikeUser[i] != 0){
                    his.HistoryByAdmin("B0"+(i+1),borrowDate,returnDate,"Borrow",numBikeUser[i]);
                }
            }

            for (int i = 1; i <= countEquip; i++) {
                sql = "UPDATE Items SET availableNumber='"+availableItem[countType-1+i]+"' WHERE itemID LIKE 'E%"+i+"'";
                s.execute(sql);
                if(numBikeUser[countType-1+i] != 0){
                    his.HistoryByAdmin("E0"+i,borrowDate,returnDate,"Borrow",numBikeUser[countType-1+i]);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void returnItems(){
        Date nd = new Date();
        Timestamp nowDate = new Timestamp(nd.getTime());
        Timestamp returnDate = new Timestamp(time.getReturnTime().getTime());
        String sql;
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            for (int i = 0; i < countType; i++) {
                sql = "UPDATE Items SET availableNumber='"+availableItem[i]+"' WHERE itemID LIKE 'B%"+(i+1)+"'";
                s.execute(sql);
                if(numBikeUser[i] != 0){
                    his.HistoryByAdmin("B0"+(i+1),nowDate,returnDate,"Return",numBikeUser[i]);
                }
                numBikeUser[i] = 0;
            }

            for (int i = 1; i <= countEquip; i++) {
                sql = "UPDATE Items SET availableNumber='"+availableItem[countType-1+i]+"' WHERE itemID LIKE 'E%"+i+"'";
                s.execute(sql);
                if(numBikeUser[countType-1+i] != 0){
                    his.HistoryByAdmin("E0"+i,nowDate,returnDate,"Return",numBikeUser[i]);
                }
                numBikeUser[countType-1+i] = 0;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setNumBikeUser(int[] numBikeUser) {
        this.numBikeUser = numBikeUser;
    }

    public void borrowStep(){ //ระบุจำนวนยืมจักรยานแต่ละชนิด
        for (int i = 0; i < numBikeUser.length ; i++) {
                availableItem[i] -= numBikeUser[i];
        }
    }
    
    public void editStep(){
        for (int i = 0; i < numBikeUser.length; i++) {
            availableItem[i] += numBikeUser[i];
        }
    }
    
    public void returnStep(){ //ระบุจำนวนยืมจักรยานแต่ละชนิด
        for (int i = 0; i < numBikeUser.length ; i++) {
            availableItem[i] += numBikeUser[i];
        }
    }
    
    public void decreseCPNoti(){
        cp.decreseCp();
    }
    
    public void startBorrow() throws InterruptedException{ //เริ่มยืม
        cp.decreseCp();
        borrowItem();
        time.start(this);
    }

    public void stopBorrow() { //หยุดยืม(นำของมาคืน)
        time.stop();
        timeDetail = time.showDetail();
        cp.setCpUse(0);
        returnStep();
        returnItems();
    }   

    public void enterTime(int userDate, int userMonth, int userYear, int userHr, int userMin, int userSec) { //ระบุวันเวลาที่จะคืน
        time = new Timer(userDate, userMonth, userYear, userHr, userMin, userSec);
        time.differentTime();
        timeDetail = time.showDetail();
    }

    public int countHis(){
        return time.showStartAndEndTime();
    }
    
    public String[] showHis(){
        return time.getHisBorrow();
    }
    
    public String getTimeDetail() { //แสดงเวลาที่เหลือ
        timeDetail = time.showDetail();
        return timeDetail;
    }
    
    public void setPointUse(){
        cp.countCpBorrow(numBikeUser,itemCP);
    }
    
    public Timer getTime() {
        return time;
    }

    public static int[] getAvailableItem() {
        return availableItem;
    }

    public CanCounter getCp(){
        return cp;
    }
    
    public void selectAllItemID(){
        String[] allItem = null;
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();

            String sql = "SELECT COUNT(itemID) As num FROM Items";
            ResultSet rs = s.executeQuery(sql);
            rs.first();
            int count = rs.getInt("num");
            itemID = new String[count];
            sql = "SELECT * FROM Items ORDER BY itemID ASC";
            rs = s.executeQuery(sql);
            for (int i = 0; i < itemID.length; i++) {
                if(rs.next()){
                    itemID[i] = rs.getString("itemID");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String selectItemIdBike(){
        String bikeId="B0";
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT RIGHT (itemID, 2) AS count FROM Items WHERE itemID LIKE 'B%' ORDER BY itemID DESC";
            ResultSet rs = s.executeQuery(sql);
            rs.first();
            int tmp = Integer.parseInt(rs.getString("count"));
            tmp++;
            if(tmp < 10){
                bikeId = "B0"+tmp;
            }else if(tmp >= 10){
                bikeId = "B"+tmp;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return bikeId;
    }
    
    public String selectItemIdEquip(){
        String equipId="E0";
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT RIGHT (itemID, 2) AS count FROM Items WHERE itemID LIKE 'E%' ORDER BY itemID DESC";
            ResultSet rs = s.executeQuery(sql);
            rs.first();
            int tmp = Integer.parseInt(rs.getString("count"));
            tmp++;
            if(tmp < 10){
                equipId = "E0"+tmp;
            }else if(tmp >= 10){
                equipId = "E"+tmp;
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return equipId;
    }
        
    public void addItem(String id,String name,int count){
        Connection con = null;
        int available=0;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "INSERT INTO Items VALUES ('"+id+"','"+name+"','"+count+"','"+count+"')";
            s.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void editItem(String id,String name,int count){
        Connection con = null;
        int available=0;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT * FROM Items Where itemID='"+id+"'";
            ResultSet rs = s.executeQuery(sql);
            rs.first();
            available = rs.getInt("amount")-rs.getInt("availableNumber");
            sql = "UPDATE Items SET name='"+name+"',amount='"+count+"',availableNumber='"+(count-available)+"' WHERE itemID='"+id+"'";
            s.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
    public void deleteItem(String id){
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "DELETE FROM Items WHERE itemID='"+id+"'";
            s.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public String[] selectAllAdmin(){
        String[] allItem = null;
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            
            String sql = "SELECT COUNT(itemID) As num FROM Items";
            ResultSet rs = s.executeQuery(sql);
            rs.first();
            int count = rs.getInt("num");
            allItem = new String[count];
            sql = "SELECT * FROM Items ORDER BY itemID ASC";
            rs = s.executeQuery(sql);
            for (int i = 0; i < allItem.length; i++) {
                if(rs.next()){
                    allItem[i] = "Item ID : "+rs.getString("itemID")+"  Name : "+rs.getString("itemname")+"  Amount : "+rs.getInt("amount")+"  Available : "+rs.getInt("availableNumber");
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return allItem;
    }

    public String[] getItemID() {
        return itemID;
    }
    
    public String[] getNameItem() {
        return nameItem;
    }

    public String[] getPathImgItem() {
        return pathImgItem;
    }
    
    public boolean checkStatus(){
        boolean statusReturn = false;
        int mustReturn = 0;
        int countBorrow = 0;
        int countReturn = 0;
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            
            String sql = "SELECT COUNT(action) As numBorrow FROM Transaction Where userID='"+User.getUserId()+"' and action='Borrow'";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                countBorrow = rs.getInt("numBorrow");
            }
            sql = "SELECT COUNT(action) As numReturn FROM Transaction Where userID='"+User.getUserId()+"' and action='Return'";
            rs = s.executeQuery(sql);
            if(rs.next()){
                countReturn = rs.getInt("numReturn");
            }
            mustReturn = countBorrow - countReturn;
            if(mustReturn == 0){
               statusReturn = true;
            }else{
               returnTime = new Date[mustReturn];
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return statusReturn;
    }
    
    public boolean remaintoReturn(){
        Date dt= new Date();
        boolean statusTimesUp = false;

        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT return_dateTime FROM Transaction WHERE userID='"+User.getUserId()+"' and action='Borrow' ORDER BY dateTime DESC LIMIT "+ returnTime.length;
            ResultSet rs = s.executeQuery(sql);
            for (int i = returnTime.length; i > 0; i--) {
                if(rs.next()){
                    returnTime[i-1] = rs.getTimestamp("return_dateTime");
                }
            }
            String current = dt.getDate()+(dt.getMonth()+1)+(dt.getYear()+1900)+"";;
            String temp;    
            for (int i = 0; i < returnTime.length; i++) {
                temp = returnTime[i].getDate()+(returnTime[i].getMonth()+1)+(returnTime[i].getYear()+1900)+"";
                if(!current.equals(temp) || returnTime[i].getTime() <= dt.getTime()){
                    statusTimesUp = true;
                    int tmpCP = 0;
                    itemMustReturn();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return statusTimesUp;
     }
    
    public void checkTime() throws InterruptedException { //ระบุวันเวลาที่จะคืน
        Date dt = new Date();
        Date re = returnTime[0];
        System.out.println(re);
        time = new Timer(re,dt);
        time.differentTime();
        time.start(this);
        timeDetail = time.showDetail();
    }
    
    public String itemMustReturn(){
        String dateReturn = returnTime[0]+"";
        int i = 0;
        String listItem = "";
        Connection con = null;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT COUNT(DISTINCT itemID) AS count FROM Transaction WHERE userID='"+User.getUserId()+"' and return_dateTime='"+dateReturn+"' LIMIT "+returnTime.length;
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                i = rs.getInt("count");
            }
            itemReturnUser = new String[i];
            itemAmountReturnUser = new int[i];
            
            sql = "SELECT itemID,SUM(amount) AS sum FROM Transaction WHERE userID='"+User.getUserId()+"' and return_dateTime='"+dateReturn+"' GROUP BY itemID LIMIT "+returnTime.length;
            rs = s.executeQuery(sql);
            i = 0;
            while(rs.next()){
                itemReturnUser[i] = rs.getString("itemID");
                itemAmountReturnUser[i] = rs.getInt("sum");
                i++;
            }
          
            for (int j = 0; j < itemReturnUser.length; j++) {
                listItem +="- " + itemReturnUser[j] + "    Amount   : " + itemAmountReturnUser[j] + "<br>";
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return listItem;
    }
    
    public void timesupCP(){
        Connection con = null;
        Date dt = new Date();
        String sql;
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String current = dt.getDate()+(dt.getMonth()+1)+(dt.getYear()+1900)+"";;
            String temp;    
            for (int i = 0; i < returnTime.length; i++) {
                temp = returnTime[i].getDate()+(returnTime[i].getMonth()+1)+(returnTime[i].getYear()+1900)+"";
                if(!current.equals(temp) || returnTime[i].getTime() <= dt.getTime()){
                    int tmpCP = 0;
                    for (int j = 0; j < itemReturnUser.length; j++) {
                        sql = "SELECT CP_cost FROM Items WHERE itemID='"+itemReturnUser[i]+"'";
                        ResultSet rs = s.executeQuery(sql);
                        if(rs.next()){
                            tmpCP += rs.getInt("CP_cost")*itemAmountReturnUser[i];
                        }
                    }
                    cp.selectCP();
                    cp.setCpUse(tmpCP*2);
                    cp.decreseCp();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}