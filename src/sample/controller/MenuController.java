package sample.controller;


import com.jfoenix.controls.JFXButton;
import java.lang.String;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.bcel.internal.classfile.Field;
import com.sun.rowset.internal.Row;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import org.omg.CORBA.Object;
import sample.DB.DatabaseHandler;
import sample.Model.AbstractModel;
import sample.Model.Song;
import sample.Model.Test;
import sample.utils.LogoPringStrategy;
import sample.utils.Printer;
import sample.utils.SongPrintStrategy;
import sample.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.function.BooleanSupplier;
import java.lang.reflect.Method;

public class MenuController implements Initializable {

    ObservableList<Song> songList = FXCollections.observableArrayList();

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
    private TableView<Song> songTable;
    @FXML
    private TableColumn<Song, String> songNameCol;

    @FXML
    private TableColumn<Song, String> authorCol;

    @FXML
    private TableColumn<Song, Integer> genreCol;

    @FXML
    private TableColumn<Song, Integer> albumCol;

    private Song currentSong;
    private AbstractModel model;
    DatabaseHandler handler;
    Printer printer = new Printer();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        loadData();
        startShowGridPane();
    }

    private void initCol(){
        songNameCol.setCellValueFactory(new PropertyValueFactory<>("songName"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        albumCol.setCellValueFactory(new PropertyValueFactory<>("ida"));
    }

    private void loadData(){
        handler = DatabaseHandler.getInstance();
        String query = "select id_song, song_name, name from songs_authors";
        ResultSet rs = handler.execQuery(query);
        try {
            while(rs.next()){
                int id = rs.getInt("id_song");
                String songName = rs.getString("song_name");
                String authorName = rs.getString("name");
                int ida = rs.getInt("id_song");
                songList.add(new Song(id,songName,authorName,ida));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        songTable.getItems().setAll(songList);

    }


    private void startShowGridPane(){
        gridPane.getChildren().clear();
        Utils.adjustConstraints(gridPane,new Test());
        Utils.adjustGrid(gridPane,1,1);
        printer.setStrategy(new LogoPringStrategy());
        printer.print(gridPane, null);

    }

    @FXML
    void printRowInfo(MouseEvent event) {
        model = songTable.getSelectionModel().getSelectedItem();
        gridPane.getChildren().clear();
        Utils.adjustConstraints(gridPane,model);
        Utils.adjustGrid(gridPane,2,4);
        printer.setStrategy(new SongPrintStrategy());
        printer.print(gridPane,model);

    }
    private void setColWidth(int index, double width){
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(width);
        gridPane.getColumnConstraints().set(index,col1);
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
}
