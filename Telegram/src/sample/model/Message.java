package sample.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Moskieva on 17.05.16.
 */
public class Message {
    private StringProperty telephone;
    private StringProperty message;


    public Message(String telephone, String message) {
        this.telephone = new SimpleStringProperty(telephone);
        this.message = new SimpleStringProperty(message);
    }

    public String getTelephone() {

        return telephone.get();
    }

    public StringProperty telephoneProperty() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone.set(telephone);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }
}
