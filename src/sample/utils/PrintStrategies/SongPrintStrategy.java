package sample.utils.PrintStrategies;

import com.jfoenix.controls.JFXTextField;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Model.AbstractModel;
import sample.Model.SongTemp;
import sample.utils.Utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Никита on 29.09.2017.
 */
public class SongPrintStrategy implements Strategy {
    @Override
    public void execute(GridPane gridPane, AbstractModel model) {
        Utils.adjustConstraints(gridPane, model);
        Utils.setTextFieldsData(gridPane, model);
    }
}


