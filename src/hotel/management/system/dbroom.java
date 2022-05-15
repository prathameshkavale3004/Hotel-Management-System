/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nawaz Sharif Haidary
 */
public class dbroom {
    
    PreparedStatement pst=null;
    String conString="jdbc:sqlite:G:\\NAWAZ\\mydb.sqlite";
    
     public Boolean Delete(String id)
    {
            String sql="DELETE from room_details where id="+id+"";
        try
        {
            Connection conn=DriverManager.getConnection(conString);
            Statement s=conn.prepareStatement(sql);
            
              pst=conn.prepareStatement(sql);
            ;
            pst.execute();
            return true;
          
        
        }
        catch(Exception e)
        {
            System.out.print(e);
            return false;
        }
        finally {
            
            try{
                
                pst.close();
                
            }
            catch(Exception e){
                
            }
        }
        
        }
     public DefaultTableModel getData()
    {
        DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("Room_no");
        dm.addColumn("Bed_Type");
        dm.addColumn("Room_Type");
        dm.addColumn("Room_Rate");
        String sql="Select * from room_details";
        try
        {
            Connection con=DriverManager.getConnection(conString);
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery(sql);
      
            
            
            while(rs.next())
            {
                String id=rs.getString(1);
                String room_no=rs.getString(2);     
                String Bed_Type=rs.getString(3);
                String Room_Type=rs.getString(4);
                String Room_Rate=rs.getString(5);
                
                
                dm.addRow(new String[]{id,room_no,Bed_Type,Room_Type,Room_Rate});
            }
            return dm;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            
        }
        return null;
    }
     public Boolean update(String id,String Roomno,String roomtype,String bedtype,String Roomrate)
    {
        String sql="UPDATE room_details SET room_no='"+Roomno+"',room_type='"+roomtype+"',bed_type='"+bedtype+"',tariff='"+Roomrate+"' Where id='"+id+"'";
        try
        {
            Connection con=DriverManager.getConnection(conString);
            Statement s=con.createStatement();
            
            s.execute(sql);
            return true;
        }
        catch(Exception e)
         {
             System.out.print(e);
             return false;
         }
    }
    
    
    
}
