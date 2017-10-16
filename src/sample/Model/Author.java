package sample.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.annotations.Getter;

import java.util.ArrayList;
import java.util.List;

public class Author extends AbstractModel {
    private SimpleIntegerProperty id;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty specialization;
    private SimpleStringProperty currentBand;
    private List<String> previousBands;


    public Author(int id,
                  String firstname,
                  String lastname,
                  String specialization,
                  List<String> previousBands,
                  SimpleStringProperty currentBand) {
        this.id.set(id);
        this.firstname.set(firstname);
        this.lastname.set(lastname);
        this.specialization.set(specialization);
        this.previousBands = previousBands;
        this.currentBand = currentBand;
    }



    public Author() {
        id = new SimpleIntegerProperty();
        firstname = new SimpleStringProperty();
        lastname = new SimpleStringProperty();
        specialization = new SimpleStringProperty();
        currentBand = new SimpleStringProperty();

        previousBands = new ArrayList<>();
    }

    public int getId() {
        return id.get();
    }


    public void setId(int id) {
        this.id.set(id);
    }

    @Getter(num = 1)
    public String getFirstname() {
        return firstname.get();
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    @Getter(num = 2)
    public String getLastname() {
        return lastname.get();
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    @Getter(num = 3)
    public String getSpecialization() {
        return specialization.get();
    }

    public void setSpecialization(String specialization) {
        this.specialization.set(specialization);
    }

    @Getter(num = 4)
    public String getCurrentBand() {
        return currentBand.get();
    }

    public void setCurrentBand(String currentBand) {
        this.currentBand.set(currentBand);
    }

    @Getter(num = 5)
    public List<String> getPreviousBands() {
        return previousBands;
    }

    public void setPreviousBands(List<String> previousBands) {
        this.previousBands = previousBands;
    }
}
