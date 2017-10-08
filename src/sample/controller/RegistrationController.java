package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import sample.DAO.UserDAO;
import sample.DB.DatabaseHandler;
import sample.Exceptions.NoUserFoundException;
import sample.Model.User;
import sample.utils.Encoder;
import sample.utils.Utils;
import org.jasypt.*;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegistrationController extends AbstractController implements Initializable {

    private DatabaseHandler handler;

    private Encoder encoder;
    private UserDAO userDAO;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handler = DatabaseHandler.getInstance();
        userDAO = new UserDAO();
        encoder = Encoder.getInstance();
    }



    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField repeatedPassword;

    @FXML
    private JFXButton regButton;

    @FXML
    private JFXButton cancelButton;

    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        try {
            userDAO.getByLogin(login.getText());
            if (Utils.showWarningAlert("Login is already in use").get() == ButtonType.OK) {
                login.setText("");
                password.setText("");
                repeatedPassword.setText("");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (NoUserFoundException e) {
            if (password.getText().equals(repeatedPassword.getText())) {
                User user = new User(login.getText(),
                        encoder.getMethods().encryptPassword(password.getText()),
                        "User");
                userDAO.persist(user);
                if (Utils.showSuccessAlert("You have been registered successfully").get() == ButtonType.OK){
                    closeStage();
                    loadView("/sample/view/sample.fxml", false, "login");
                }

            } else {
                if (Utils.showWarningAlert("Passwords do not match").get() == ButtonType.OK) {
                    password.setText("");
                    repeatedPassword.setText("");
                }
            }

        }
    }

    private void closeStage(){
        ((Stage)login.getScene().getWindow()).close();
    }
}
