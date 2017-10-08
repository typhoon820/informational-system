package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public class Author extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty specialization;
    private List<String> previousBands;
    private Band currentBand;


    public Author(int id,
                  String firstname,
                  String lastname,
                  String specialization,
                  List<String> previousBands,
                  Band currentBand) {
        this.id.set(id);
        this.firstname.set(firstname);
        this.lastname.set(lastname);
        this.specialization.set(specialization);
        this.previousBands = previousBands;
        this.currentBand = currentBand;
    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getSpecialization() {
        return specialization.get();
    }

    public void setSpecialization(String specialization) {
        this.specialization.set(specialization);
    }
}
