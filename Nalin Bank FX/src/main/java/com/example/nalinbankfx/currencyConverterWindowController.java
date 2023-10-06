package com.example.nalinbankfx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import static com.example.nalinbankfx.InitializationWindowController.selectedUser;
import static com.example.nalinbankfx.Metods.openNewScene;

public class currencyConverterWindowController {

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
    private Button converterButton;

    @FXML
    private ComboBox<String> currency1;

    @FXML
    private ComboBox<String> currency2;

    @FXML
    private Button exitButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button logBookButton;

    @FXML
    private Button newsButton;

    @FXML
    private Button paymentsButton;

    @FXML
    private TextField value1;

    @FXML
    private TextField value2;

    ObservableList<String> text = FXCollections.observableArrayList("$","€","BYN","RUB");

    @FXML
    void initialize() {

        paymentsButton.setOnAction(event -> {
            paymentsButton.getScene().getWindow().hide();
            openNewScene("paymentsWindow.fxml");
        });

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            openNewScene("mainWindow.fxml");
        });

        logBookButton.setOnAction(event -> {
            logBookButton.getScene().getWindow().hide();
            openNewScene("logBookWindow.fxml");
        });

        infoButton.setOnAction(event -> {
            infoButton.getScene().getWindow().hide();
            openNewScene("infoWindow.fxml");
        });

        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            openNewScene("initializationWindow.fxml");
        });

        currency1.setItems(text);
        currency2.setItems(text);

        converterButton.setOnAction(event -> {


       if( !currency1.getValue().equals("") || !currency2.getValue().equals(""))
       {
           if(!value1.getText().equals(""))
           {
               double Money = Double.parseDouble(value1.getText());
              String valute1 = currency1.getValue();
               String valute2 = currency2.getValue();
               if (valute1.equals("$"))
                   Money = Money*2.74;
               else if (valute1.equals("€"))
               {
                   Money = Money*2.91;
               }
               else if (valute2.equals("RUB"))
               {
                   Money = Money*0.038;
               }
               if (valute2.equals("$"))
                   Money = Money*0.36536;
               else if (valute2.equals("€"))
               {
                   Money = Money*0.34318;
               }
               else if (valute2.equals("RUB"))
               {
                   Money = Money*26.33;
               }
               value2.setVisible(true);
               value2.setText(String.valueOf(Money));
           }
       }
        });
    }
}
