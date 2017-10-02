package sample.DB;


import com.mysql.jdbc.Driver;
import org.omg.PortableServer.POAManagerPackage.State;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;

public class DatabaseHandler {
    private static  DatabaseHandler handler = null;
    private static Initializer initializer = new Initializer("src/sample/config/config.properties");

    private static String DB_URL = initializer.init("url");
    private static String DRIVER = initializer.init("driver");
    private static String login = initializer.init("login");
    private static String password = initializer.init("password");
    private static Connection connection;
    private static Statement stmt;

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

    private void createConnection(){
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DB_URL,login,password);

        } catch (Exception e) {
            System.out.println(e);
        }
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
