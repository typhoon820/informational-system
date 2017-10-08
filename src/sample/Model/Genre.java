package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Genre extends AbstractModel{
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private List<String> songsOfGenre;

    public Genre(int id, String name, List<String> songsOfGenre) {
        this.id.set(id);
        this.name.set(name);
        this.songsOfGenre = songsOfGenre;
    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public List<String> getSongsOfGenre() {
        return songsOfGenre;
    }

    public void setSongsOfGenre(List<String> songsOfGenre) {
        this.songsOfGenre = songsOfGenre;
    }
}
