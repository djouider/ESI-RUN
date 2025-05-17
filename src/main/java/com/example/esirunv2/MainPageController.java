package com.example.esirunv2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    @FXML
    private Label welcomeText;

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
}