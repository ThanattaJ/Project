package BikeRapair;


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
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        Repair rp = new Repair();
        System.out.print("Enter bike problem: ");
        rp.setProblem(sc.nextLine());
        System.out.print("Enter bike detail: ");
        rp.setDetail(sc.nextLine());
        Time t = new Time(15,03,2017,0,30,12);
        rp.setTimer(t);
        t.differentTime();
        System.out.println(rp.Status(true));
        System.out.println(t.showDetail());
        
        
    }
}
