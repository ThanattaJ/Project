package BikeRapair;


import History.History;
import Timer.Timer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class TestRepair {
//    public static void main (String [] args) throws InterruptedException{
////        Repair r = new Repair();
////
////        r.setHours(0);
////        r.setMinute(1);
////        r.setSecound(0);
////        
////        System.out.println(r.time());
////        r.sentDatabaseHistory();
//        Scanner sc = new Scanner(System.in);
////        History h = new History();
////        
////        
//        Repair rp = new Repair();
////        rp.setBike("Trek");
////        rp.setColor("Black and White");
////        rp.setWhyRepair("Broke chain");
//////        rp.setBike("B02");
//////        rp.setWhyRepair("Beake Broke");
//////        
//////
////        System.out.print("Enter your bike: ");
////        rp.setBike(sc.nextLine());
////        System.out.print("Enter bike problem: ");
////        rp.setProblem(sc.nextLine());
////        System.out.print("Enter bike detail: ");
////        rp.setDetail(sc.nextLine());
////        System.out.print("Enter your time(HH:mm:ss): ");
////        rp.setHours(sc.nextInt());
////        rp.setMinute(sc.nextInt());
////        rp.setSecound(sc.nextInt());
////      
////        System.out.println("---------------------------------------------------------------------------");
////        System.out.print("Any service else?: ");
////        rp.whatAlse(sc.next());
////        rp.getDetailRepair();
////        rp.Status(true);
////        rp.time();
////        rp.connectDB();
////        rp.sentDatabaseHistory();
////        System.out.print(rp);
////        System.out.println(rp.time());
////        System.out.println("-----------------------------------no-------------------");
////        
////        rp.increaseTimeRepair("Test","Increase",0, 30, 0);
////        System.out.println("***************************************");
////        System.out.println(rp.submitRepair());
////        System.out.println("...."+rp.getTimeDetail());
////        System.out.println(c);
////        System.out.println(rp.getDetailRepair());
////        System.out.println(rp.submitRepair());
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                home guihome = new home();
////                guihome.setVisible(true);
////                guihome.connectRepairing(rp);
////            }
////        });
////        rp.sentDatabaseHistory();
//          int temp = rp.connectDBForCheckRepairNotSucceess().size();
//          for (int i = 0; i < temp; i++) {
//              System.out.println(rp.connectDBForCheckRepairNotSucceess().get(i));
//        }
//        rp.connectDBForChangeToSuccess(4);
//    }
    
    public static void main(String[] args) throws InterruptedException {
        Repair rp = new Repair();
        Timestamp start = new Timestamp (1494893456);
        Timestamp stop = new Timestamp (1494893538);
        rp.connectDBForAdminUpdateTime(17, start, stop);
        
//        rp.connextDBforAdminCheakAddRepeir();
//        for (int i = 0; i < diff.size(); i++) {
//            System.out.println(diff.get(i));
//        }
//        BikeRepairAdminNotSuccess rp = new BikeRepairAdminNotSuccess();
//        rp.repairDetailForNotSuccess(1);
//        //--------------------------------
//        Date start = rp.getStartTime();
//        Date end = rp.getEndTime();
//        //---------------------------------
//        long startTime = rp.getStartTime().getTime();
//        long endTime = rp.getEndTime().getTime();
//        long diffTime = endTime-startTime;
//        System.out.println("diffTime: "+diffTime);
        //---------------------------------
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//        String startTime = dateFormat.format(start);
//        int hourStart = Integer.parseInt(startTime.substring(0,2));
//        int minuteStart = Integer.parseInt(startTime.substring(3,5));
//        int secoundStart = Integer.parseInt(startTime.substring(6,8));
//        String endTime = dateFormat.format(end);
//        int hourEnd = Integer.parseInt(endTime.substring(0,2));
//        int minuteEnd = Integer.parseInt(endTime.substring(3,5));
//        int secoundEnd = Integer.parseInt(endTime.substring(6,8));
//        
//        int diffHours  = hourEnd - hourStart;
//        int diffMinute = minuteEnd - minuteStart;
//        int diffSecound = secoundEnd - secoundStart;
//        
//        System.out.println("hour: "+diffHours);
//        System.out.println("minute: "+diffMinute);
//        System.out.println("secound: "+diffSecound);
//        Repair rpAdmin = new Repair();
//        rpAdmin.setHours(1);
//        Timestamp startfff = new Timestamp (rpAdmin.startTimeToRepair().getTime());
//        Timestamp stopfff = new Timestamp (rpAdmin.endTimeToRepair().getTime());
//        rpAdmin.connectDBForAdminUpdateTime(31, startfff, stopfff);
//        System.out.println("formatTime: "+startTime);
        //--------------------------------
//        Date diff = new Date(diffTime) ;
//        System.out.println("diffTime: "+diff);
       
    }
}
