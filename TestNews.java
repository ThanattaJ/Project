/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.news;

/**
 *
 * @author user
 */
import java.sql.*;
import java.util.*;
public class TestNews {
    public static void main(String[] args) throws Exception{
        //โหลด Driver
        
        Class.forName("com.mysql.jbdc.Driver");
        //สร้างการเชื่อมต่อ
        
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Select categories news : ");
//        int listNews = sc.nextInt();
//        switch(listNews){
//            case 1:
//                System.out.println("Lastest News");
//                    System.out.print("Select news 1 press 1, news 2 press 2 : ");
//                    int value = sc.nextInt();
//                    if(value == 1){
//                        System.out.println("aaaaaaaaaaaaaaaa");
//                    }
//                    else if(value == 2){
//                        System.out.println("bbbbbbbbbbbbbbbb");
//                    }    
//                break;
//            case 2:
//                System.out.println("All News");
//                    System.out.print("Select news 1 press 1, news 2 press 2 : ");
//                    int value2 = sc.nextInt();
//                    if(value2 == 1){
//                        System.out.println("cccccccccc");
//                    }
//                    else if(value2 == 2){
//                        System.out.println("dddddddddd");
//                    } 
//                break;
//        }
        
        
            
        /*if(listNews == 1){
            System.out.println("Lastest News");
            
        }
        else if(listNews == 2){
            System.out.println("All News");
            System.out.println("อุวิมอุวิมโอซาส");
        }*/
        
        //News a = new News("Crime News","fbbhdffgghm");
        //int i = 0;
        //String[] news = new String[10];
        /*news[0] = "A";
        news[1] = "B";
        news[2] = "C";
        news[3] = "D";
        news[4] = "E";
        news[5] = "F";
        news[6] = "G";
        news[7] = "H";
        news[8] = "I";
        news[9] = "J";
        System.out.println(news);*/
        //System.out.println(a.searchNews(1));
    }
}
