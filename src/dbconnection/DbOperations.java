package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import gettersetter.*;

public class DbOperations {
    public static boolean login(String email,String password){
        boolean status = false;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from register where Email=? and Password=?");
            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                status = true;
            }
        }
        catch(Exception e){

        }
        return status;
    }

    public static boolean register(Register employee){
        boolean status = false;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into register values(?,?,?,?,?,?)");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPassword());
            statement.setString(4, employee.getGender());
            statement.setString(5, employee.getPhoneno());
            statement.setString(6, employee.getModule());

            int i = statement.executeUpdate();
            if(i > 0){
                status = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }
}
