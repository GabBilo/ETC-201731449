package com.example.etc201731449;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Model {

    private String firstName;
    private String lastName;
    private String month;
    private String year;
    private List<Departement> list = new ArrayList<>();

    public Model(ListView<Departement> inclus) {
        this.firstName = "";
        this.lastName = "";
        this.month = "";
        this.year = "";
        this.fillList();
        this.fillInclus(inclus);
    }

    public void fillList(){
        list.add(new Departement(1,"Administration"));
        list.add(new Departement(2,"Ressources humaine"));
        list.add(new Departement(3,"Marketing"));
        list.add(new Departement(4,"Logistique"));
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

    public void fillInclus(ListView<Departement> listView){
        listView.setCellFactory(param -> new ListCell<Departement>(){
            @Override
            protected void updateItem(Departement item, boolean empty){
                super.updateItem(item,empty);

                if (empty || item == null || item.getName() == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
    }
}
