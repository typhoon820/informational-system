package sample.utils.PrintStrategies;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Model.AbstractModel;
import sample.Model.Genre;
import sample.utils.Utils;

import java.lang.reflect.Method;
import java.util.List;

public class GenrePrintStrategy implements Strategy {
    @Override
    public void execute(GridPane gridPane, AbstractModel model) {

        Utils.adjustConstraints(gridPane,model);
        Utils.setTextFieldsData(gridPane,model);


    }
}
