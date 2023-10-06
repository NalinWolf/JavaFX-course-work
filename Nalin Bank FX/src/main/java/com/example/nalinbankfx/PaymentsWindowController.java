package com.example.nalinbankfx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import static com.example.nalinbankfx.InitializationWindowController.selectedUser;
import static com.example.nalinbankfx.Metods.openNewScene;

public class PaymentsWindowController {

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
    private Button infoButton;

    @FXML
    private Button logBookButton;

    @FXML
    private Button newsButton;

    @FXML
    private TableColumn<payment, String> payments;

    @FXML
    private TableView<payment> paymentsTable;

    @FXML
    private TableColumn<payment, Double> sum;
    ObservableList<payment> payList = FXCollections.observableArrayList();

    @FXML
        void initialize() throws SQLException {
        updateTable();
            backButton.setOnAction(event -> {
                backButton.getScene().getWindow().hide();
                openNewScene("mainWindow.fxml");
            });

            currencyСonverterButton.setOnAction(event -> {
                currencyСonverterButton.getScene().getWindow().hide();
                openNewScene("currencyConverterWindow.fxml");
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

    }
    public void updateTable() throws SQLException {
        payList.clear();
        DatabaseHandler dbh = new DatabaseHandler();
        ResultSet rs = dbh.getPayment(selectedUser);
        while (rs.next()) {
            String name = rs.getString("userId");
            double sum = rs.getDouble("sum");
            payList.add(new payment(name, sum));
        }
        payments.setCellValueFactory(new PropertyValueFactory<>("name"));
        sum.setCellValueFactory(new PropertyValueFactory<>("sum"));

        paymentsTable.setItems(payList);

    }


}

