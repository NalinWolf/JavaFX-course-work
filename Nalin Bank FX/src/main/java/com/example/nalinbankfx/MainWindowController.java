package com.example.nalinbankfx;

import java.net.URL;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import static com.example.nalinbankfx.InitializationWindowController.selectedUser;
import static com.example.nalinbankfx.Metods.openNewScene;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button currencyСonverterButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button logBookButton;

    @FXML
    private Button newsButton;

    @FXML
    private Button paymentsButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField info;
    @FXML
    private TextField sum;
    @FXML
    private TextField moneyInf;
    @FXML
    private Button confirm;

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
        info.setText("Здравствуйте, уважаемый " + selectedUser.getFirstname()
                + " " + selectedUser.getLastName());
        moneyInf.setText("Ваш баланс "+selectedUser.getMoney());

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

        confirm.setOnAction(event -> {
            if(!sum.getText().equals("")){
                Double mon = Double.valueOf(sum.getText());
                selectedUser.setMoney(selectedUser.getMoney()+mon);
                DatabaseHandler dba = new DatabaseHandler();
                dba.updateMoney(selectedUser);
            }
            else {
                Shake sumAnim = new Shake(sum);
                sumAnim.playAnim();
            }
        });


    }

}
