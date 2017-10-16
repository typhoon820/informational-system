package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.annotations.Getter;

import java.util.ArrayList;
import java.util.List;

public class SongTemp extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty songName;
    private SimpleStringProperty author;
    private SimpleStringProperty genre;
    private List<String> albums;
    private SimpleIntegerProperty cds;
    private SimpleStringProperty version;

    public SongTemp(int id,
                    String songName,
                    String author,
                    String genre,
                    List<String> albums,
                    int cds,
                    String version) {
        this.id.set(id);
        this.songName.set(songName);
        this.author.set(author);
        this.genre.set(genre);
        this.albums = albums;
        this.cds.set(cds);
        this.version.set(version);
    }

    public SongTemp() {
        albums = new ArrayList<>();
        this.id = new SimpleIntegerProperty();
        this.songName = new SimpleStringProperty();
        this.author = new SimpleStringProperty();
        this.genre = new SimpleStringProperty();
        this.cds = new SimpleIntegerProperty();
        this.version = new SimpleStringProperty();
    }


    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Getter(num = 1)
    public String getSongName() {
        return songName.get();
    }


    public void setSongName(String songName) {
        this.songName.set(songName);
    }

    @Getter(num = 2)
    public String getAuthor() {
        return author.get();
    }


    public void setAuthor(String author) {
        this.author.set(author);
    }

    @Getter(num = 3)
    public String getGenre() {
        return genre.get();
    }


    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    @Getter(num = 4)
    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    @Getter(num = 5)
    public int getCds() {
        return cds.get();
    }

    public void setCds(int cds) {
        this.cds.set(cds);
    }

    @Getter(num = 6)
    public String getVersion() {
        return version.get();
    }

    public void setVersion(String version) {
        this.version.set(version);
    }
}
