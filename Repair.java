package BikeRapair;

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
    private Time timer;
    
    public String Status(boolean tem){ // รับมาจากปุ่มกด ถ้าเสร็จเป็น true ไม่เสร็จเป็น false
        String status = "";
        if(tem==false){
            status+="Not success!";
        }else if(tem==true){
            status+="Success!";
        }
        return status;  
    }
    
//    public Timer Start(int hour,int minute,int secound){
//        Timer();
//    }

    public Repair() {
    }

    public Time getTimer() {
        return timer;
    }

    public void setTimer(Time timer) {
        this.timer = timer;
    }
    
    
    
//    public Time Time(){
//        Time t = new Time(getDate(),getMonth(),getYear(),getHours(),getMinutes(),getSecound());
//        return t;
//    }

    public Repair(String detail) {
        this.detail = detail;
    }

    public Repair(String problem, String detail,Time t) {
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

    @Override
    public String toString() {
        return "Repair{" + "problem=" + problem + ", detail=" + detail + ", Time="+ timer ;
    }
    
    
}
