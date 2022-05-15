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

/**
 *
 * @author Nawaz Sharif Haidary
 */
public class dbemployee {
     PreparedStatement pst=null;
    String conString="jdbc:sqlite:G:\\NAWAZ\\mydb.sqlite";
    
     public Boolean Delete(String id)
    {
            String sql="DELETE from staff where id="+id+"";
        try
        {
            Connection conn=DriverManager.getConnection(conString);
            Statement s=conn.prepareStatement(sql);
            
              pst=conn.prepareStatement(sql);
            
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
}
