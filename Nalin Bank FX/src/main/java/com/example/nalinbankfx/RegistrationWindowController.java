package com.example.nalinbankfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.nalinbankfx.Metods.openNewScene;

public class RegistrationWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button regButton;

    @FXML
    private CheckBox regCheckBoxFemale;

    @FXML
    private CheckBox regCheckBoxMale;

    @FXML
    private TextField regLogin;

    @FXML
    private TextField regMail;

    @FXML
    private TextField regName;

    @FXML
    private TextField regPassword;

    @FXML
    private TextField regSurname;

    @FXML
    void initialize() {
        regButton.setOnAction(event -> {

            signUpNewUser();

            regButton.getScene().getWindow().hide();

            openNewScene("initializationWindow.fxml");

        });
    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = regName.getText();
        String lastName = regSurname.getText();
        String userName = regLogin.getText();
        String password = regPassword.getText();
        String mail = regMail.getText();
        String gender = "";

        if(regCheckBoxMale.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName, lastName, userName, password, mail, gender);

        dbHandler.signUpUser(user);

    }

}
