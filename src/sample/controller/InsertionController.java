package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.DAO.GenreDAO;
import sample.Model.*;
import sample.utils.GenrePrintStrategy;
import sample.utils.Printer;
import sample.utils.Utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class InsertionController extends AbstractController implements Initializable {
    @FXML
    private VBox slideBox;

    @FXML
    private ComboBox<AbstractModel> comboBox;

    @FXML
    private GridPane insertionPane;

    @FXML
    private JFXButton addButton;
    List<Node> n = new ArrayList<>();


    AbstractModel model;

    Printer printer = new Printer();

    GenreDAO genreDAO = new GenreDAO();


    @FXML
    void addModel(ActionEvent event) {

        JFXTextField textField = (JFXTextField) insertionPane.getChildren().get(3);
        System.out.println(textField.getText());
        n.size();
        ((Genre)model).setName(textField.getText());
        genreDAO.persist((Genre) model);


    }

    @FXML
    void choseItem(ActionEvent event) {
        model = comboBox.getSelectionModel().getSelectedItem();
        Utils.adjustGrid(insertionPane, 2, model.getClass().getDeclaredFields().length);
        Utils.adjustConstraints(insertionPane, model);
        if(model.getClass().getSimpleName().equals("Genre")){
            printer.setStrategy(new GenrePrintStrategy());
            printer.print(insertionPane,model);
        }
        n = insertionPane.getChildren();
        System.out.println(1);


    }

    void prepareGrid(VBox box) {

        AbstractModel a;
        initModelList((ComboBox<AbstractModel>) box.getChildren().get(0));


    }

    void initModelList(ComboBox<AbstractModel> modelList) {
        ObservableList<AbstractModel> list = FXCollections.observableArrayList(new Album(),
                new Author(), new Band(), new CD(), new SongTemp(), new Genre());
        modelList.setItems(list);
        modelList.setItems(list);
        // modelList.set
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initModelList(comboBox);
    }
}
