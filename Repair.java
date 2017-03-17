package BikeRapair;


import java.util.Calendar;
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
public class Repair {
    private String problem;
    private String detail;
    private Timer time = new Timer();
    private String ans;
    private int hours;
    private int minute;
    private int secound;
    private String timeDetail;
    private Notification notic = new Notification();
    
    public String increaseTimeRepair(int hr,int min,int sec){//เมธอดเพิ่มเวลาเมื่อช่างซ่อมซ่อมไม่เสร็จ
        String a="";
        String increaseTime = "Increase Time : "+hr+":"+min+":"+sec; //เวลาที่ช่างซ่อมต้องการเพิ่ม
        time.increaseTime(hr, min, sec);// เรียก method increaseTime ของ Class Timer เพื่อเพิ่มเวลาที่ช่างซ่อมต้องการจะซ่อม
        a = time.showDetail(); //เวลาที่ช่างซ่อมจะซ่อมเสร็จ
        String output = notic.notiRepairIncreseTime(timeDetail, increaseTime, a); //เรียก Notic
        timeDetail= a;
        return output;
    }
    
    public String increaseTimeRepair(String newProblem,String newDetail,int hr,int min,int sec){//เมธอดเพิ่มปัญหาที่ช่างซ่อมพบเจอใหม่ พร้อมกับประเมินเวลาที่จะซ่อมเสร็จด้วย
        String temp ="";
        String increaseTime = "Increase Time : "+hr+":"+min+":"+sec;
        time.increaseTime(hr, min, sec);
        String detail = "RepairProblem: "+newProblem+"\n"
                +"RepairDetail: "+newDetail+"\n"
                +increaseTime;
        temp = time.showDetail();   
        String output = notic.notiRepairIncreseTime(timeDetail,detail, temp);
        timeDetail= temp;
        return output;
    }
    
    public String time(){
        GregorianCalendar gc = new GregorianCalendar();
        int realHour=gc.get(Calendar.HOUR)+hours+12; //เวลาเป็นชั่วโมงจริงของวันนี้บวกกับชั่วโมงที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        int realMinute=gc.get(Calendar.MINUTE)+minute; // เวลาเป็นนาทีของวันนี้บวกกับนาทีที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        int realSecound=gc.get(Calendar.SECOND)+secound;// เวลาเป็นวินาทีของวันนี้บวกกับวินาทีที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        Timer t = new Timer(gc.get(Calendar.DATE),gc.get(Calendar.MONTH)+1,gc.get(Calendar.YEAR), 
                realHour,realMinute,realSecound); //ส่งค่าผ่าน Constructor ไปให้ Class Timer กำหนดวัน เดือน ปี เป็นของวันที่ปัจจุบัน
        t.differentTime();
        this.timeDetail=t.showDetail();
        return this.timeDetail;
    }
   
    public void plusDay(int h,int m,int s){ //เมธอดคำนวณชั่วโมง นาที วินาที ไม่ให้มันเกินตามความเป็นจริง
          this.hours+=h;
          this.minute+=m;
          this.secound+=s;
          time.differentTime();
    }
    
    
    public String whatAlse(String ans){
       String output="----------------------------------------------\n";
        if(ans.equalsIgnoreCase("Yes")){
            boolean tem = true;
            do{
                Scanner sc = new Scanner(System.in);
                Repair rp = new Repair();
                System.out.print("Enter your problem: ");
                rp.setProblem(sc.nextLine());
                output+="Problem: "+rp.getProblem()+"\n";
                System.out.print("Enter your detail: ");
                rp.setDetail(sc.nextLine());
                output+="Detail: "+rp.getDetail();
                System.out.print("Enter your time(HH:mm:ss): ");
                plusDay(sc.nextInt(),sc.nextInt(),sc.nextInt());
                System.out.print("Any service else?: ");
                rp.setAns(sc.next());
                if(rp.getAns().equalsIgnoreCase("No")){
                    tem = false;
                    System.out.println(output);
                    break;
                }
            }while(true);
            output+="Showtime: "+showTime();
        }
        return output;
    }
    
    public String Status(boolean tem){ // รับมาจากปุ่มกด ถ้าเสร็จเป็น true ไม่เสร็จเป็น false
        String status = "";
        if(tem==false){
            status+="Not success!";
        }else if(tem==true){
            status+="Success!";
        }
        return status;  
    }
   
    public Repair() {
    }
    
    
    public Repair(String detail) {
        this.detail = detail;
    }

    public Repair(String problem, String detail,Timer t) {
        this.problem = problem;
        this.detail = detail;
        this.time = t;
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
    
    public String submitRepair(){
        String a ="";
        time.stop();
        timeDetail=time.showDetail();
        return a;
    }

    @Override
    public String toString() {
        return ""
                + "Problem: " + problem 
                + "\nDetail: " + detail+"\n";
    }
    
    
}
