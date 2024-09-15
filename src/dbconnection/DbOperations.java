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

    public static boolean register(GetSetEmployee employee){
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
    

    public static ResultSet showAllEmployeeData(){
        ResultSet rs = null;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from register where Module='Employee'");

            rs = statement.executeQuery();
        }
        catch(Exception e){
            e.getStackTrace();
        }
        return rs;
    }

    public static ResultSet getEmployeeData(String email){
        ResultSet rs = null;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from register where Email=?");
            statement.setString(1, email);

            rs = statement.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public static boolean updateEmployeeData(GetSetEmployee employee){
        boolean status = false;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update register set Name=?,Password=?,Gender=?,Phone_No=? where Email=?");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPassword());
            statement.setString(3, employee.getGender());
            statement.setString(4, employee.getPhoneno());
            statement.setString(5, employee.getEmail());

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

    public static boolean deleteEmployeeData(String email){
        boolean status = false;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from register where Email=?");
            statement.setString(1, email);

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

    public static ResultSet getAdminPassword(){
        ResultSet rs = null;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select Password from register where Email='admin@gmail.com'");
            rs = statement.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }

    public static boolean changeAdminPassword(String pwd){
        boolean status = false;
        try{
            Connection connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update register set Password=? where Email='admin@gmail.com'");
            statement.setString(1, pwd);

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
