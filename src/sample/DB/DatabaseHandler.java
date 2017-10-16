package sample.DB;


import com.mysql.jdbc.Driver;
import org.omg.PortableServer.POAManagerPackage.State;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sample.annotations.CastToInt;

import javax.management.Query;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;

public class DatabaseHandler {
    private static  DatabaseHandler handler = null;
    private static Initializer initializer = new Initializer("src/sample/config/config.properties");

    private static String DB_URL = initializer.init("url");
    private static String DRIVER = initializer.init("driver");
    private static String login = initializer.init("login");
    private static String password = initializer.init("password");
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    private DatabaseHandler(){
        createConnection();
    }
    //Singleton pattern
    public static DatabaseHandler getInstance(){
        if(handler == null){
            handler = new DatabaseHandler();
        }
        return handler;
    }

    public PreparedStatement createQuery(String sqlQuery){
        try {
            pstmt = connection.prepareStatement(sqlQuery);
            return pstmt;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    private void createConnection(){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL,login,password);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //TODO: fix a bit, 2nd param change to Object
    public ResultSet execPreparedQuery(String query, String param) {
        ResultSet resultSet;
        try{
            PreparedStatement prstm =connection.prepareStatement(query);
            try {
                prstm.setInt(1,Integer.valueOf(param));
            }
            catch (NumberFormatException e){
                prstm.setString(1,param);
            }
            resultSet = prstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet;
    }

    public void execCallableStatement(String procedureName, List<Object> args){
        String sqlCall = "{call " +procedureName+ "}";
        int i =1;
        try {
            CallableStatement cstmt = connection.prepareCall(sqlCall);
            for (Object o: args) {
                switch (o.getClass().getSimpleName()){
                    case "Integer":
                        cstmt.setInt(i,(Integer)o);
                        break;
                    case "String":
                        cstmt.setString(i,(String)o);
                        break;
                }
                i++;
            }
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public ResultSet execPreparedQuery(String query, int param){
        ResultSet resultSet;
        try{
            PreparedStatement prstm =connection.prepareStatement(query);
            prstm.setInt(1,param);
            resultSet = prstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet;
    }

    public ResultSet execQuery(String query){

        ResultSet resultSet;
        try{
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
        finally {
        }
        return resultSet;
    }

    public boolean execAction(String query){
        try{
            stmt = connection.createStatement();
            stmt.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
