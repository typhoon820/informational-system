package sample.utils;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import sample.Model.AbstractModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Utils {

    public static void adjustConstraints(GridPane gridPane, AbstractModel model){
        int difference =model.getClass().getDeclaredFields().length - gridPane.getRowConstraints().size() ;
        if (difference >0){
            for (int i =0; i < difference; i++){
                RowConstraints rc = new RowConstraints();
                gridPane.getRowConstraints().add(rc);
            }
        }
        else {
            for(int i = gridPane.getRowConstraints().size()-1; i>=model.getClass().getDeclaredFields().length; --i){
                gridPane.getRowConstraints().remove(i);
            }
        }
    }

    public static void adjustGrid(GridPane gridPane,int cols, int rows){

        for (ColumnConstraints colConstr:gridPane.getColumnConstraints()) {
            colConstr.setPercentWidth(0);
        }

        for(int i =0; i < cols; ++i){
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0/cols);
            gridPane.getColumnConstraints().set(i,colConst);

        }

        for(int i = 0; i < rows; ++i){
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0/rows);
            gridPane.getRowConstraints().set(i,rowConst);
        }
    }

    public static Optional<ButtonType> showWarningAlert(String text){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(text);
        alert.setHeaderText("Warning");
        return alert.showAndWait();
    }

    public static Optional<ButtonType> showSuccessAlert(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(text);
        alert.setHeaderText("Success");
        return alert.showAndWait();
    }

    public static String makeStringBeautiful(String uglyString){
        StringBuffer res = new StringBuffer(uglyString);
        int count =1;
        for (int i: findAllCApitalLetters(uglyString)) {
            res.insert(i+count-1, " ");
            res.replace(i+count,i+count+1, res.substring(i+count, i+count+1).toLowerCase());
            count++;
        }
        res.replace(0,1,res.substring(0,1).toUpperCase());
        return res.toString();
    }
    private static List<Integer> findAllCApitalLetters (String s){
        List<Integer> res = new ArrayList<>();
        for (int i =0; i < s.length(); i++){
            if (Character.isUpperCase(s.charAt(i))){
                res.add(i);
            }
        }
        return res;
    }
}
