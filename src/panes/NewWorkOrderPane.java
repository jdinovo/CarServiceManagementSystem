package panes;


import form.FormAnswers;
import form.VehicleChoice;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tabs.NewWorkOrderTab;

import java.util.*;

import static main.Const.TEXTFIELD_WIDTH_SIZE;

/**
 * NewWorkOrderPane is the form where employees
 * can open and create work orders.
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/13/2018
 */
public class NewWorkOrderPane extends GridPane {

    //Importing the vehicleMap
    Map<String, List<String>> vehicleMap = VehicleChoice.getVehicleModel();

    //Instantiate the FormAnswers class
    Map<String, String> newCustomerMap = new HashMap<>();

    //Array of Textfields
    ArrayList<TextField> arrayOfTextFields = new ArrayList<>();

    //ComboBoxes for the form
    private ComboBox<String> comboBrand = new ComboBox<>();
    private ComboBox<String> comboModel = new ComboBox<>();

    /**
     * @author Chris Dias
     * @version 1.0
     * @since 11/13/2018
     *
     * This class creates the New Work Order Form that
     * is used in the New Work order Tab
     */
    public NewWorkOrderPane() {

        //GridPane that contains the entire UI for the Customer Info part of the NewWorkOrder
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(20);
        this.setHgap(10);

        //Creating columns
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        this.getColumnConstraints().addAll(col1,col2);

        //A string that appears when a an answer is empty
        Text textfieldIncomplete = new Text("You have an empty textfield!");

        GridPane.setConstraints(textfieldIncomplete, 0, 13, 2, 2);
        GridPane.setValignment(textfieldIncomplete, VPos.CENTER);
        GridPane.setHalignment(textfieldIncomplete, HPos.CENTER);
        textfieldIncomplete.setFill(Color.RED);
        textfieldIncomplete.setVisible(false);
        this.getChildren().add(textfieldIncomplete);

        /**
         * @author Chris Dias
         * @version 1.0
         * @since 11/13/2018
         *
         * These are the TextFields that will be asked for
         * in the customer part of the work order
         * @firstName first Name
         * @lastName Last Name
         * @address Address
         * @city city/town they reside in
         * @email Email address
         * @postalCode Postal Code
         * @cellphoneNum cell phone number
         **/
        //First Name Label
        Label firstNameText = new Label("First Name:");
        firstNameText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(firstNameText, HPos.LEFT);
        this.add(firstNameText, 0, 0, 1, 1);
        //First Name TextField
        TextField firstName = new TextField();
        arrayOfTextFields.add(firstName);
        firstName.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(firstName, HPos.CENTER);
        this.add(firstName, 0, 0, 1, 1);

        //Last Name Label
        Label lastNameText = new Label("Last Name:");
        lastNameText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(lastNameText, HPos.LEFT);
        this.add(lastNameText, 0, 1, 1, 1);
        //Last Name textField
        TextField lastName = new TextField();
        arrayOfTextFields.add(lastName);
        lastName.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(lastName, HPos.CENTER);
        this.add(lastName, 0, 1, 1, 1);

        //Address Label
        Label addressText = new Label("Address:");
        addressText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(addressText, HPos.LEFT);
        this.add(addressText, 0, 2, 1, 1);
        //Address Textfield
        TextField address = new TextField();
        arrayOfTextFields.add(address);
        address.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(address, HPos.CENTER);
        this.add(address, 0, 2, 1, 1);

        //City Label
        Label cityText = new Label("City:");
        cityText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(cityText, HPos.LEFT);
        this.add(cityText, 0, 3, 1, 1);
        //City Textfield
        TextField city = new TextField();
        arrayOfTextFields.add(city);
        city.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(city, HPos.CENTER);
        this.add(city, 0, 3, 1, 1);

        //Email Label
        Label emailText = new Label("Email:");
        emailText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(emailText, HPos.LEFT);
        this.add(emailText, 0, 4, 1, 1);
        //Email Textfield
        TextField email = new TextField();
        arrayOfTextFields.add(email);
        email.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(email, HPos.CENTER);
        this.add(email, 0, 4, 1, 1);

        //Postal Code Label
        Label postalCodeText = new Label("Postal Code:");
        postalCodeText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(postalCodeText, HPos.LEFT);
        this.add(postalCodeText, 0, 5, 1, 1);
        //Postal Code Textfield
        TextField postalCode = new TextField();
        arrayOfTextFields.add(postalCode);
        postalCode.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(postalCode, HPos.CENTER);
        this.add(postalCode, 0, 5, 1, 1);

        //Phone number Label
        Label phoneNumText = new Label("Phone Number:");
        phoneNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(phoneNumText, HPos.LEFT);
        this.add(phoneNumText, 0, 6, 1, 1);
        //Phone number textfield
        TextField phoneNum = new TextField();
        arrayOfTextFields.add(phoneNum);
        phoneNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(phoneNum, HPos.CENTER);
        this.add(phoneNum, 0, 6, 1, 1);

        /**
         * @author Chris Dias
         * @version 1.0
         * @since 11/13/2018
         *
         *
         * These are the TextFields that will be asked for
         * in the vehicle information part of the work order:
         * @vinNum vin number
         * @brand Brand of vehicle
         * @Model model of vehicle
         * @year year of vehicle
         * @kilometers kilometers of vehicle
         */
        //Vin num Label
        Label vinNumText = new Label("VIN Number:");
        vinNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(vinNumText, HPos.LEFT);
        this.add(vinNumText, 1, 0, 1, 1);
        //Vin Number textfield
        TextField vinNum = new TextField();
        arrayOfTextFields.add(vinNum);
        vinNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(vinNum, HPos.CENTER);
        this.add(vinNum, 1, 0, 1, 1);

        //Brand label
        Label brandText = new Label("Brand:");
        brandText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(brandText, HPos.LEFT);
        this.add(brandText, 1, 1, 1, 1);
        //Brand ComboBox
        comboBrand.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        //Set the drop down menu to the vehicleMap's key values
        comboBrand.setItems(FXCollections.observableArrayList(vehicleMap.keySet()));
        comboModel.setOnMouseClicked(e->{
            for (Map.Entry<String, List<String>> pair : vehicleMap.entrySet()) {
                if(pair.getKey().equals(comboBrand.getValue())) {
                        comboModel.setItems(FXCollections.observableList(pair.getValue()));
                }
            }
        });
        GridPane.setHalignment(comboBrand, HPos.CENTER);
        this.add(comboBrand, 1, 1, 1, 1);

        //Model Label
        Label modelText = new Label("Model:");
        modelText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(modelText, HPos.LEFT);
        this.add(modelText, 1, 2, 1, 1);
        //Model ComboBox
        comboModel.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(comboModel, HPos.CENTER);
        this.add(comboModel,1,2,1,1);

        //Year Text
        Label yearText = new Label("Year:");
        yearText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(yearText, HPos.LEFT);
        this.add(yearText, 1, 3, 1, 1);

        TextField year = new TextField();
        arrayOfTextFields.add(year);
        year.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(year, HPos.CENTER);
        this.add(year,  1, 3, 1, 1);

        //Email
        Label kilometersText = new Label("Kilometers:");
        kilometersText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(kilometersText, HPos.LEFT);
        this.add(kilometersText, 1, 4, 1, 1);

        TextField kilometers = new TextField();
        arrayOfTextFields.add(kilometers);
        kilometers.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(kilometers, HPos.CENTER);
        this.add(kilometers, 1, 4, 1, 1);

        /**
         * @author Chris Dias
         * @version 1.0
         * @since 11/13/2018
         *
         * These are the TextFields that will be asked for
         * in the vehicle information part of the work order:
         * @issue text area that explains the issue the customer is having with their car
         */

        Label issueText = new Label("In detail, please write the issue the customer is having with their vehicle:");
        issueText.setFont(Font.font("Times New Roman", 16));
        this.add(issueText, 0, 8, 2,2);
        GridPane.setValignment(issueText, VPos.CENTER);
        GridPane.setHalignment(issueText, HPos.CENTER);

        TextArea issue = new TextArea();
        issue.setMaxWidth(300);
        issue.setMaxSize(400,200);
        issue.setWrapText(true);
        this.add(issue, 0, 10, 2, 2);
        GridPane.setValignment(issue, VPos.CENTER);
        GridPane.setHalignment(issue, HPos.CENTER);

        /**
         * When the next button is pressed, save the textfield answers
         * into the Map strings.
         */
        Button nextButton = new Button("Complete Form");
        this.add(nextButton, 0, 12, 2, 1);
        GridPane.setValignment(nextButton, VPos.CENTER);
        GridPane.setHalignment(nextButton, HPos.CENTER);

        nextButton.setOnMouseClicked(e->{
            try {
            if (firstName.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (lastName.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (address.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (city.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (email.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (postalCode.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (phoneNum.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (vinNum.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (comboBrand.getValue().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (comboModel.getValue().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (year.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (kilometers.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else if (issue.getText().isEmpty()) {
                textfieldIncomplete.setVisible(true);
            } else {

                //Instantiate the FormAnswers class
                FormAnswers formAnswers = new FormAnswers();

                //Populate the formAnswers Map
                formAnswers.setFirstNameMap(firstName.getText());
                formAnswers.setLastNameMap(lastName.getText());
                formAnswers.setAddressMap(address.getText());
                formAnswers.setCityMap(city.getText());
                formAnswers.setEmailMap(email.getText());
                formAnswers.setPostalCodeMap(postalCode.getText());
                formAnswers.setPhoneNumMap(phoneNum.getText());
                formAnswers.setVinNumMap(vinNum.getText());
                formAnswers.setBrandMap(comboBrand.getValue());
                formAnswers.setModelMap(comboModel.getValue());
                formAnswers.setYearMap(year.getText());
                formAnswers.setKilometersMap(kilometers.getText());
                formAnswers.setIssueMap(issue.getText());

                textfieldIncomplete.setVisible(false);

                //Finished the customer info page -
                // Customer profile is created & work order has been opened for service
                //Now opens up the open current issue tab
                System.out.println(formAnswers);

                //Delete response in textfields and close the tab
                for (TextField answer : arrayOfTextFields) {
                    answer.setText("");
                }
                comboBrand.setValue(null);
                comboModel.setValue(null);
                issue.setText("");
                NewWorkOrderTab.closeInstance();
            }
            } catch (NullPointerException f) {
                System.out.println("A textfield is empty");
                textfieldIncomplete.setVisible(true);
            }
        }); // end of complete form button
    } //end of NewWorkOrderPane()
} //End of class
