package com.example.esirunv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class FareManagementController {

    @FXML Region Background;
    @FXML
    AnchorPane AddTitleCard;

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
    public void addTitleCard(ActionEvent event) throws IOException {
        AddTitleCard.setVisible(true);
        Background.setVisible(true);
    }

    @FXML
    public void initialize() {
        Background.setVisible(false);
        AddTitleCard.setVisible(false);
    }
}
