package com.example.esirunv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class FareManagementController {

    @FXML StackPane Background;
    @FXML AnchorPane AddTitleCard;
    @FXML Label Price;

    @FXML private ComboBox<String> TypeOfCard;
    @FXML private Label TypeOfUserLabel;
    @FXML private Label IDNumberfieldLable;
    @FXML private ComboBox<String> Paiment;
    @FXML private ComboBox<String> TypeOfUser;
    @FXML private final ObservableList<String> cards = FXCollections.observableArrayList("ticket","Personal navigation card");
    @FXML private final ObservableList<String> paiments = FXCollections.observableArrayList("espèces","Dahabia","BaridiMob");
    @FXML private final ObservableList<String> TypeUsers = FXCollections.observableArrayList("Passenger","Employee");
    @FXML private TextField IDNumberfield;

    /* Error handling*/
    @FXML private Label TypeOfCardError;
    @FXML private Label PaimentError;
    @FXML private Label TypeOfUserError;
    @FXML private Label IDNumberfieldError;

    public void SwitchToAddUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddUserPage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().add(getClass().getResource(("/AddUserPage.css")).toExternalForm());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("toExternalForm returned null");
        }

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void addNewTitleCard(ActionEvent event) throws IOException {
        AddTitleCard.setVisible(true);
        Background.setVisible(true);
        Background.setEffect(new DropShadow(10, Color.BLACK));
        TypeOfUserLabel.setVisible(false);
        TypeOfUser.setVisible(false);
        IDNumberfield.setVisible(false);
        IDNumberfieldLable.setVisible(false);
    }

    public void SwitchToReportProblem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ReportProblemPage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().add(getClass().getResource(("/SideBarCss.css")).toExternalForm());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("toExternalForm returned null");
        }
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() {
        Background.setVisible(false);
        AddTitleCard.setVisible(false);
        Paiment.setItems(paiments);
        TypeOfCard.setItems(cards);
        TypeOfUser.setItems(TypeUsers);
        TypeOfCardError.setVisible(false);
        PaimentError.setVisible(false);
        TypeOfUserError.setVisible(false);
        IDNumberfieldError.setVisible(false);
    }

    @FXML
    public void TitleChoice(ActionEvent event) throws IOException {
        String choice = TypeOfCard.getValue();
        int price;
        if (choice != null) {
            if (choice.equals("ticket")) {
                price = 50;
                Price.setText(Price.getText()+" "+price+" Da");
                TypeOfUser.setVisible(false);
                IDNumberfield.setVisible(false);
                TypeOfUserLabel.setVisible(false);
                IDNumberfieldLable.setVisible(false);
            } else {
                TypeOfUser.setVisible(true);
                IDNumberfield.setVisible(true);
                TypeOfUserLabel.setVisible(true);
                IDNumberfieldLable.setVisible(true);
                /* Here there should be treatement to get the price*/
                Price.setText("Price :");
            }
        }
    }

    @FXML
    public void AddCard(ActionEvent event) throws IOException {
        String choiceCard = TypeOfCard.getValue();
        if (choiceCard == null) {
            TypeOfCardError.setVisible(true);
        } else {
            TypeOfCardError.setVisible(false);
            if (choiceCard.equals("Personal navigation card")) {
                String choiceTypeUser = TypeOfUser.getValue();
                if (choiceTypeUser == null) {
                    TypeOfUserError.setVisible(true);
                } else {
                    TypeOfUserError.setVisible(false);
                }

                String choiceIDNumber = IDNumberfield.getText();
                if (choiceIDNumber == null) {
                    IDNumberfieldError.setVisible(true);
                } else {
                    IDNumberfieldError.setVisible(false);
                }
            }
            Cancel(new ActionEvent());
        }

        String choicePaiment = Paiment.getValue();
        if (choicePaiment == null) {
            PaimentError.setVisible(true);
        } else {
            PaimentError.setVisible(false);
        }
    }

    @FXML
    public void Cancel(ActionEvent event) {
        AddTitleCard.setVisible(false);
        Background.setVisible(false);
        IDNumberfield.clear();
        TypeOfCard.setValue(null);
        Paiment.setValue(null);
        TypeOfUser.setValue(null);
        TypeOfCardError.setVisible(false);
        PaimentError.setVisible(false);
        TypeOfUserError.setVisible(false);
        IDNumberfieldError.setVisible(false);
        Price.setText("Price :");
    }
}
