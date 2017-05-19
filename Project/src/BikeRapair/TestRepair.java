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
       Repair rp = new Repair();
       Date nowTime = new Date();
       Timestamp stopTime = new Timestamp(nowTime.getTime());
       rp.connectDBForAdminUpdateTime(40, stopTime);
    }
}
