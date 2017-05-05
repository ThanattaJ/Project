package bike;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
public class Sharing {
    private Date[] returnTime;
    public boolean timesUp = false;
    private History his = new History();
    private Timer time = new Timer(); //เวลา
    private String timeDetail = ""; //รายละเอียด
    private int[] numBikeUser; //จำนวนที่ user ยืมแต่ละอุปกรณ์
    private String[] nameItem;
    private String[] pathImgItem;
    private static int[] availableItem; //จำนวนไอเทมที่สามารถใช้ได้
    private String itemID[];
    private int itemCP[];
    private ArrayList<String> itemReturnUser;
    private ArrayList<Integer> itemAmountReturnUser;
    private int countType;
    private int countEquip;
    private ArrayList<Integer> idUserBorrowing = new ArrayList<Integer>();
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
        
    public void addItem(String id,String name,int count,String path){
        Connection con = null;
        String newPath;
        int available=0;
        String typeFile = path.substring(path.indexOf("."),path.length()-1);
        newPath = "/bike_gui/itemPic/"+name+typeFile;
        copyFileImg(path,newPath);

        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "INSERT INTO Items VALUES ('"+id+"','"+name+"','"+count+"','"+count+"','"+newPath+",)";
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
            
            String sql = "SELECT SUM(amount) As numBorrow FROM Transaction Where userID='"+User.getUserId()+"' and action='Borrow'";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                countBorrow = rs.getInt("numBorrow");
            }
            sql = "SELECT SUM(amount) As numReturn FROM Transaction Where userID='"+User.getUserId()+"' and action='Return'";
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
//                    itemMustReturn();
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
    
    public void timeAdmin(Date current) throws InterruptedException { //ระบุวันเวลาที่จะคืน
        Date dt = current;
        Date re = new Date(dt.getYear(),dt.getMonth(),dt.getDate(), 18, 0, 0);
        time = new Timer(re,dt);
        time.differentTime();
        time.start(this);
        timeDetail = time.showDetail();
    }
    
//    public String itemMustReturn(){
//        String dateReturn = returnTime[0]+"";
//        int i = 0;
//        String listItem = "";
//        Connection con = null;
//        try{
//            con = Database.connectDb("ja","jaja036");
//            Statement s = con.createStatement();
//            String sql = "SELECT COUNT(DISTINCT itemID) AS count FROM Transaction WHERE userID='"+User.getUserId()+"' and return_dateTime='"+dateReturn+"' LIMIT "+returnTime.length;
//            ResultSet rs = s.executeQuery(sql);
//            while(rs.next()){
//                i = rs.getInt("count");
//            }
//            itemReturnUser = new String[i];
//            itemAmountReturnUser = new int[i];
//            
//            sql = "SELECT itemID,SUM(amount) AS sum FROM Transaction WHERE userID='"+User.getUserId()+"' and return_dateTime='"+dateReturn+"' GROUP BY itemID LIMIT "+returnTime.length;
//            rs = s.executeQuery(sql);
//            i = 0;
//            while(rs.next()){
//                itemReturnUser[i] = rs.getString("itemID");
//                itemAmountReturnUser[i] = rs.getInt("sum");
//                i++;
//            }
//          
//            for (int j = 0; j < itemReturnUser.length; j++) {
//                listItem +="- " + itemReturnUser[j] + "    Amount   : " + itemAmountReturnUser[j] + "<br>";
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            con.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return listItem;
//    }
    
//    public void timesupCP(){
//        Connection con = null;
//        Date dt = new Date();
//        String sql;
//        try{
//            con = Database.connectDb("ja","jaja036");
//            Statement s = con.createStatement();
//            String current = dt.getDate()+(dt.getMonth()+1)+(dt.getYear()+1900)+"";;
//            String temp;    
//            for (int i = 0; i < returnTime.length; i++) {
//                temp = returnTime[i].getDate()+(returnTime[i].getMonth()+1)+(returnTime[i].getYear()+1900)+"";
//                if(!current.equals(temp) || returnTime[i].getTime() <= dt.getTime()){
//                    int tmpCP = 0;
//                    for (int j = 0; j < itemReturnUser.length; j++) {
//                        sql = "SELECT CP_cost FROM Items WHERE itemID='"+itemReturnUser[i]+"'";
//                        ResultSet rs = s.executeQuery(sql);
//                        if(rs.next()){
//                            tmpCP += rs.getInt("CP_cost")*itemAmountReturnUser[i];
//                        }
//                    }
//                    cp.selectCP();
//                    cp.setCpUse(tmpCP*2);
//                    cp.decreseCp();
//                }
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            con.close();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
    
