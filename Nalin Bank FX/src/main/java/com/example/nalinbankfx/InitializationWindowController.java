package com.example.nalinbankfx;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static com.example.nalinbankfx.Metods.openNewScene;

public class InitializationWindowController {
    static User selectedUser;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    void initialize() {

        authSignInButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals("")) {
                authSignInButton.getScene().getWindow().hide();

                try {
                    loginUser(loginText, loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else{
                Shake userLoginAnim = new Shake(login_field);
                Shake userPassAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
        });

        loginSignUpButton.setOnAction(event -> {
            openNewScene("registrationWindow.fxml");
        });
    }

    private void loginUser(String loginText, String loginPassword) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true) {
            try {
                if (!result.next())
                {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            double money = result.getDouble("balance");
            String name = result.getString("firstname");
            String surName = result.getString("lastname");
            int usID = result.getInt("ac_no");
            user.setMoney(money);
            user.setFirstname(name);
            user.setLastName(surName);
            user.setId(usID);
            counter++;
        }

        if (counter >= 1) {
            selectedUser = user;
            openNewScene("mainWindow.fxml");
        }
        else {
                Shake userLoginAnim = new Shake(login_field);
                Shake userPassAnim = new Shake(password_field);
                userLoginAnim.playAnim();
                userPassAnim.playAnim();
            }
    }

}
