package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.lang.String;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sample.DAO.UserDAO;
import sample.DB.DatabaseHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Exceptions.NoUserFoundException;
import sample.Model.User;
import sample.utils.Encoder;
import sample.utils.Utils;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController extends AbstractController implements Initializable{


    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton cancelButton;

    private Encoder encoder;

//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private DatabaseHandler handler;
    private UserDAO userDAO;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getInstance();
        userDAO = new UserDAO();
        encoder = Encoder.getInstance();

    }

    @FXML
    void cancel(ActionEvent event) {
        closeStage();
        loadView("/sample/view/registration.fxml", false, "Registration");
    }

    @FXML
    void login(ActionEvent event) {

        String tLogin = login.getText();
        String pWord = password.getText();

        User loggingInUser = null;
        try {
            loggingInUser = userDAO.getByLogin(tLogin);
        }
        catch (NoUserFoundException e) {
            if (Utils.showWarningAlert("No user with such login").get() == ButtonType.OK) {
                login.setText("");
                password.setText("");
            }
            return;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        if (encoder.getMethods().checkPassword(password.getText(),loggingInUser.getPassword())){
            closeStage();
            loadView("/sample/view/menu.fxml", true, "Menu");
        }
        else {
            if (Utils.showWarningAlert("Password is incorrect").get() == ButtonType.OK) {
                login.setText("");
                password.setText("");
            }
        }
    }

    private void closeStage(){
        ((Stage)login.getScene().getWindow()).close();
    }




}
