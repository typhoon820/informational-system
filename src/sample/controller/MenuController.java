package sample.controller;


import com.jfoenix.controls.*;

import java.io.IOException;
import java.lang.String;

import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import sample.DAO.SongDAO;
import sample.DB.DatabaseHandler;
import sample.Exceptions.NoUserFoundException;
import sample.Model.*;
import sample.utils.PrintStrategies.LogoPringStrategy;
import sample.utils.Printer;
import sample.utils.PrintStrategies.SongPrintStrategy;
import sample.utils.Utils;

import java.net.URL;
import java.util.*;

public class MenuController implements Initializable {

    ObservableList<SongTemp> songList = FXCollections.observableArrayList();
    ObservableList<AbstractModel> modelList =  FXCollections.observableArrayList();

    private boolean sideGridPaneIsEmpty;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private TabPane mainTable;

    @FXML
    private Tab songTab;

    @FXML
    private Tab bandTab;

    @FXML
    private Tab cdTab;

    @FXML
    private AnchorPane secondPane;

    @FXML
    private JFXButton editButton;

    @FXML
    private JFXButton tempButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private TableView<SongTemp> songTable;
    @FXML
    private TableColumn<SongTemp, String> songNameCol;

    @FXML
    private TableColumn<SongTemp, String> authorCol;

    @FXML
    private TableColumn<SongTemp, Integer> genreCol;

    @FXML
    private TableColumn<SongTemp, Integer> albumCol;

    @FXML
    private JFXHamburger insertionHamberger;

    @FXML
    private JFXDrawer insertionDrawer;


    @FXML
    private JFXComboBox<AbstractModel> comboBox;

    @FXML
    private GridPane insertionPane;

    @FXML
    private JFXButton addButton;


    private SongTemp currentSong;
    private SongDAO songDAO;
    private AbstractModel model;
    DatabaseHandler handler;
    Printer printer = new Printer();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getInstance();
        songDAO = new SongDAO();
        initCol();
        loadData();
        startShowGridPane();
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/sample/view/insertionBar.fxml"));

            insertionDrawer.setSidePane(box);
            //CprepareGrid(box);


            HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(insertionHamberger);
            burgerTask.setRate(-1);
            insertionHamberger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
                burgerTask.setRate(burgerTask.getRate() * -1);
                burgerTask.play();

                if (insertionDrawer.isShown())
                    insertionDrawer.close();
                else
                    insertionDrawer.open();

            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void initCol() {
        songNameCol.setCellValueFactory(new PropertyValueFactory<>("songName"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre"));
        albumCol.setCellValueFactory(new PropertyValueFactory<>("albums"));
    }

    private void loadData() {
        try {
            List<SongTemp> songs = songDAO.getAll();
            for (SongTemp s : songs) {
                songList.add(s);
            }
            songTable.getItems().setAll(songList);
        } catch (NoUserFoundException e) {

        }
    }


    private void startShowGridPane() {
        gridPane.getChildren().clear();
        Utils.adjustConstraints(gridPane, new Test());
        Utils.adjustGrid(gridPane, 1, 1);
        printer.setStrategy(new LogoPringStrategy());
        printer.print(gridPane, null);

    }

    @FXML
    void printRowInfo(MouseEvent event) {
        model = songTable.getSelectionModel().getSelectedItem();
        gridPane.getChildren().clear();
        Utils.adjustConstraints(gridPane, model);
        Utils.adjustGrid(gridPane, 2, 4);
        printer.setStrategy(new SongPrintStrategy());
        printer.print(gridPane, model);

    }

    private void setColWidth(int index, double width) {
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(width);
        gridPane.getColumnConstraints().set(index, col1);
    }

    @FXML
    void showBands(ActionEvent event) {

    }

    @FXML
    void showCD(ActionEvent event) {

    }

    @FXML
    void showSongs(ActionEvent event) {
        loadData();
    }

    @FXML
    void editFields(ActionEvent event) {
        startShowGridPane();
    }

    void prepareGrid(VBox box){

        AbstractModel a;
        initModelList((JFXComboBox<AbstractModel>) box.getChildren().get(0));


    }

    void initModelList(JFXComboBox<AbstractModel> modelList){
        ObservableList<AbstractModel> list = FXCollections.observableArrayList( new Album(),
                new Author(), new Band(), new CD(), new SongTemp(), new Genre());
        modelList.setItems(list);
        modelList.setItems(list);
       // modelList.set
    }
}
