package BikeRapair;


import History.History;
import Timer.Timer;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public static void main(String[] args) throws InterruptedException {
        Timer t =new Timer();
        int hours = 0;
        int minute = 10;
        int secound = 0;
        
        Calendar time = Calendar.getInstance();
        int realHour = time.get(Calendar.HOUR_OF_DAY)+hours;//เวลาเป็นชั่วโมงจริงของวันนี้บวกกับชั่วโมงที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        int realMinute=time.get(Calendar.MINUTE)+minute; // เวลาเป็นนาทีของวันนี้บวกกับนาทีที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        int realSecound=time.get(Calendar.SECOND)+secound;// เวลาเป็นวินาทีของวันนี้บวกกับวินาทีที่ช่างซ่อมประเมินว่าจะซ่อมเสร็จ
        t = new Timer(time.get(Calendar.DATE),time.get(Calendar.MONTH)+1,time.get(Calendar.YEAR), 
                realHour,realMinute,realSecound); //ส่งค่าผ่าน Constructor ไปให้ Class Timer กำหนดวัน เดือน ปี เป็นของวันที่ปัจจุบัน
        t.differentTime();
       
        t.start(t);
    }
}
