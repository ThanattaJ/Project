//Attribute for GUI Timer
    private String startBorrow;
    private String stopBorrow;
    
    public void showStartAndEndTime(){
        Date date= new Date();
//        System.out.println(new Timestamp(date.getTime()));
        try{
            Database cndb = new Database();
            Connection connect = Database.connectDb("win", "win016");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Database connecting");
        
            Statement st = connect.createStatement(); 
            String sql = "SELECT dateTime,return_dateTime,MAX(transID) FROM `Transaction` WHERE userID=111";
            ResultSet rs = st.executeQuery(sql);
//            new Timestamp(date.getTime())
            while(rs.next()){
                startBorrow = rs.getTimestamp("dateTime")+"";
                stopBorrow = rs.getTimestamp("return_DateTime")+"";
                
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
    
    public String getshowStartAndEndTime(){
        return "Start: "+startBorrow+"    "+"End: "+stopBorrow;
    }