/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BikeRapair;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Time {
    //private String total;
    private String timeLeft;
    private int totalSeconds;   
    private int totalMin;      
    private int totalHour;      
    private Date nowTime = new Date();;
    private Date user = new Date();
    private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String returnDate;
    private String borrowDate;
   
    
    public Time() {
        
    }

    public Time(int userDate, int userMonth, int userYear,int userHr, int userMin, int userSec) {
        borrowDate = df.format(nowTime);
        
        user.setDate(userDate);
        user.setHours(userHr);
        user.setMinutes(userMin);
        user.setSeconds(userSec);
        user.setMonth(userMonth-1);
        user.setYear(userYear-1900);
        returnDate = df.format(user);
        
    }
    
    
    public String showDetail(){ 
        return "Now Date : "+borrowDate+"\n"+
               "Return Date : "+returnDate+"\n"+timeLeft; 
    }
    
    public void differentTime(){
        long diffDate;            
        int diffMonth = 0;          
        int diffYear = 0;           
        long diffHour,diffMin,diffSec;
        int keepMonth = nowTime.getMonth()+1; 
        int keepYear = user.getYear();
        long diffTotal;
        diffTotal = user.getTime() - nowTime.getTime(); 
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
                    keepMonth == 8 || keepMonth == 10 || keepMonth == 12){ 
                if(diffDate >= 31){
                    diffMonth++;
                    diffDate -= 31;
                    keepMonth++;
                }else{
                    break;
                }
            }else if(keepMonth == 2){
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
            int keepMonth = nowTime.getMonth()+1;
            int keepYear = user.getYear();
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
        timeLeft = "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;
    }
	
    public void increaseTime(int hr,int min,int sec){
        Date temp = new Date(user.getYear(), user.getMonth(),user.getDate(),user.getHours()+hr,user.getMinutes()+min,user.getSeconds()+sec);
        returnDate = df.format(temp);
        //total hour min second
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
        timeLeft = "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;
          
    }
    
    public void stop(){
       
        totalMin = 0;
        totalSeconds = 0;
        totalHour = 0;
        borrowDate = null;
        returnDate = null;
        timeLeft =  "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;
       
    }
    
    public void start() throws InterruptedException{
        long tmp01 = totalSeconds;
        long tmp02 = totalMin;
        long tmp03 = totalHour;
        for(int i = 0;i<=tmp03;i++){
            for(int j = 0;j<60;j++){
                for(int k = 0;k<60;k++){
                    Thread.sleep(1000);
                    totalSeconds--;
                    timeLeft = "Time Left : "+totalHour+":"+totalMin+":"+totalSeconds;
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
        }
    }
}
