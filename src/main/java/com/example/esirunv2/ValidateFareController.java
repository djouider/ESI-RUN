package com.example.esirunv2;

import com.example.esirunv2.core.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ValidateFareController {

    @FXML private AnchorPane EnterCardIDnumberAnchor;
    @FXML private AnchorPane SelectfromexistincardsAnchor;

    @FXML private ComboBox<String> TypeOfCard;
    @FXML private ComboBox<String> SelectExistingCards;
    @FXML private TextField CardIDNumberField;

    @FXML private Label TypeOfCardError;
    @FXML private Label SelectCardError;
    @FXML private Label EnterCardIDError;
    @FXML private Label ValidationResult;


    @FXML private final ObservableList<String> TypeOfCardsList = FXCollections.observableArrayList("ticket","Personal navigation card");
    @FXML private final ObservableList<String> SelectExistingCardsList = FXCollections.observableArrayList("card1","card2");

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
        EnterCardIDError.setText("Please Enter ID number");
        TypeOfCardError.setVisible(false);
        SelectCardError.setVisible(false);
        SelectfromexistincardsAnchor.setVisible(false);
        ValidationResult.setVisible(false);
        EnterCardIDError.setVisible(false);
        EnterCardIDnumberAnchor.setVisible(false);

        TypeOfCard.setItems(TypeOfCardsList);

        /* HERE ADD LOGIC TO GET ALL THE EXISTING CARDS
        * SelectExistingCardsList.add();
        * */
        SelectExistingCards.setItems(SelectExistingCardsList);
    }

    @FXML public void TitleChoice(ActionEvent event) throws IOException {

        String choice = TypeOfCard.getValue();
        if (choice!=null && !choice.isEmpty()){
            if (choice.equals("ticket")) {
                SelectfromexistincardsAnchor.setVisible(false);
                EnterCardIDnumberAnchor.setVisible(true);
                SelectCardError.setVisible(false);
            } else {
                EnterCardIDnumberAnchor.setVisible(false);
                EnterCardIDError.setVisible(false);
                EnterCardIDError.setText("Please Enter ID number");
                SelectfromexistincardsAnchor.setVisible(true);
            }
        }
    }

    @FXML public void ValidateFare(ActionEvent event) throws IOException {
        int CardID;
        TitreTransport newtitreTransport;
        boolean validFare=true; // if it enters a catch it is gonna be false

        TypeOfCardError.setVisible(false);
        SelectCardError.setVisible(false);
        ValidationResult.setVisible(false);
        EnterCardIDError.setVisible(false);

        String choice =TypeOfCard.getValue();
        if (choice != null && !choice.isEmpty()){
            if (choice.equals("ticket")) {

                String cardIDString = CardIDNumberField.getText();
                try {
                    CardID = Integer.parseInt(cardIDString);
                    /* Retrieve The ticket from the existing ones
                    *Add if the ticket id does not exist
                    * test if its valide
                    * */

                } catch (NumberFormatException nfe) {
                    EnterCardIDError.setText("Please enter a valid number");
                    EnterCardIDError.setVisible(true);
                    validFare=false;
                }
//                catch (TitreNonValideException e){
//                    ValidationResult.setVisible(true);
//                    ValidationResult.setText("The title is not valide (Expired date)");
//                    ValidationResult.setStyle("-fx-text-fill: red;");
//                      validFare=false;
//                }

                if (validFare){
                    ValidationResult.setVisible(true);
                    ValidationResult.setText("Ttile is Valid");
                    ValidationResult.setStyle("-fx-text-fill: Green;");
                }
            } else {

                String choiceCardPersonnel = SelectExistingCards.getValue();
                if (choiceCardPersonnel ==null || choiceCardPersonnel.isEmpty()){
                    SelectCardError.setVisible(true);
                } else {
                    /* RETRIEVE THE CARD FROM ITS IDENTIFICANT*/
                    try {
                        /* Retrieve The Card from the existing ones
                         * And test if its valide
                         * */

                    } catch (NumberFormatException nfe) {
                        EnterCardIDError.setText("Please enter a valid number");
                        EnterCardIDError.setVisible(true);
                        validFare=false;
                    }
                    /* TO CHANGE ALSO */
//                catch (TitreNonValideException e){
//                    ValidationResult.setVisible(true);
//                    ValidationResult.setText("The title is not valide (Expired date)");
//                    ValidationResult.setStyle("-fx-text-fill: red;");
//                      validFare=false;
//                }
                    if (validFare){
                        ValidationResult.setVisible(true);
                        ValidationResult.setText("Ttile is Valid");
                        ValidationResult.setStyle("-fx-text-fill: Green;");
                    }
                }

            }
        } else {
            TypeOfCardError.setVisible(true);
        }
    }

    @FXML public void Cancel(ActionEvent event) throws IOException {
        EnterCardIDError.setText("Please Enter ID number");
        TypeOfCardError.setVisible(false);
        EnterCardIDnumberAnchor.setVisible(false);
        SelectfromexistincardsAnchor.setVisible(false);
        SelectCardError.setVisible(false);
        ValidationResult.setVisible(false);
        EnterCardIDError.setVisible(false);
        TypeOfCard.setValue(null);
        SelectExistingCards.setValue(null);
        CardIDNumberField.clear();
    }

    @FXML public void clear(ActionEvent event) throws IOException {
        TypeOfCard.setValue(null);
        SelectExistingCards.setValue(null);
        CardIDNumberField.clear();
    }
    @FXML public void handleExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
