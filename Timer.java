import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.*;
public class Timer {
    private String timeLeft ="";
    private int totalSeconds;   //ผลต่างเวลาทั้งหมด
    private int totalMin;       //      ''
    private int totalHour;      //      ''
    private Date borrowTime = new Date();
    private Date returnTime = new Date();
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String returnDate;
    private String borrowDate;
    private Notification nf = new Notification();
    private Thread thread = new Thread();
   
    public Timer() {
        borrowDate = df.format(borrowTime);
    }

    public Timer(int userDate, int userMonth, int userYear,int userHr, int userMin, int userSec) {
        borrowDate = df.format(borrowTime);
        
        returnTime.setDate(userDate);
        returnTime.setHours(userHr);
        returnTime.setMinutes(userMin);
        returnTime.setSeconds(userSec);
        returnTime.setMonth(userMonth-1);
        returnTime.setYear(userYear-1900);
        returnDate = df.format(returnTime);
        
    }

    public Date getReturnTime() {
        return returnTime;
    }
    
    public Date getBorrowTime() {
        return borrowTime;
    }
    
    //โชว์วันเวลา
    public String showDetail(){ //โชว์เวลาทั้งยืมและคืน
        return timeLeft; 
    }
    //ลบเวลา
    public void differentTime(){
        long diffDate;            //เรียกดูวัน
        int diffMonth = 0;          //เรียกดูเดือน
        int diffYear = 0;           //เรียกดูปี
        long diffHour,diffMin,diffSec;
        int keepMonth = borrowTime.getMonth()+1; //เก็บเดือน +1 เพราะเก็บ 0-11
        int keepYear = returnTime.getYear();
        long diffTotal;
        diffTotal = returnTime.getTime() - borrowTime.getTime(); 
        diffSec = diffTotal / 1000 % 60; 
        diffMin = diffTotal / (60 * 1000) % 60; 
        diffHour = (diffTotal / (60 * 60 * 1000) % 24); 
        diffDate = (diffTotal / (60 * 60 * 1000 * 24));
        totalMin = (int)diffMin;
        totalSeconds = (int)diffSec;
        do{
            if(keepMonth > 12){
                keepMonth = 1;
            }
            if(keepMonth == 1 || keepMonth == 3 || keepMonth == 5 || keepMonth == 7 ||
                    keepMonth == 8 || keepMonth == 10 || keepMonth == 12){ //ลงท้ายด้วยคม = 31 วัน
                if(diffDate >= 31){
                    diffMonth++;
                    diffDate -= 31;
                    keepMonth++;
                }else{
                    break;
                }
            }else if(keepMonth == 2){ //เดือนกุมภา
                if((keepYear % 4 == 0) && (keepYear % 100 != 0)){
                    if(diffDate >= 29){
                        diffMonth++;
                        diffMonth -= 29;
                        keepMonth++;
                    }else{
                        keepMonth=0;
                        break;
                    }
                }else{
                    if(diffDate >= 28){
                        diffMonth++;
                        diffDate -= 28;
                        keepMonth++;
                    }else{
                        break;
                    }
                }
            }else if(keepMonth == 4 || keepMonth == 6 || keepMonth == 9 || keepMonth == 11){
                if(diffDate >= 30){
                    diffMonth++;
                    diffDate -= 30;
                    keepMonth++;
                }else{
                    break;
                }
            }
        }while(diffDate > 0);
        while(diffMonth >= 12){
            diffYear++;
            diffMonth -= 12;
        }
        
        totalTime(diffDate,diffMonth,diffYear,diffHour,diffMin,diffSec);
    }
    
