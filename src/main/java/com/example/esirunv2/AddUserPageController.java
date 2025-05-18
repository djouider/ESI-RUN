package com.example.esirunv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class AddUserPageController {
    private AnchorPane anchorPane;

    /* To get the necessary fields from the user*/
    @FXML private TextField FirstName;
    @FXML private TextField LastName;
    @FXML private CheckBox Disabled;
    @FXML private DatePicker DateOfBirth;
    @FXML private CheckBox PassengerCheckBox;
    @FXML private CheckBox EmployeeCheckBox;
    @FXML private TextField IDNumberField;

    /* Handeling errors */
    @FXML private Label FirstNameError;
    @FXML private Label LastNameError;
    @FXML private Label DateOfBirthError;
    @FXML private Label IDNumberError;
    @FXML private Label TypeOfUserError;
    @FXML private Label RoleError;
    public void SwitchToHomePage() {

    }

    @FXML
    private ComboBox<String> RoleComboBox;  // Must match fx:id

    // List of choices
    private final ObservableList<String> Roles =
            FXCollections.observableArrayList(
                    "CONDUCTEUR",
                    "AGENT"
            );

    @FXML
    public void AddUser(ActionEvent actionEvent) throws IOException {

        /* getting the type of the user */
        String choice="";
        if (PassengerCheckBox.isSelected()) {
            choice = "Passenger";
            TypeOfUserError.setVisible(false);
            IDNumberError.setVisible(false);
        } else if (EmployeeCheckBox.isSelected()) {

            choice = "Employee";

            TypeOfUserError.setVisible(false);
            String IdNumber = IDNumberField.getText();
            if (IdNumber.isEmpty()){
                IDNumberError.setVisible(true);
                IdNumber = "";
            } else {
                IDNumberError.setVisible(false);
            }

            String Role = RoleComboBox.getValue();
            if (Role == null){
                RoleError.setVisible(true);
            } else {
                RoleError.setVisible(false);
            }

        } else {
            TypeOfUserError.setVisible(true);
        }

        /* getting the first name */
        String FirstName = this.FirstName.getText();
         if (FirstName.isEmpty()) {
             FirstNameError.setVisible(true);
             FirstName = "";
         } else {
             FirstNameError.setVisible(false);
         }

        /* getting the last name */
         String LastName = this.LastName.getText();
         if (LastName.isEmpty()) {
             LastNameError.setVisible(true);
         } else {
             LastNameError.setVisible(false);
         }

         boolean Disable = this.Disabled.isSelected();

        /* getting the date of birth */
         LocalDate DateofBirth = this.DateOfBirth.getValue();
         if (DateofBirth == null) {
             DateOfBirthError.setVisible(true);
             DateOfBirthError.setText("Enter the date of birth");
         } else {
             DateOfBirthError.setVisible(false);
         }



         System.out.println(FirstName + " " + LastName + " " + Disable + " " + DateofBirth);

    }

    @FXML
    public void Cancel(ActionEvent actionEvent) throws IOException {
        FirstName.clear();
        LastName.clear();
        Disabled.setSelected(false);
        DateOfBirth.setValue(null);
    }

    /*when checking the passenger checkbox*/
    public void AddPassenger(ActionEvent actionEvent) throws IOException {
        EmployeeCheckBox.setSelected(false);
        PassengerCheckBox.setSelected(true);
        IDNumberField.setVisible(false);
        IDNumberError.setVisible(false);
        RoleError.setVisible(false);
        RoleComboBox.setVisible(false);
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
    /*when checking the employee checkbox*/
    public void AddEmployee(ActionEvent actionEvent) throws IOException {
        PassengerCheckBox.setSelected(false);
        EmployeeCheckBox.setSelected(true);
        IDNumberField.setVisible(true);
        RoleComboBox.setVisible(true);
    }

    public void SwitchToFareManagement(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FareManagement.fxml"));
        if (root != null) {
            System.out.println("FareManagement.fxml not loaded");
        }
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        try {
            scene.getStylesheets().add(getClass().getResource(("/FareManagement.css")).toExternalForm());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("toExternalForm returned null");
        }
        stage.setScene(scene);
        stage.show();
    }

    /*Whene Starting*/
    @FXML
    public void initialize() {
        // Mutual exclusion via listeners
        IDNumberField.setVisible(false);
        IDNumberError.setVisible(false);
        FirstNameError.setVisible(false);
        LastNameError.setVisible(false);
        Disabled.setSelected(false);
        TypeOfUserError.setVisible(false);
        RoleError.setVisible(false);
        RoleComboBox.setItems(Roles);
        RoleComboBox.setVisible(false);
    }
}
