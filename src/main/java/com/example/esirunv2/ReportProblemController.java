package com.example.esirunv2;

import com.example.esirunv2.core.*;
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
import java.time.LocalDate;

public class ReportProblemController {

    private Usager TestUsager1 = new Usager("Ali", "BenMohamed", LocalDate.of(2010, 5, 12), false);
    private Employe TestEmploye1 = new Employe("Ahmed", "Tahar", LocalDate.of(1980, 3, 25), false, "A123", TypeFonction.AGENT);
    private MoyenTransport bus1 = new MoyenTransport("BUS1");
    private Station station1= new Station("Oued Smar");

    @FXML private ComboBox<TypeReclamation> ComplaintType;
    @FXML private final ObservableList<TypeReclamation> complainttypes = FXCollections.observableArrayList( TypeReclamation.values() );
    @FXML private ComboBox<String> Reporter;
    @FXML private final ObservableList<String> reporters = FXCollections.observableArrayList(TestUsager1.toString(), TestEmploye1.toString());
    @FXML private ComboBox<String> CibleCB;
    @FXML private final ObservableList<String> suspendebles = FXCollections.observableArrayList(bus1.toString(),station1.toString());
    @FXML private TextField DescriptionField;

    @FXML private Label ComplaintTypeError;
    @FXML private Label ReporterError;
    @FXML private Label CibleCBError;
    @FXML private Label DescriptionError;
    @FXML private Label ComplaintSuccefulllLabel;

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

    @FXML
    public void initialize() throws IOException {
        ComplaintTypeError.setVisible(false);
        ReporterError.setVisible(false);
        CibleCBError.setVisible(false);
        DescriptionError.setVisible(false);
        ComplaintSuccefulllLabel.setVisible(false);
        ComplaintType.setItems(complainttypes);

        /* THE LOGIC TO ADD USERS TO reporters LIST AND THEN ADD IT TO Reporters*/
        Reporter.setItems(reporters);

        /* THE LOGIC TO ADD USERS TO cibles LIST AND THEN ADD IT TO Reporters*/
        CibleCB.setItems(suspendebles);
    }

    public void AddComplaint(ActionEvent event) throws IOException {
        DescriptionError.setVisible(false);
        Reclamation newReclamation;
        ComplaintSuccefulllLabel.setVisible(false);
        String reporter,cible;
        TypeReclamation type;
        Personne personne = null;

        if (ComplaintType.getValue() == null) {
            ComplaintTypeError.setVisible(true);
            type = null;
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

            /* SEARCH FOr THE PERSONNE WHO REPORTED (OR GET THE PERSONNE */
            personne = null;
        }

        if (CibleCB.getValue() == null) {
            CibleCBError.setVisible(true);
            cible = "";
        } else {
            CibleCBError.setVisible(false);
            cible = CibleCB.getValue();;
        }

        String description ;
        if ((DescriptionField.getText() == null) || (DescriptionField.getText().isEmpty())) {
            DescriptionError.setVisible(true);
            description = "";
        } else {
            description = DescriptionField.getText();
        }

        if (!ComplaintTypeError.isVisible() && !ReporterError.isVisible() && !CibleCBError.isVisible() && !description.isEmpty()) {
            ComplaintSuccefulllLabel.setVisible(true);

            /* Change cible so it returs suspenadble*/
            newReclamation = new Reclamation(personne,type,bus1,description,LocalDate.now());
        }
        System.out.println("type: "+type+" reporter: "+reporter+" cible: "+cible+" description: "+description);
    }

    public void Cancel(ActionEvent event) throws IOException {
        ComplaintType.setValue(null);
        ComplaintSuccefulllLabel.setVisible(false);
        DescriptionError.setVisible(false);
        Reporter.setValue(null);
        CibleCB.setValue(null);
        DescriptionField.clear();
        ComplaintTypeError.setVisible(false);
        ReporterError.setVisible(false);
        CibleCBError.setVisible(false);
    }
}

