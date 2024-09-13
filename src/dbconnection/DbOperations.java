package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
