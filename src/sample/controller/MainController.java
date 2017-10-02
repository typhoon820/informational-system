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
import javafx.stage.StageStyle;
import sample.DB.DatabaseHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable{


    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXButton cancelButton;

//    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    DatabaseHandler handler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getInstance();

    }


    @FXML
    void cancel(ActionEvent event) {
        login.setText("");
        password.setText("");
    }

    @FXML
    void login(ActionEvent event) {

        String tLogin = login.getText();
        String pWord = password.getText();
        System.out.println(tLogin+ "  "+ pWord);
        String query = "SELECT password from users where login='" + tLogin + "'";
        ResultSet rs = handler.execQuery(query);
        try {
            while (rs.next()){
                if (pWord.equals(rs.getString("password"))){
                    closeStage();
                    loadMenu();
//                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                    alert.setTitle("Success");
//                    alert.setHeaderText(null);
//                    alert.setContentText("You are successfully logged in");
//                    alert.show();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setContentText("Password is incorrect");
                    alert.setHeaderText("Warning");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeStage(){
        ((Stage)login.getScene().getWindow()).close();
    }

    private void loadMenu(){
        try{
            Parent parent = FXMLLoader.load(getClass().getResource("/sample/view/menu.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Menu");
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
