package bike.timer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import java.sql.*;

public class Timer extends JFrame{
    private String total;
    private String timeLeft;
    private int totalSeconds;   //ผลต่างเวลาทั้งหมด
    private int totalMin;       //      ''
    private int totalHour;      //      ''
    private Date nowTime = new Date();
    private Date user = new Date();
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String returnDate;
    private String borrowDate;
    private Notification nf = new Notification();
    
    //Attribute for GUI Timer
    private String startBorrow;
    private String stopBorrow;
    
    public void showStartAndEndTime(){
        Date date= new Date();
//        System.out.println(new Timestamp(date.getTime()));
        try{
            Database cndb = new Database();
            Connection connect = Database.connectDb("win", "win016");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database connecting");
        
            Statement st = connect.createStatement(); 
            String sql = "SELECT dateTime,return_dateTime,MAX(transID) FROM `Transaction` WHERE userID=111";
            ResultSet rs = st.executeQuery(sql);
//            new Timestamp(date.getTime())
            while(rs.next()){
                startBorrow = rs.getTimestamp("dateTime")+"";
                stopBorrow = rs.getTimestamp("return_DateTime")+"";
                
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
    
    public String getshowStartAndEndTime(){
        return "Start: "+startBorrow+"    "+"End: "+stopBorrow;
    }
    
    public Timer(){
        borrowDate = df.format(nowTime);
    }

    public Timer(int userDate, int userMonth, int userYear,int userHr, int userMin, int userSec) {
        borrowDate = df.format(nowTime);
        
        user.setDate(userDate);
        user.setHours(userHr);
        user.setMinutes(userMin);
        user.setSeconds(userSec);
        user.setMonth(userMonth-1);
        user.setYear(userYear-1900);
        returnDate = df.format(user);
        
    }

    public String getBorrowDate() {
        return borrowDate;
    }
    
    public int getTotalSeconds() {
        return totalSeconds;
    }
    
    public int getTotalMin() {
        return totalMin;
    }

    public int getTotalHour() {
        return totalHour;
    }
    
    //โชว์วันเวลา
    public String showDetail(){ //โชว์เวลาทั้งยืมและคืน
        return "Now Date : "+borrowDate+"\n"+
               "Return Date : "+returnDate+"\n"+timeLeft; 
    }
    //ลบเวลา
    public void differentTime(){
        long diffDate;            //เรียกดูวัน
        int diffMonth = 0;          //เรียกดูเดือน
        int diffYear = 0;           //เรียกดูปี
        long diffHour,diffMin,diffSec;
        int keepMonth = nowTime.getMonth()+1; //เก็บเดือน +1 เพราะเก็บ 0-11
        int keepYear = user.getYear();        //เก็บปี
        long diffTotal;             //ผลเวลาต่างทั้งหมด
        diffTotal = user.getTime() - nowTime.getTime();     
        diffSec = diffTotal / 1000 % 60;    //หาผลต่างของวินาที
        diffMin = diffTotal / (60 * 1000) % 60;     //หาผลต่างของนาที
        diffHour = (diffTotal / (60 * 60 * 1000) % 24); //หาผลต่างของชั่วโมง
        diffDate = (diffTotal / (60 * 60 * 1000 * 24)); //หาผลต่างของวัน
        totalMin = (int)diffMin;
        totalSeconds = (int)diffSec;
        do{
            if(keepMonth > 12){
                keepMonth = 1;
            }
            if(keepMonth == 1 || keepMonth == 3 || keepMonth == 5 || keepMonth == 7 ||
                    keepMonth == 8 || keepMonth == 10 || keepMonth == 12){ //เดือนที่ลงท้ายด้วยคม = 31 วัน
                if(diffDate >= 31){     //ถ้าจำนวนวัน >= 31 วัน
                    diffMonth++;        //ไปเดือนถัดไป
                    diffDate -= 31;     //เริ่มนับวันที่ 1 ใหม่
                    keepMonth++;        //เก็บเดือนที่แล้ว
                }else{
                    break;
                }
            }else if(keepMonth == 2){            //เดือนกุมภาพันธ์
                if((keepYear % 4 == 0) && (keepYear % 100 != 0)){   //ปีอธิทสุรทิน(เดือนกุมภา = 29 วัน)
                    if(diffDate >= 29){         //ถ้ามี 29 วัน
                        diffMonth++;            //ไปเดือนถัดไป
                        diffMonth -= 29;        //เริ่มวันที่ 1 ใหม่
                        keepMonth++;            //เก็บเดือนที่แล้ว
                    }else{
                        keepMonth=0;
                        break;
                    }
                }else{
                    if(diffDate >= 28){         //ถ้ามี 28 วัน
                        diffMonth++;            //ไปเดือนถัดไป
                        diffDate -= 28;         //เริ่มวันที่ 1 ใหม่
                        keepMonth++;            //เก็บเดือนที่แล้ว
                    }else{
                        break;
                    }
                }
            }else if(keepMonth == 4 || keepMonth == 6 || keepMonth == 9 || keepMonth == 11){ //ถ้าเดือนที่มี 30 วัน(ลงท้ายด้วย ยน)
                if(diffDate >= 30){     //ถ้ามี 30 วัน
                    diffMonth++;        //ไปเดือนถัดไป
                    diffDate -= 30;     //เริ่มวันที่ 1 ใหม่
                    keepMonth++;        //เก็บเดือนที่แล้ว
                }else{
                    break;
                }
            }
        }while(diffDate > 0);
        while(diffMonth >= 12){         //ถ้ามีจำนวนเดือน >= 12 เดือน
            diffYear++;                 //เพิ่มปี
            diffMonth -= 12;            //เริ่มนับเดือน 1 ใหม่
        }
        
        totalTime(diffDate,diffMonth,diffYear,diffHour,diffMin,diffSec);
    }
    
    public void totalTime(long diffDate,int diffMonth,int diffYear,long diffHour,long diffMin,long diffSec){
        int temp = 0;
        if(diffYear != 0){         //ถ้าผลต่างของปีไม่เท่ากับ 0    
            if((diffYear % 4 == 0) && (diffYear % 100 != 0)){      //ถ้าผลต่างปี %4 ==0 และ %100 != 0 (ปีที่มี 366 วัน)           
                temp += (diffYear*366)*24;             
            }else{                                                 //ปีที่มี 365 วัน
                temp += (diffYear*365)*24;             
            }         
	}
        if(diffMonth != 0){       //ถ้าผลต่างของเดือน != 0
            int keepMonth = nowTime.getMonth()+1;
            int keepYear = user.getYear();
            for (int i = 0; i < diffMonth; i++) {
               if(keepMonth == 1 || keepMonth == 3 || keepMonth == 5 || keepMonth == 7 ||
                    keepMonth == 8 || keepMonth == 10 || keepMonth == 12){  //เดือนที่มี 31 วัน
                    temp += 31*24;
                    keepMonth++;
                }else if(keepMonth == 2){       //เดือนกุมภา
                    if((keepYear % 4 == 0) && keepYear % 100 != 0){     //ปีที่เดือนกุมภามี 29 วัน
                        temp += 29*24;
                        keepMonth++;
                    }else{                  //ปีที่เดือนกุมภามี 28 วัน
                            temp += 28*24;
                            keepMonth++;
                    }
          
                }else if(keepMonth == 4 || keepMonth == 6 || keepMonth == 9 || keepMonth == 11){    //เดือนที่มี 30 วัน
                    temp += 30*24;
                    keepMonth++;
                }
            }
        }
        if(diffDate != 0){  //ถ้าผลต่างของวันไม่เท่ากับ 0
            temp += diffDate*24;
        }
        totalHour += temp+diffHour;
        timeLeft = "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;
    }
	
    public void increaseTime(int hr,int min,int sec){
        Date temp = new Date(user.getYear(), user.getMonth(),user.getDate(),user.getHours()
                +hr,user.getMinutes()+min,user.getSeconds()+sec);
        returnDate = df.format(temp);
     
        totalHour = totalHour+hr;   //เอาชั่วโมงที่ต้องการเพิ่ม + ชั่วโมงทั้งหมด
        
        totalMin = totalMin+min;   //เอานาทีที่ต้องการเพิ่ม + นาทีทั้งหมด
        
        totalSeconds = totalSeconds+sec;    //เอาวินาทีที่ต้องการเพิ่ม + วินาทีทั้งหมด
        while(totalSeconds >= 60){  //เข้าลูปต่อเมือวินาที >= 60
            totalMin += 1;          //+ นาทีเพิ่ม 1
            totalSeconds -= 60;     //เริ่มนับวินาทีใหม่
        } 
        
        while(totalMin >= 60){      //เข้าลูปต่อเมื่อนาที >= 60
            totalHour += 1;         //+ ชั่วโมงเพิ่ม 1
            totalMin -= 60;         //เริ่มนับนาทีใหม่
        }
        timeLeft = "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;  //เวลาเหลือ
          
    }
    
    public void stop(){     //หยุดเวลา
        //วันที่ยืม คืน (ทุกอย่าง) = 0
        totalMin = 0;
        totalSeconds = 0;
        totalHour = 0;
        borrowDate = null;
        returnDate = null;
        timeLeft =  "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;
        //String = ''; หรือ เก็บ Totaltime = null ตามความเหมาะสม
    }
    
    public void start() throws InterruptedException{    //เริ่มนับเวลา
        long tmp01 = totalSeconds;
        long tmp02 = totalMin;
        long tmp03 = totalHour;
        for(int i = 0;i<=tmp03;i++){
            for(int j = 0;j<60;j++){
                for(int k = 0;k<60;k++){
                    Thread.sleep(1000);
                    totalSeconds--;
                    timeLeft = "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;  //เวลาที่เหลือ
                   
                    if(nf.notiTime(totalHour, totalMin, totalSeconds)){     //เหลือ 10 นาที
                        Scanner sc = new Scanner(System.in);
                        //String temp = sc.nextLine();
                        System.out.println(timeLeft+"\nDo you want to increase time (y or n) : ");
                        String temp = sc.nextLine();
                        if(temp.equalsIgnoreCase("y")){
                            System.out.println("Please enter hours do you want to increase : ");
                            int hour = sc.nextInt();
                            System.out.println("Please enter minutes do you want to increase : ");
                            int min = sc.nextInt();
                            System.out.println("Please enter seconds do you want to increase : ");
                            int sec = sc.nextInt();
                        }
                    }
                    
                    System.out.println(timeLeft);
                    
                    if(totalSeconds == 0){  //ถ้าวินาที == 0 ให้หยุด
                        break;
                    }
                }
                totalMin--;     
            
                if(totalMin==-1){       //ถ้านาทีติดลบ
                    totalMin = 0;       //นาที = 0
                    break;
                }
                totalSeconds = 60;      //วินาทีทั้งหมด = 60
            }
            totalHour--;
            
            if(totalHour == -1){        //ถ้าชั่วโมงติดลบ
                totalHour = 0;          //ชั่วโมง = 0
                break;
            }
        }
    }
}
