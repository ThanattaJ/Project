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
    private String timeDetail;//เวลาที่ช่างซ่อมจะซ่อมเสร็จ
    private Notification notic = new Notification();
    private String repair="-----------------------Bike Repair------------------------"; //ข้อมูลทั้งหมด
    private String repairWhatAlse="";
    private String increaseDetail="";
    private History historyRp = new History();
    private String bike="";
    
    public String submitRepair(){
        Timestamp borrowDate = new Timestamp(time.getNowTime().getTime());
        repair += "\nProblem: "+getProblem()+ "\n" +"Detail: "+getDetail()+"\n"+repairWhatAlse+increaseDetail+timeDetail;
        time.stop();
        historyRp.HistoryByAdmin(bike, borrowDate,"Repair");
        return repair;
    }
    
    public String increaseTimeRepair(int hr,int min,int sec){//เมธอดเพิ่มเวลาเมื่อช่างซ่อมซ่อมไม่เสร็จ
        String oldTime = timeDetail;
        plusDay(hr,min,sec);
        String newTime="";
        String increaseTime = "Increase Time : "+hr+":"+min+":"+sec; //เวลาที่ช่างซ่อมต้องการเพิ่ม
//        time.increaseTime(hr, min, sec);// เรียก method increaseTime ของ Class Timer เพื่อเพิ่มเวลาที่ช่างซ่อมต้องการจะซ่อม
        newTime = time(); //เวลาที่ช่างซ่อมจะซ่อมเสร็จ
        String output = notic.notiRepairIncreseTime(oldTime, increaseTime, newTime); //เรียก Notic
        timeDetail= newTime;
        return output;
    }
    
     public String increaseTimeRepair(String newProblem,String newDetail,int hr,int min,int sec){
//เมธอดเพิ่มปัญหาที่ช่างซ่อมพบเจอใหม่ พร้อมกับประเมินเวลาที่จะซ่อมเสร็จด้วย
        String oldTime = timeDetail;
        plusDay(hr,min,sec);
        String newTime="";
        String increaseTime = "Increase Time : "+hr+":"+min+":"+sec;
        newTime = time();
        String detail = "RepairProblem: "+newProblem+"\n"
                +"RepairDetail: "+newDetail+"\n"
                +increaseTime; 
        String output = notic.notiRepairIncreseTime(oldTime,detail, newTime);
        timeDetail= newTime;
        increaseDetail = "Problem: "+newProblem+"\n"
                +"Detail: "+newDetail+"\n";
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
    
    
    public String whatAlse(String ans){ //เมธอดถามช่างซ่อมส่าต้องการที่จะกรอกปัญหาอีกไหม
       String output="";
        System.out.println("----------------------------------------------");
        if(ans.equalsIgnoreCase("Yes")){
            boolean tem = true;
            do{
                Scanner sc = new Scanner(System.in);
                Repair rp = new Repair();
                System.out.print("Enter your problem: ");
                rp.setProblem(sc.nextLine());
                output+="Problem: "+rp.getProblem();
                System.out.print("Enter your detail: ");
                rp.setDetail(sc.nextLine());
                output+="\nDetail: "+rp.getDetail()+"\n";
                System.out.print("Enter your time(HH:mm:ss): ");
                plusDay(sc.nextInt(),sc.nextInt(),sc.nextInt());
                System.out.print("Any service else?: ");
                rp.setAns(sc.next());
                if(rp.getAns().equalsIgnoreCase("No")){
                    System.out.println("-------------------------------------");
                    tem = false;
                    System.out.println(output);
                    break;
                }
            }while(true);
            repairWhatAlse += output;
            output+=time();
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
    

    @Override
    public String toString() {
        return "Problem: " + problem 
                + "\nDetail: " + detail+"\n";
    }
    
    
}
