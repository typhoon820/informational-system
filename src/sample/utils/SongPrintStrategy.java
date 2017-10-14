package sample.utils;

import com.jfoenix.controls.JFXTextField;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.Model.AbstractModel;
import sample.Model.Song;
import sample.Model.SongTemp;

/**
 * Created by Никита on 29.09.2017.
 */
public class SongPrintStrategy implements Strategy {
    @Override
    public void execute(GridPane gridPane, AbstractModel model) {

        Utils.adjustConstraints(gridPane,model);

        int fieldsCount = model.getClass().getDeclaredFields().length;
        JFXTextField [] textFields = new JFXTextField[2*fieldsCount];
        for (int i =0; i < textFields.length; i++){
            textFields[i] = new JFXTextField();
        }
        textFields[0].setText("Song Name");
        textFields[1].setText("Author name");
        textFields[2].setText("Genre");
        textFields[3].setText("Album");
        textFields[4].setText(((SongTemp) model).getSongName());
        textFields[5].setText(((SongTemp) model).getAuthor());
        textFields[6].setText(((SongTemp) model).getGenre());
        textFields[7].setText(((SongTemp) model).getAlbums().get(0));

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
            GridPane.setHalignment(textFields[i], HPos.CENTER);
        }

    }
}
