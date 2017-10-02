package sample.utils;

import javafx.scene.layout.GridPane;
import sample.Model.AbstractModel;

/**
 * Created by Никита on 29.09.2017.
 */
public interface Strategy {
    void execute(GridPane gridPane, AbstractModel model);
}
