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
        
        System.out.print("Enter your time(HH:mm:ss): ");
        rp.setHours(sc.nextInt());
        rp.setMinute(sc.nextInt());
        rp.setSecound(sc.nextInt());
        System.out.println("---------------------------------------------------------------------------");
        System.out.print("Any service else?: ");
        rp.whatAlse(sc.next());
        System.out.print(rp);
        System.out.println(rp.time());
    }
}
