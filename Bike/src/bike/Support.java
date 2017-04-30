package bike;

import java.sql.*;
public class Support {
    private String search;
    private String output=""; 

    public Support() {
    }
    
    public void searchSupport(String search){
        try{
            Connection connect = Database.connectDb("jan", "jan042");
            Class.forName("com.mysql.jdbc.Driver");
        
            Statement st = connect.createStatement(); 
            String temp = "SELECT * FROM Manual WHERE manualDescription LIKE '%"+search+"%' OR manualDetails LIKE '%"+search+"%'";
            ResultSet rs = st.executeQuery(temp);
    
            while(rs.next()){
                output+=("manualID : " + rs.getString("manualID"))+"\n";
                output+=("manualDescription : \n" + rs.getString("manualDescription"))+"\n";
                output+=("manualDetails : " + rs.getString("manualDetails")+"\n");
                output+=("----------------------------------------------");
            }
            
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
        System.out.println("");
    }
    
    public String contact(){
        String detail="";
        detail+="Address:\n"
                +"Keas 69 Str.\n"
                +"12345, Chalandri \n"
                +"Athens\n"
                +"Greece\n"
                +"Phone number: 012-3456789\n"
                +"Line: @GreenSociety\n"
                +"Facebook: GreenSocietyKMUTT";
        return detail;
    }

    

    public Support(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    @Override
    public String toString() {
        return "Support{" + "search=" + search + '}';
    }
    
    
}
