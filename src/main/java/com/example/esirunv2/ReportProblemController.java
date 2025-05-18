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
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ReportProblemController {

    @FXML private ComboBox<String> ComplaintType;
    @FXML private final ObservableList<String> complainttypes = FXCollections.observableArrayList("TECHNIQUE","SERVICE");
    @FXML private ComboBox<String> Reporter;
    @FXML private final ObservableList<String> reporters = FXCollections.observableArrayList("user1");
    @FXML private ComboBox<String> CibleCB;
    @FXML private final ObservableList<String> suspendebles = FXCollections.observableArrayList("bus1");
    @FXML private TextField DescriptionField;

    @FXML private Label ComplaintTypeError;
    @FXML private Label ReporterError;
    @FXML private Label CibleCBError;
    @FXML
    public void SwitchToAddUserPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddUserPage.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().add(getClass().getResource(("/AddUserPage.css")).toExternalForm());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("toExternalForm returned null in SwitchToAddUserPage ");
        }

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void initialize() throws IOException {
        ComplaintTypeError.setVisible(false);
        ReporterError.setVisible(false);
        CibleCBError.setVisible(false);
        ComplaintType.setItems(complainttypes);
        Reporter.setItems(reporters);
        CibleCB.setItems(suspendebles);
    }

    public void AddUser(ActionEvent event) throws IOException {

        String type,reporter,cible;
        if (ComplaintType.getValue() == null) {
            ComplaintTypeError.setVisible(true);
            type = "";
        } else {
            ComplaintTypeError.setVisible(false);
            type = ComplaintType.getValue();
        }

        if (Reporter.getValue() == null) {
            ReporterError.setVisible(true);
            reporter = "";
        } else {
            ReporterError.setVisible(false);
            reporter = Reporter.getValue();
        }

        if (CibleCB.getValue() == null) {
            CibleCBError.setVisible(true);
            cible = "";
        } else {
            CibleCBError.setVisible(false);
            cible = CibleCB.getValue();;
        }

        String description = DescriptionField.getText();
        if (description == null) {
            description = "";
        }

        System.out.println("type: "+type+" reporter: "+reporter+" cible: "+cible+" description: "+description);
    }

    public void Cancel(ActionEvent event) throws IOException {
        ComplaintType.setValue(null);
        Reporter.setValue(null);
        CibleCB.setValue(null);
        DescriptionField.clear();
        ComplaintTypeError.setVisible(false);
        ReporterError.setVisible(false);
        CibleCBError.setVisible(false);
    }
}

