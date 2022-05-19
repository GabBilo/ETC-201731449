package com.example.etc201731449;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class Model {

    private String firstName;
    private String lastName;
    private String month;
    private String year;

    public Model() {
        this.firstName = "";
        this.lastName = "";
        this.month = "";
        this.year = "";
    }

    public void modifIDPrenom(TextField identification, String prenom){
        firstName = prenom.toLowerCase();
        identification.setText(lastName + "-" + prenom.toLowerCase() + "-" + month + "-" + year);
    }

    public void modifIDNom(TextField identification, String nom){
        lastName = nom.toLowerCase();
        identification.setText(nom.toLowerCase() + "-" + firstName + "-" + month + "-" + year);
    }

    public void modifMonthYear(TextField identification, LocalDate dob){
        if (dob.getMonthValue() < 10){
            month = "0" + Integer.toString(dob.getMonthValue());
        } else {
            month = Integer.toString(dob.getMonthValue());
        }
        year = Integer.toString(dob.getYear()).substring(2);
        identification.setText(lastName + "-" + firstName + "-" + month + "-" + year);
    }

    public void checkEmail(String email, ImageView imageView) throws FileNotFoundException {
        Image imageIncorrect = new Image(new FileInputStream("src/main/resources/com/example/etc201731449/image/email_invalid.png"));
        Image imageCorect = new Image(new FileInputStream("src/main/resources/com/example/etc201731449/image/email_valid.png"));
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (email.matches(regex)){
            imageView.setImage(imageCorect);
        } else {
            imageView.setImage(imageIncorrect);
        }
    }

    public void writeResult(String id, String fullFirstName, String fullLastName, String dob, String mail){
        System.out.println("Identification : " + id +
                "\nPrénom : " + fullFirstName +
                "\nNom : " + fullLastName +
                "\nDate de naissance : " + dob +
                "\nCourriel : " + mail +
                "\nDépartements : ");
    }
}
