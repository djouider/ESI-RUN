package com.example.esirunv2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

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
    public void SwitchToHomePage() {

    }

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

    public void AddPassenger(ActionEvent actionEvent) throws IOException {
        EmployeeCheckBox.setSelected(false);
        PassengerCheckBox.setSelected(true);
        IDNumberField.setVisible(false);
        IDNumberError.setVisible(false);

    }

    public void AddEmployee(ActionEvent actionEvent) throws IOException {
        PassengerCheckBox.setSelected(false);
        EmployeeCheckBox.setSelected(true);
        IDNumberField.setVisible(true);
    }
@FXML
public void initialize() {
    // Mutual exclusion via listeners
    IDNumberField.setVisible(false);
    IDNumberError.setVisible(false);
    FirstNameError.setVisible(false);
    LastNameError.setVisible(false);
    Disabled.setSelected(false);
    TypeOfUserError.setVisible(false);


}
}
