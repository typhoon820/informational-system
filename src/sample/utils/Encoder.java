package sample.utils;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encoder {

    private static Encoder encoder;

    private BasicPasswordEncryptor encryptor;

    private Encoder(){
        initPasswordEncoder();
    }

    public static Encoder getInstance(){
        if (encoder == null){
            return new Encoder();
        }
        return encoder;
    }

    private void initPasswordEncoder(){
        encryptor = new BasicPasswordEncryptor();
    }

    public BasicPasswordEncryptor getMethods(){
        return encryptor;
    }
}
