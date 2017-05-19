/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package History;

/**
 *
 * @author user
 */
import java.io.*; 
import java.sql.*; 
import ConnectDB.ConnectDatabase;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.general.DefaultPieDataset;

public class PieChart_DB {
   
   public static void main( String[ ] args )throws Exception {
      
      String mobilebrands[] = {
         "IPhone 5s",   
         "SamSung Grand",   
         "MotoG",            
         "Nokia Lumia" 
      };
      int statOfRepair=0;
      java.util.Date now = new java.util.Date();
      String adminDate = (now.getYear()+1900)+"-"+(now.getMonth()+1)+"-"+now.getDate();
      /* Create MySQL Database Connection */
      Class.forName( "com.mysql.jdbc.Driver" );
      Connection connect = ConnectDatabase.connectDb("win", "win016");
      
      Statement statement = connect.createStatement( );
      ResultSet resultSet = statement.executeQuery("SELECT COUNT(transID) AS statRepair FROM `Transaction` WHERE dateTime LIKE \'" +adminDate +"%\' AND action LIKE 'Repair'" );
      DefaultPieDataset dataset = new DefaultPieDataset( );
      
      while( resultSet.next( ) ) {
         dataset.setValue( 
         resultSet.getString( "statRepair" ) ,
         Double.parseDouble( resultSet.getString( "unit_sale" )));
      }
      
      JFreeChart chart = ChartFactory.createPieChart(
         "History",   // chart title           
         dataset,          // data           
         true,             // include legend          
         true,           
         false );

      int width = 560;    /* Width of the image */
      int height = 370;   /* Height of the image */ 
      File pieChart = new File( "Pie_Chart.jpeg" );
      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
   }
}
