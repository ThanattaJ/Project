/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register;

import ConnectDB.ConnectDatabase;
import Timer.Timer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author January
 */
public class Register {
    private long id;
    private String name;
    private String surname;
    private String password;
    private char gender;
    private Timestamp birthDate;
    private String conDisease;
    private String email;
    private String tel;
    private String deptID;

    public Register() {
    }

    public Register(String name, String surname, String password, char gender, Timestamp birthDate ,String conDisease, String email, String tel, String deptID) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.birthDate = birthDate;
        this.conDisease = conDisease;
        this.email = email;
        this.tel = tel;
        this.deptID = deptID;
    }

//    public void timeStamp(int y,int m,int d){
//        int year = y-1900;
//        int mount = m-1;
//        int date = d;
//        Date bday = new Date(year, mount, date);
//        this.currentDate = new Timestamp(bday.getTime());
//    }
    
    public void registerDB(){
        
        try{
            ConnectDatabase cndb = new ConnectDatabase();
            Connection connect = ConnectDatabase.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database connecting");
            Statement st = connect.createStatement(); 
            
            String idDb = "\'"+id+"\'";
            String nameDb = "\'"+name+"\'";
            String surnameDb = "\'"+surname+"\'";
            String genderDb = "\'"+gender+"\'";
            String conDiseaseDb = "\'"+conDisease+"\'";
            String emailDb = "\'"+email+"\'";
            String telDb = "\'"+tel+"\'";
            String depId = "\'"+deptID+"\'";
            String temp = "INSERT INTO `User` (`userID`, `firstName`, `lastName`, `gender`, `birthDate`, `congenitialDisease`, `email`, `tel`, `deptID`) "
                    + "VALUES "
                    + "(" + idDb + ","
                    + nameDb +"," 
                    + surnameDb + ","
                    + genderDb + ","
                    + birthDate + ","
                    + conDiseaseDb + ","
                    + emailDb + ","
                    + telDb +","
                    + depId+");";
            st.executeUpdate(temp);
            try {
		if(connect != null){
                    connect.close();
		}
		}catch (SQLException e){
                    e.printStackTrace();
		}         
        }
        catch(ClassNotFoundException cfe){
            System.out.println(cfe);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public String encocdMd5(){
        try{
            String input = password;
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[]messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1,messageDigest);
            String md5 = number.toString(16);
            while(md5.length()<32){
                md5="0"+md5;
            }
            return md5;
        }
        catch(NoSuchAlgorithmException e){
            return null;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public String getConDisease() {
        return conDisease;
    }

    public void setConDisease(String conDisease) {
        this.conDisease = conDisease;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }
    
    
}
