package com.example.etc201731449;

import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        if (lastName.equals("") && month.equals("") && year.equals("")){
            identification.setText(prenom.toLowerCase());
        } else if(month.equals("") && year.equals("")){
            identification.setText(lastName + "-" + prenom.toLowerCase());
        } else {
            identification.setText(lastName + "-" + prenom.toLowerCase() + "-" + month + "-" + year);
        }
    }

    public void modifIDNom(TextField identification, String nom){
        lastName = nom.toLowerCase();
        if (firstName.equals("") && month.equals("") && year.equals("")){
            identification.setText(nom.toLowerCase());
        } else if(month.equals("") && year.equals("")){
            identification.setText(nom.toLowerCase() + "-" + firstName);
        } else {
            identification.setText(nom.toLowerCase() + "-" + firstName + "-" + month + "-" + year);
        }
    }

    public void modifMonthYear(TextField identification, LocalDate dob){
        month = Integer.toString(dob.getMonthValue());
        DateFormat df = new SimpleDateFormat("yy");
        year = df.format(dob.getYear());


        if (firstName.equals("") && lastName.equals("")){
            identification.setText(month + "-" + year );
        } else if(lastName.equals("")){
            identification.setText(firstName + "-" + month + "-" + year);
        } else if(firstName.equals("")) {
            identification.setText(lastName + "-" + month + "-" + year);
        } else {
            identification.setText(lastName + "-" + firstName + "-" + month + "-" + year);
        }
    }
}
