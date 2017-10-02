package sample.utils;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sample.Model.AbstractModel;

/**
 * Created by Никита on 02.10.2017.
 */
public class LogoPringStrategy implements Strategy {
    @Override
    public void execute(GridPane gridPane, AbstractModel model) {
        Label startLabel = new Label("Detailed information of selected row will be provided here");
        startLabel.setFont(new Font("System", 24));
        startLabel.setTextFill(Color.ALICEBLUE);
        startLabel.setWrapText(true);
        startLabel.setTextAlignment(TextAlignment.CENTER);
        gridPane.add(startLabel,0 ,0);
    }
}
