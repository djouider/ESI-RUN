package com.example.esirunv2;

import javafx.application.Platform;
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

    /* To Switch the the add user page*/
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

    public void SwitchToValidateFarePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ValidateFarePage.fxml"));
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

    @FXML public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}