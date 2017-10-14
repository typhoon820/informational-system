package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class Band extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private List<String> songs;
    private List<String> currentArtists;
    private List<String> previousArtists;

    public Band(int id, String name, List<String> songs,
                List<String> currentArtists, List<String> previousArtists) {
        this.id.set(id);
        this.name.set(name);
        this.songs = songs;
        this.currentArtists = currentArtists;
        this.previousArtists = previousArtists;
    }

    public Band() {
        songs = new ArrayList<>();
        previousArtists = new ArrayList<>();
        currentArtists = new ArrayList<>();
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

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}
