package com.example.etc201731449;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Controller {
    public TextField prenom;
    public TextField nom;
    public DatePicker dob;
    public TextField email;
    private final Model model = new Model();
    public TextField identification;


    public void getPrenom(KeyEvent keyEvent) {
        if (prenom.getText().length() <= 3){
            model.modifIDPrenom(identification,prenom.getText());
        }
    }

    public void getNom(KeyEvent keyEvent) {
        if (nom.getText().length() <= 3){
            model.modifIDNom(identification,nom.getText());
        }
    }

    public void getDOB(KeyEvent keyEvent) {
        if (dob.getValue() != null){
            model.modifMonthYear(identification,dob.getValue());
        }
    }

    public void getEmail(KeyEvent keyEvent) {
    }
}
