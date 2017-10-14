package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class SongTemp extends AbstractModel{
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
//        this.id.set(0);
//        this.songName.set("");
//        this.author.set("");
//        this.genre.set("");
//        this.cds.set(0);
//        this.version.set("");
    }

    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }

    public String getSongName() {
        return songName.get();
    }


    public void setSongName(String songName) {
        this.songName.set(songName);
    }

    public String getAuthor() {
        return author.get();
    }


    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getGenre() {
        return genre.get();
    }


    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public List<String> getAlbums() {
        return albums;
    }

    public void setAlbums(List<String> albums) {
        this.albums = albums;
    }

    public int getCds() {
        return cds.get();
    }

    public void setCds(int cds) {
        this.cds.set(cds);
    }

    public String getVersion() {
        return version.get();
    }

    public void setVersion(String version) {
        this.version.set(version);
    }
}
