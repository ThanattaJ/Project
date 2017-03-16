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
    private Timer timer;
    private String ans;
    private int hours;
    private int minute;
    private int secound;
    
    public String time(){
        GregorianCalendar gc = new GregorianCalendar();
        int realHour=gc.get(Calendar.HOUR)+hours+12;
        int realMinute=gc.get(Calendar.MINUTE)+minute;
        int realSecound=gc.get(Calendar.SECOND)+secound;
        Timer t = new Timer(gc.get(Calendar.DATE),gc.get(Calendar.MONTH)+1,gc.get(Calendar.YEAR), 
                realHour,realMinute,realSecound);
        t.differentTime();
        return t.showDetail();
    }
   
    
    public void plusDay(int h,int m,int s){
        this.hours+=h;
        if(this.minute>=60){
            int tem= this.minute%60;
            this.minute = tem;
            this.hours+=1;
        }else{
            this.minute+=m;
        }
        
        if(this.secound>=60){
            int tem = this.secound%60;
            this.secound=tem;
            this.minute+=1;
        }else{
            this.secound+=s;
        }
    }
    
    public String showTime(){
        return this.hours+":"+this.minute+":"+this.secound;
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

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
    public Repair(String detail) {
        this.detail = detail;
    }

    public Repair(String problem, String detail,Timer t) {
        this.problem = problem;
        this.detail = detail;
        this.timer = t;
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
        return ""
                + "Problem: " + problem 
                + "\nDetail: " + detail+"\n"
                + "Finish time: "+showTime()+"\n";
    }
    
    
}