    public void copyFileImg(String sourceFile,String targetFile){
        try{
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile);
            
            byte[] data = new byte[1024];
            int numFile;
            while((numFile=fis.read(data))!=-1){
                fos.write(data, 0, numFile);
            }
            fis.close();
            fos.close();
        }
        catch(FileNotFoundException fnfe){
            System.out.println(fnfe);
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
    }
    
    public ArrayList<String> adminCheckUserBorrow(){
        Connection con = null;
        ArrayList<Integer> tempClear = new ArrayList<Integer>();
        idUserBorrowing = tempClear;
        ArrayList<Integer> tempId = new ArrayList<Integer>();;
        ArrayList<String> tempUser = new ArrayList<String>();
        ArrayList<String> allUser = new ArrayList<String>();
        ArrayList<Integer> allBorrowUser = new ArrayList<Integer>();
        ArrayList<Integer> allReturnUser = new ArrayList<Integer>();
        try{
            
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT userID,firstName FROM User";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                tempId.add(rs.getInt("userID"));
                tempUser.add("       "+"ID "+rs.getInt("userID")+"      "+rs.getString("firstName"));
            }
            
            if(tempId.size()!=0){
                sql = "SELECT SUM(amount) AS amounBorrow FROM Transaction WHERE userID=? and action=?";
                PreparedStatement pst = con.prepareStatement(sql);
                for (int i = 0; i < tempUser.size(); i++) {
                    pst.setInt(1, tempId.get(i));
                    pst.setString(2, "Borrow");
                    rs = pst.executeQuery();
                    while(rs.next()){
                        allBorrowUser.add(rs.getInt("amounBorrow"));
                        System.out.println(rs.getInt("amounBorrow"));
                    }
                }

                sql = "SELECT SUM(amount) AS amountReturn FROM Transaction WHERE userID=? and action=?";
                pst = con.prepareStatement(sql);
                for (int i = 0; i < tempUser.size(); i++) {
                    pst.setInt(1, tempId.get(i));
                    pst.setString(2, "Return");
                    rs = pst.executeQuery();
                    while(rs.next()){
                        allReturnUser.add(rs.getInt("amountReturn"));
                        System.out.println(rs.getInt("amountReturn"));
                    }
                }

                for (int i = 0; i < tempUser.size(); i++) {
                    int temp = allBorrowUser.get(i)-allReturnUser.get(i);
                    if(temp != 0){
                        idUserBorrowing.add(i+1);
                        allUser.add(tempUser.get(i));
                    }
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
        return allUser;
    }

    public ArrayList<Integer> getIdUserBorrowing() {
        return idUserBorrowing;
    }
    public String nameOfuser(int id){
        Connection con = null;
        String name = "";
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT firstName FROM Users WHERE userID='"+id+"'";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                name = rs.getString("firstName");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return name;
    }
    
    public boolean checkUserBorrowNow(int id){
        boolean timeup = false;
        int mustReturn = 0;
        int countBorrow = 0;
        int countReturn = 0;
        Connection con = null;
        Date dt = new Date();
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            
            String sql = "SELECT return_dateTime FROM Transaction Where userID='"+id+"' and action='Borrow' ORDER BY transID DESC LIMIT 1";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                Date reUser = rs.getTimestamp("return_dateTime");
                if(dt.getDate()!=reUser.getDate() || dt.getMonth()!=reUser.getMonth() || dt.getYear()!=reUser.getYear()){
                    timeup = true;
                }else if (reUser.getHours() >= 18 && reUser.getHours() >= 0 && reUser.getHours() >= 0  ){
                    timeup = true;
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
        return timeup;
    }

    public boolean isTimesUp() {
        return timesUp;
    }
    
    public void itemUserBorrow(int id){
        Date dt = new Date();
        Connection con = null;
        Timestamp t = null;
        ArrayList<String> tempNameItem = new ArrayList<String>();
        ArrayList<Integer> tempAmountItem = new ArrayList<Integer>();
        itemReturnUser.clear();
        itemAmountReturnUser.clear();
        
        try{
            con = Database.connectDb("ja","jaja036");
            Statement s = con.createStatement();
            String sql = "SELECT itemName FROM Items ORDER BY itemID ASC";
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()){
                tempNameItem.add(rs.getString("itemName"));
            }
            sql = "SELECT return_dateTime FROM Transaction Where userID='"+id+"' and action='Borrow' ORDER BY transID DESC LIMIT 1";
            rs = s.executeQuery(sql);
            if(rs.next()){
                t = rs.getTimestamp("return_dateTime");
                if(dt.getDate()!=t.getDate() || dt.getMonth()!=t.getMonth() || dt.getYear()!=t.getYear()){
                    timesUp = true;
                }else if (t.getHours() >= 18 && t.getHours() >= 0 && t.getHours() >= 0  ){
                    timesUp = true;
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