    public void totalTime(long diffDate,int diffMonth,int diffYear,long diffHour,long diffMin,long diffSec){
        int temp = 0;
        if(diffYear != 0){             
            if((diffYear % 4 == 0) && (diffYear % 100 != 0)){                 
                temp += (diffYear*366)*24;             
            }else{                 
                temp += (diffYear*365)*24;             
            }         
	}
        if(diffMonth != 0){
            int keepMonth = borrowTime.getMonth()+1;
            int keepYear = returnTime.getYear();
            for (int i = 0; i < diffMonth; i++) {
               if(keepMonth == 1 || keepMonth == 3 || keepMonth == 5 || keepMonth == 7 ||
                    keepMonth == 8 || keepMonth == 10 || keepMonth == 12){
                    temp += 31*24;
                    keepMonth++;
                }else if(keepMonth == 2){
                    if((keepYear % 4 == 0) && keepYear % 100 != 0){
                        temp += 29*24;
                        keepMonth++;
                    }else{
                            temp += 28*24;
                            keepMonth++;
                    }
          
                }else if(keepMonth == 4 || keepMonth == 6 || keepMonth == 9 || keepMonth == 11){
                    temp += 31*24;
                    keepMonth++;
                }
            }
        }
        if(diffDate != 0){
            temp += diffDate*24;
        }
        totalHour += temp+diffHour;
        timeLeft = "Now : "+totalHour+" Hours "+totalMin+" Minutes "+totalSeconds+" Secounds";
    }
	
    public void increaseTime(int hr,int min,int sec){
        Date temp = new Date(returnTime.getYear(), returnTime.getMonth(),returnTime.getDate(),returnTime.getHours()+hr,returnTime.getMinutes()+min,returnTime.getSeconds()+sec);
        returnDate = df.format(temp);
        
        //เพิ่มใน total hour min second
        totalHour = totalHour+hr;
        
        totalMin = totalMin+min;
        
        totalSeconds = totalSeconds+sec;
        while(totalSeconds >= 60){
            totalMin += 1;
            totalSeconds -= 60;
        } 
        
        while(totalMin >= 60){
            totalHour += 1;
            totalMin -= 60;
        }
        timeLeft = "Now : "+totalHour+" Hours "+totalMin+" Minutes "+totalSeconds+" Secounds";
          
    }
    
    public void stop(){
        //จับวันที่ยืม คืน (ทุกอย่าง) = 0
        thread.stop();
        totalMin = 0;
        totalSeconds = 0;
        totalHour = 0;
        borrowDate = null;
        returnDate = null;
        timeLeft =  "Now : "+totalHour+" Hours "+totalMin+" Minutes "+totalSeconds+" Secounds";
        //String = ''; หรือ เก็บ Totaltime = null ตามความเหมาะสม
    }
    
    public void start() throws InterruptedException{
        long tmp = totalHour;
        if(totalSeconds == 0 && totalMin == 0){
            totalHour -= 1;
            totalMin = 59;
            totalSeconds = 60;
        }
        Runnable runnable = new Runnable() {
            public void run() {
                for(int i = 0;i<=tmp;i++){
                    for(int j = 0;j<60;j++){
                        for(int k = 0;k<60;k++){
                            
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            totalSeconds--;
                            timeLeft = "Now : "+totalHour+" Hours "+totalMin+" Minutes "+totalSeconds+" Secounds";
                            if(nf.notiTime(totalHour,totalMin,totalSeconds)){
                                Scanner sc = new Scanner(System.in);
                                System.out.println(timeLeft + "\nDo you want to increase time? (y or n)");
                                String result = sc.nextLine();
                                if(result.equalsIgnoreCase("y")){
                                    System.out.print("Please Enter Hour Do you want to increase : ");
                                    int h = sc.nextInt();
                                    System.out.print("Please Enter Minutes Do you want to increase : ");
                                    int m = sc.nextInt();
                                    System.out.print("Please Enter Secound Do you want to increase : ");
                                    int s = sc.nextInt();
                                    increaseTime(h, m, s);
                                }
                            }
                            System.out.println(timeLeft);
                            if(totalSeconds == 0){
                                break;
                            }
                        }
                        totalMin--;

                        if(totalMin==-1){
                            totalMin = 0;
                            break;
                        }
                        totalSeconds = 60;
                    }
                    totalHour--;
                    if(totalHour == -1){
                        totalHour = 0;
                        break;
                    }
                    totalMin = 59;
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
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

}
