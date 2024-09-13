package dbconnection;

import java.sql.*;

public class DbConnection {
	public void getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","nikhil12");
        }
        catch(Exception e){
            System.out.println("Connection to Database Failed!");
        }
    }
    public static void main(String[] args) {
        DbConnection c = new DbConnection();
        c.getConnection();
    }
}
