/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Nawaz Sharif Haidary
 */
public class dbguest {
    
    PreparedStatement pst=null;
    String conString="jdbc:sqlite:G:\\NAWAZ\\mydb.sqlite";
    
     public Boolean Delete(String id)
    {
            String sql="DELETE from guest_details where id="+id+"";
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
     public Boolean update(String id,String firstname,String surname,String address,String nationality,String gender,String mobileno,
             String identity,String idno,String roomno,String roomtype,String bedtype,String roomrate,Date checkindate,Date dateofout,String tax,String noofdays,
             String totaltariff)
    {
        String sql="UPDATE guest_details SET firstname='"+firstname+"',surname='"+surname+"',address='"+address+"',nationality='"+nationality+"',gender='"+gender+"',mobile_no='"+mobileno+"',"+
                
                " identity='"+identity+"',id_no='"+idno+"',room_no='"+roomno+"',room_type='"+roomtype+"',bed_type='"+bedtype+"',tariff_per_day='"+roomrate+"',check_in_date='"+checkindate+"',date_of_out='"+dateofout+"',"
                + "tax='"+tax+"' ,no_of_days='"+noofdays+"',total_tariff='"+totaltariff+"' Where id='"+id+"'";
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
