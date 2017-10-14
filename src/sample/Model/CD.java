package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class CD extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty copiesAvailable;
    private List<String> songsOnCd;

    public CD(int id, int copiesAvailable, List<String> songsOnCd) {
        this.id.set(id);
        this.copiesAvailable.set(id);
        this.songsOnCd = songsOnCd;
    }

    public CD() {
        songsOnCd = new ArrayList<>();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getCopiesAvailable() {
        return copiesAvailable.get();
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable.set(copiesAvailable);
    }

    public List<String> getSongsOnCd() {
        return songsOnCd;
    }

    public void setSongsOnCd(List<String> songsOnCd) {
        this.songsOnCd = songsOnCd;
    }
}
