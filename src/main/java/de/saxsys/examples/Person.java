package de.saxsys.examples;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by steven.lehmann on 22.03.2016.
 */
public class Person {

    private StringProperty name = new SimpleStringProperty();
    private StringProperty preName = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();
    private StringProperty street = new SimpleStringProperty();
    private IntegerProperty age = new SimpleIntegerProperty();

    public Person(String name, String preName, String city, String street, int age) {
        this.name.set(name);
        this.preName.set(preName);
        this.city.set(city);
        this.street.set(street);
        this.age.set(age);
    }


    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty preNameProperty() {
        return preName;
    }

    public StringProperty cityProperty() {
        return city;
    }

    public StringProperty streetProperty() {
        return street;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

}
