package com.example.nalinbankfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import static com.example.nalinbankfx.InitializationWindowController.selectedUser;
import static com.example.nalinbankfx.Metods.openNewScene;

public class InfoWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButton;

    @FXML
    private ImageView coinImage;

    @FXML
    private ImageView coinImage1;

    @FXML
    private Button currencyСonverterButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button logBookButton;

    @FXML
    private Button newsButton;

    @FXML
    private Button paymentsButton;

    @FXML
    void initialize() {
        paymentsButton.setOnAction(event -> {
            paymentsButton.getScene().getWindow().hide();
            openNewScene("paymentsWindow.fxml");
        });

        currencyСonverterButton.setOnAction(event -> {
            currencyСonverterButton.getScene().getWindow().hide();
            openNewScene("currencyConverterWindow.fxml");
        });

        logBookButton.setOnAction(event -> {
            logBookButton.getScene().getWindow().hide();
            openNewScene("logBookWindow.fxml");
        });

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            openNewScene("mainWindow.fxml");
        });

        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            openNewScene("initializationWindow.fxml");
        });

    }

}
