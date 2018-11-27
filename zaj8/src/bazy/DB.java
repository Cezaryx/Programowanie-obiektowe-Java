package bazy;

import java.sql.*;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/nazwa_bazy", "username", "password ");
        }catch(SQLException ex){
            System.out.println("SQLException: " +ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}
    }
    public String printAll(){
        String str = new String();
        return str;
    }
}
