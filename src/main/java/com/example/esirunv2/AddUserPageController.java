package com.example.esirunv2;

import com.example.esirunv2.core.Employe;
import com.example.esirunv2.core.Personne;
import com.example.esirunv2.core.TypeFonction;
import com.example.esirunv2.core.Usager;
import javafx.application.Platform;
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
    @FXML private Label UserCreationSuccesLabel;
    public void SwitchToHomePage() {

    }
    @FXML private ComboBox<String> RegisterdUsers;
    @FXML private ObservableList<String> RegisterdUsersList = FXCollections.observableArrayList();
    @FXML
    private ComboBox<TypeFonction> RoleComboBox;  // Must match fx:id

    // List of choices
    private final ObservableList<TypeFonction> Roles =
            FXCollections.observableArrayList(
                    TypeFonction.values()
            );

    /*Whene Starting*/
    @FXML
    public void initialize() {
        // Mutual exclusion via listeners
        /* LOGIC TO ADD REGISTERD USERS INTO THIS ARRAY RegisterdUsersList
         * RegisterdUsers.setItems(RegisterdUsersList);
         * */
        IDNumberField.setVisible(false);
        IDNumberError.setVisible(false);
        FirstNameError.setVisible(false);
        LastNameError.setVisible(false);
        Disabled.setSelected(false);
        TypeOfUserError.setVisible(false);
        RoleError.setVisible(false);
        RoleComboBox.setItems(Roles);
        RoleComboBox.setVisible(false);
        UserCreationSuccesLabel.setText("Usre created Succefully");
        UserCreationSuccesLabel.setStyle("-fx-text-fill: Green;");
        UserCreationSuccesLabel.setVisible(false);
    }

    @FXML
    public void AddUser(ActionEvent actionEvent) throws IOException {
        Employe newEmploy = new Employe();
        Usager newUsager = new Usager();
        Personne newPerson = newUsager;
        boolean AllFieldsFilled = false;
        boolean AlReadyExists = false;
        /* getting the type of the user */
        UserCreationSuccesLabel.setText("Usre created Succefully");
        UserCreationSuccesLabel.setStyle("-fx-text-fill: Green;");
        UserCreationSuccesLabel.setVisible(false);
        String choice="";
        if (PassengerCheckBox.isSelected()) {
            choice = "Passenger";
            newPerson = newUsager;
            AllFieldsFilled = true;
            TypeOfUserError.setVisible(false);
            IDNumberError.setVisible(false);
        } else if (EmployeeCheckBox.isSelected()) {

            choice = "Employee";
            AllFieldsFilled = true;
            newPerson = newEmploy;
            TypeOfUserError.setVisible(false);
            String IdNumber;
            if (IDNumberField.getText().isEmpty()){
                IDNumberError.setVisible(true);
                IdNumber = "";
            } else {
                IDNumberError.setVisible(false);
                IdNumber = IDNumberField.getText();
            }

            TypeFonction Role = RoleComboBox.getValue();
            if (Role == null){
                RoleError.setVisible(true);
            } else {
                RoleError.setVisible(false);
                Role = RoleComboBox.getValue();
            }

           newPerson  = new Employe(IdNumber,Role);

        } else {
            TypeOfUserError.setVisible(true);
        }

        /* getting the first name */
        String FirstName;
         if (this.FirstName.getText().isEmpty()) {
             FirstNameError.setVisible(true);
             FirstName = "";
         } else {
             FirstNameError.setVisible(false);
             FirstName = this.FirstName.getText();
         }

        /* getting the last name */
         String LastName ;
         if (this.LastName.getText().isEmpty()) {
             LastNameError.setVisible(true);
             LastName = "";
         } else {
             LastNameError.setVisible(false);
             LastName = this.LastName.getText();
         }

         boolean Disable = this.Disabled.isSelected();

        /* getting the date of birth */
         LocalDate DateofBirth ;
         if (this.DateOfBirth.getValue() == null) {
             DateOfBirthError.setVisible(true);
             DateOfBirthError.setText("Enter the date of birth");
             DateofBirth = null;
         } else {
             DateOfBirthError.setVisible(false);
             DateofBirth = this.DateOfBirth.getValue();
         }

         if (!choice.equals("")){
             try {
                 newPerson.SetFields(FirstName, LastName, DateofBirth, Disable);
             }  catch (NullPointerException e) {
                 System.out.println(e.getMessage());
                 System.out.println("SetFields returned null");
             }
         }

         if (!this.FirstName.getText().isEmpty() && !this.LastName.getText().isEmpty() && DateOfBirth != null && !choice.isEmpty()) {
             /* DO SEARCH IF AN ACCOUNT EXITS OR NOT AND RETURN THE RESULT IN AlReadyExists*/
//             if (AlReadyExists) {
//                 UserCreationSuccesLabel.setVisible(true);
//                 UserCreationSuccesLabel.setText("User Already Exists");
//                 UserCreationSuccesLabel.setStyle("-fx-text-fill: red;");
//                 return;
//             }
             if (choice.equals("Employee")){
                 if (!IDNumberField.getText().isEmpty() && RoleComboBox.getValue() != null) {
                     UserCreationSuccesLabel.setVisible(true);
                 }
             }else {
                 UserCreationSuccesLabel.setVisible(true);
             }
         }

         System.out.println(FirstName + " " + LastName + " " + Disable + " " + DateofBirth);

    }

    @FXML
    public void Cancel(ActionEvent actionEvent) throws IOException {
        FirstName.clear();
        LastName.clear();
        Disabled.setSelected(false);
        DateOfBirth.setValue(null);
        IDNumberError.setVisible(false);
        TypeOfUserError.setVisible(false);
        RoleError.setVisible(false);
        UserCreationSuccesLabel.setText("Usre created Succefully");
        UserCreationSuccesLabel.setStyle("-fx-text-fill: Green;");
        UserCreationSuccesLabel.setVisible(false);
        FirstNameError.setVisible(false);
        LastNameError.setVisible(false);
        RoleComboBox.setValue(null);
        IDNumberField.clear();
    }

    @FXML public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
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

}
