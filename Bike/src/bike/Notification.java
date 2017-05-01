package bike;

import java.sql.*;

public class Notification {
    private Database db;

    public Notification() {

    }


    public boolean notiTime(Object obj,int hr, int min, int sec) {
          if(obj instanceof Sharing){
            if(hr==0 && min == 10 && sec ==0){
              return true;
            }
          }else if(obj instanceof Repair){
            if(hr==0 && min == 3 && sec ==0){
                return true;
            }
          }
          return false;
    }

    public String notiRepairFinish() {
        return "---Notification---\nRepairs completed,You can pick up it. From this day onwards.";
    }

    public String notiRepairIncreseTime(String oldDate, String detail, String newDate) {
        return "---Notification---\n>>Old Date :\n" + oldDate + "\n>>Detail :\n" + detail + "\n>>New Date :\n" + newDate;
    }
}

