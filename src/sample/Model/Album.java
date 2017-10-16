package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.annotations.Getter;

import java.util.ArrayList;
import java.util.List;

public class Album extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private List<String> songsInAlbum;

    public Album(int id, String name, List<String> songsInAlbum) {
        this.id.set(id);
        this.name.set(name);
        this.songsInAlbum = songsInAlbum;
    }

    public Album() {
        id = new SimpleIntegerProperty();
        name = new SimpleStringProperty();
        this.songsInAlbum = new ArrayList<>();
    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    @Getter(num = 1)
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Getter (num = 2)
    public List<String> getSongsInAlbum() {
        return songsInAlbum;
    }

    public void setSongsInAlbum(List<String> songsInAlbum) {
        this.songsInAlbum = songsInAlbum;
    }
}
