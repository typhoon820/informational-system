package sample.DB;

import org.omg.CORBA.Object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Никита on 27.09.2017.
 */
public class Initializer {

    private String path;
    private static Properties prop = new Properties();
    Initializer(String path){
        this.path = path;
        try {
            prop.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String init(String name){
        return prop.getProperty(name);
    }

}
