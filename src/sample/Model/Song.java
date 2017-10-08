package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Никита on 28.09.2017.
 */
public class Song extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty songName;
    private SimpleStringProperty authorName;
    private SimpleIntegerProperty ida;

    public Song() {

    }

    public int getIda() {
        return ida.get();
    }
    public void print(){
        System.out.println(id.get()+" "+songName.get());
    }

    public Song(Integer id, String songName, String authorName, Integer ida) {
        this.id =  new SimpleIntegerProperty(id);
        this.songName = new SimpleStringProperty(songName);
        this.authorName = new SimpleStringProperty(authorName);
        this.ida = new SimpleIntegerProperty(ida);
    }

    public Integer getId() {
        return id.get();
    }

    public String getSongName() {
        return songName.get();
    }


    public String getAuthorName() {
        return authorName.get();
    }

}
