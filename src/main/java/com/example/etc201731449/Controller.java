package com.example.etc201731449;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.FileNotFoundException;
import java.util.List;

public class Controller {
    public TextField prenom;
    public TextField nom;
    public DatePicker dob;
    public TextField email;
    public TextField identification;
    public Button valider;
    public ImageView imageCheck;
    public ListView<Departement> inclus = new ListView<>();
    public ListView<Departement> exclus;
    private final Model model = new Model(inclus);

    public void getPrenom(KeyEvent keyEvent) {
        if (prenom.getText().length() <= 3){
            model.modifIDPrenom(identification,prenom.getText());
        }
        updateBouton();
    }

    public void getNom(KeyEvent keyEvent) {
        if (nom.getText().length() <= 3){
            model.modifIDNom(identification,nom.getText());
        }
        updateBouton();
    }

    public void getDOB(KeyEvent keyEvent) {
        if (dob.getValue() != null){
            model.modifMonthYear(identification,dob.getValue());
        }
        updateBouton();
    }

    public void getEmail(KeyEvent keyEvent) throws FileNotFoundException {
        model.checkEmail(email.getText(),imageCheck);
    }

    public void getDOBMouse(MouseEvent mouseEvent) {
        if (dob.getValue() != null){
            model.modifMonthYear(identification,dob.getValue());
        }
        updateBouton();
    }

    public void updateBouton(){
        if (identification.getText().length() == 13){
            valider.setDisable(false);
        } else {
            valider.setDisable(true);
        }
    }

    public void clickValider(ActionEvent actionEvent) {
        model.writeResult(identification.getText(),prenom.getText(),nom.getText(),dob.getValue().toString(),email.getText());
    }

}
