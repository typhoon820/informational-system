package sample.controller;

import com.jfoenix.controls.JFXButton;
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
import sample.utils.ModelDispatcher;
import sample.utils.PrintStrategies.GenrePrintStrategy;
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
    private List<Node> n = new ArrayList<>();


    private AbstractModel model;

    private Printer printer = new Printer();

    private GenreDAO genreDAO = new GenreDAO();

    private ModelDispatcher modelDispatcher = new ModelDispatcher();


    @FXML
    void addModel(ActionEvent event) {

        //FXTextField textField = (JFXTextField) insertionPane.getChildren().get(3);
       // System.out.println(textField.getText());
        //n.size();
//        Utils.getMethods(model);
//        ((Genre) model).setName(textField.getText());
//        genreDAO.persist((Genre) model);
        //System.out.println(((SongTemp) model).getAuthor());


    }

    @FXML
    void choseItem(ActionEvent event) {
        insertionPane.getChildren().clear();
        model = comboBox.getSelectionModel().getSelectedItem();
        Utils.adjustConstraints(insertionPane, model);
        Utils.adjustGrid(insertionPane, 2, model.getClass().getDeclaredFields().length);
        Utils.setTextFieldsData(insertionPane,model);
    }

    void prepareGrid(VBox box) {

        AbstractModel a;
        initModelList((ComboBox<AbstractModel>) box.getChildren().get(0));


    }

    private void initModelList(ComboBox<AbstractModel> modelList) {
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
