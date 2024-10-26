package dbconnection;

import java.sql.*;
import java.util.Properties;
public class DbConnection {
    static Connection connection;
	static public Connection getConnection(){
        try{
            Properties props = ConfigLoader.loadProperties();
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,user,password);
        }
        catch(Exception e){
            System.out.println("Connection to Database Failed!");
        }
        return connection;
    }
}