package dbconnection;

import java.sql.*;

public class DbConnection {
    static Connection connection;
	static public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software","root","nikhil12");
        }
        catch(Exception e){
            System.out.println("Connection to Database Failed!");
        }
        return connection;
    }
}
