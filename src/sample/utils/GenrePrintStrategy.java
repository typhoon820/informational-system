package sample.utils;

import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Model.AbstractModel;
import sample.Model.Genre;
import sample.Model.SongTemp;

public class GenrePrintStrategy implements Strategy {
    @Override
    public void execute(GridPane gridPane, AbstractModel model) {

        Utils.adjustConstraints(gridPane,model);

        int fieldsCount = model.getClass().getDeclaredFields().length;
        JFXTextField[] textFields = new JFXTextField[2*fieldsCount];
        for (int i =0; i < textFields.length; i++){
            textFields[i] = new JFXTextField();
        }
        textFields[0].setText("Genre");
        textFields[1].setText(((Genre) model).getName());

        for (int i =0; i < 2*fieldsCount; i++){
            textFields[i].setFont(new Font("System", 16));
            textFields[i].setStyle("-fx-text-fill: ALICEBLUE");
            textFields[i].setUnFocusColor(Color.ALICEBLUE);
            if (i < fieldsCount) {
                textFields[i].setEditable(false);
                gridPane.add(textFields[i],0, i);
            }
            else {
                textFields[i].setEditable(true);
                gridPane.add(textFields[i],1, i - fieldsCount);
            }
            //GridPane.setHalignment(textFields[i], HPos.CENTER);
        }

    }
}
