package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class CustomerInfoPane extends BorderPane {

    /**
     * A map that will contain the customer information.
     * In a future update, this will be saved into the database
     */
    Map<String, String> newCustomerMap = new HashMap<>();
    String firstNameMap = "";
    String lastNameMap = "";
    String addressMap = "";
    String cityMap = "";
    String emailMap = "";
    String postalCodeMap = "";
    String cellPhoneNumMap = "";

    //Calling the CustomerInfoPane
    VehicleInfoPane vehicleInfoPane = new VehicleInfoPane();


    /**
     * @author Chris Dias
     * @date 10.31.2018
     * @version 1.0
     *
     * A function that creates the Customer Information part of the GUI
     * of NewWorkOrder to be used in the New Work Order tab
     */
    public GridPane CustomerInfoGui() {

        Text textfieldIncomplete = new Text("");
        textfieldIncomplete.setVisible(false);

        //GridPane that contains the entire UI for the Customer Info part of the NewWorkOrder
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(20);

        /**
         * These are the TextFields that will be asked for
         * in the custoemr part of the work order
         * @firstName first Name
         * @lastName Last Name
         * @address Address
         * @city city/town they reside in
         * @email Email address
         * @postalCode Postal Code
         * @cellphoneNum cell phone number
         *
         */
        //First Name textfield
        Label firstNameText = new Label("First Name:");
        firstNameText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(firstNameText, 0, 0);
        grid.getChildren().add(firstNameText);

        TextField firstName = new TextField();
        firstName.setMaxWidth(300);
        firstName.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(firstName, 1, 0);
        grid.getChildren().add(firstName);

        //Last Name textfield
        Label lastNameText = new Label("Last Name:");
        lastNameText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(lastNameText, 0, 1);
        grid.getChildren().add(lastNameText);

        TextField lastName = new TextField();
        lastName.setMaxWidth(300);
        lastName.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(lastName, 1, 1);
        grid.getChildren().add(lastName);

        //Address
        Label addressText = new Label("Address:");
        addressText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(addressText, 0, 2);
        grid.getChildren().add(addressText);

        TextField address = new TextField();
        address.setMaxWidth(300);
        address.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(address, 1, 2);
        grid.getChildren().add(address);

        //City
        Label cityText = new Label("City:");
        cityText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(cityText, 0, 3);
        grid.getChildren().add(cityText);

        TextField city = new TextField();
        city.setMaxWidth(300);
        city.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(city, 1, 3);
        grid.getChildren().add(city);

        //Email
        Label emailText = new Label("Email:");
        emailText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(emailText, 0, 4);
        grid.getChildren().add(emailText);

        TextField email = new TextField();
        email.setMaxWidth(300);
        email.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(email, 1, 4);
        grid.getChildren().add(email);

        //Postal Code
        Label postalCodeText = new Label("Postal Code:");
        postalCodeText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(postalCodeText, 0, 5);
        grid.getChildren().add(postalCodeText);

        TextField postalCode = new TextField();
        postalCode.setMaxWidth(300);
        postalCode.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(postalCode, 1, 5);
        grid.getChildren().add(postalCode);

        //Cell phone number
        Label cellPhoneNumText = new Label("Cell Number:");
        cellPhoneNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(cellPhoneNumText, 0, 6);
        grid.getChildren().add(cellPhoneNumText);

        TextField cellPhoneNum = new TextField();
        cellPhoneNum.setMaxWidth(300);
        address.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(cellPhoneNum, 1, 6);
        grid.getChildren().add(cellPhoneNum);

        /**
         * When the next button is pressed, save the textfield answers
         * into the Map strings.
         */
        Button nextButton = new Button("Next");
        GridPane.setConstraints(nextButton, 1, 7);
        nextButton.setOnMouseClicked(e->{

            //If none of the textfields are empty, save the answers into the string
            if (!firstName.getText().isEmpty() && !lastName.getText().isEmpty() &&
                    !address.getText().isEmpty() && !city.getText().isEmpty() &&
                    !email.getText().isEmpty() && !postalCode.getText().isEmpty() &&
                    !cellPhoneNum.getText().isEmpty()) {
                firstNameMap = firstName.getText();
                lastNameMap = lastName.getText();
                addressMap = address.getText();
                cityMap = city.getText();
                emailMap = email.getText();
                postalCodeMap = postalCode.getText();
                cellPhoneNumMap = cellPhoneNum.getText();

                textfieldIncomplete.setVisible(false);
                grid.getChildren().remove(textfieldIncomplete);
                System.out.println("page complete");

                //Continue to the vehicle page


            } else {
                // If one of the textfields are empty, let the user know which textfield is empty
                textfieldIncomplete.setText("You have an empty textfield");
                GridPane.setConstraints(textfieldIncomplete, 1, 8);
                textfieldIncomplete.setFill(Color.RED);

                //Only add to the screen if the text is not visible
                if (!textfieldIncomplete.isVisible()) {
                    grid.getChildren().add(textfieldIncomplete);
                }
                textfieldIncomplete.setVisible(true);
            }

        });
        grid.getChildren().add(nextButton);

        return grid;
    }



}
