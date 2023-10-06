package com.example.nalinbankfx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import static com.example.nalinbankfx.InitializationWindowController.selectedUser;
import static com.example.nalinbankfx.Metods.openNewScene;

public class LogBookWindowController {

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
    private TableColumn<logBook, String> paymentColumn;
    @FXML
    private TableColumn<logBook, Integer> id;

    @FXML
    private TableView<logBook> table;
    @FXML
    private Button paymentsButton;
    @FXML
    private Button payButton;

    @FXML
    private TextField sumField;

    ObservableList<logBook> logList = FXCollections.observableArrayList();


    @FXML

        void initialize() throws SQLException {
            updateTable();

        paymentsButton.setOnAction(event -> {
            paymentsButton.getScene().getWindow().hide();
            openNewScene("paymentsWindow.fxml");
        });

        backButton.setOnAction(event -> {
            backButton.getScene().getWindow().hide();
            openNewScene("mainWindow.fxml");
        });

        currencyСonverterButton.setOnAction(event -> {
            currencyСonverterButton.getScene().getWindow().hide();
            openNewScene("currencyConverterWindow.fxml");
        });

        infoButton.setOnAction(event -> {
            infoButton.getScene().getWindow().hide();
            openNewScene("infoWindow.fxml");
        });

        exitButton.setOnAction(event -> {
            exitButton.getScene().getWindow().hide();
            openNewScene("initializationWindow.fxml");
        });

            payButton.setOnAction((event -> {
                if(!sumField.getText().equals("") && Double.valueOf(sumField.getText())<selectedUser.getMoney()) {
                    Double sum= Double.valueOf(sumField.getText());
                    logBook log = table.getSelectionModel().getSelectedItem();
                    if (log == null) {

                    } else {
                        DatabaseHandler dbha = new DatabaseHandler();
                        dbha.createEvent(log, selectedUser, sum);
                        selectedUser.setMoney(selectedUser.getMoney()-sum);
                        dbha.updateMoney(selectedUser);
                    }
                    try {
                        updateTable();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    Shake shakeField = new Shake(sumField);
                    shakeField.playAnim();
                }
            }));


        }
        public void updateTable() throws SQLException {
            logList.clear();
            DatabaseHandler dbh = new DatabaseHandler();
            ResultSet rs = dbh.getLog();
            while (rs.next()) {
                String name = rs.getString("paymentsname");

                int id = rs.getInt("id");
                logList.add(new logBook(id, name));
            }
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            paymentColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            table.setItems(logList);

        }

    }


