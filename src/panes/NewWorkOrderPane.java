package panes;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tabs.NewWorkOrderTab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewWorkOrderPane extends Parent {

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

    //Vehicle part
    String vinNumMap = "";
    String brandMap = "";
    String modelMap = "";
    String yearMap = "";
    String kilometersMap = "";

    //Service Part
    String issueMap = "";
    //String servicesMap = "";



    /**
     * @author Chris Dias
     * @date 10.31.2018
     * @version 1.0
     *
     * A function that creates the Customer Information part of the GUI
     * of NewWorkOrder to be used in the New Work Order tab
     */
    public GridPane newWorkOrderGui() {

        Text textfieldIncomplete = new Text("");
        textfieldIncomplete.setVisible(false);

        //Array of Textfields
        ArrayList<TextField> arrayOfTextFields = new ArrayList<>();


        //GridPane that contains the entire UI for the Customer Info part of the NewWorkOrder
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);


        /*
         * These are the TextFields that will be asked for
         * in the customer part of the work order
         * @firstName first Name
         * @lastName Last Name
         * @address Address
         * @city city/town they reside in
         * @email Email address
         * @postalCode Postal Code
         * @cellphoneNum cell phone number

         */
        //First Name textfield
        Label firstNameText = new Label("First Name:");
        firstNameText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(firstNameText, 0, 0);
        grid.getChildren().add(firstNameText);


        TextField firstName = new TextField();
        arrayOfTextFields.add(firstName);
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
        arrayOfTextFields.add(lastName);
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
        arrayOfTextFields.add(address);
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
        arrayOfTextFields.add(city);
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
        arrayOfTextFields.add(email);
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
        arrayOfTextFields.add(postalCode);
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
        arrayOfTextFields.add(cellPhoneNum);
        cellPhoneNum.setMaxWidth(300);
        address.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(cellPhoneNum, 1, 6);
        grid.getChildren().add(cellPhoneNum);

        /**
         * These are the TextFields that will be asked for
         * in the vehicle information part of the work order:
         * @vinNum vin number
         * @brand Brand of vehicle
         * @Model model of vehicle
         * @year year of vehicle
         * @kilometers kilometers of vehicle
         */
        //Vin num textfield
        Label vinNumText = new Label("VIN Number:");
        vinNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(vinNumText, 3, 0);
        grid.getChildren().add(vinNumText);

        TextField vinNum = new TextField();
        arrayOfTextFields.add(vinNum);
        vinNum.setMaxWidth(300);
        vinNum.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(vinNum, 4, 0);
        grid.getChildren().add(vinNum);

        //Brand textfield
        Label brandText = new Label("Brand:");
        brandText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(brandText, 3, 1);
        grid.getChildren().add(brandText);

        TextField brand = new TextField();
        arrayOfTextFields.add(brand);
        brand.setMaxWidth(300);
        brand.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(brand, 4, 1);
        grid.getChildren().add(brand);

        //Model Text
        Label modelText = new Label("Model:");
        modelText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(modelText, 3, 2);
        grid.getChildren().add(modelText);

        TextField model = new TextField();
        arrayOfTextFields.add(model);
        model.setMaxWidth(300);
        model.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(model, 4, 2);
        grid.getChildren().add(model);

        //Year Text
        Label yearText = new Label("Year:");
        yearText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(yearText, 3, 3);
        grid.getChildren().add(yearText);

        TextField year = new TextField();
        arrayOfTextFields.add(year);
        year.setMaxWidth(300);
        year.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(year, 4, 3);
        grid.getChildren().add(year);

        //Email
        Label kilometersText = new Label("Kilometers:");
        kilometersText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(kilometersText, 3, 4);
        grid.getChildren().add(kilometersText);

        TextField kilometers = new TextField();
        arrayOfTextFields.add(kilometers);
        kilometers.setMaxWidth(300);
        kilometers.setAlignment(Pos.TOP_CENTER);
        GridPane.setConstraints(kilometers, 4, 4);
        grid.getChildren().add(kilometers);

        /**
         * These are the TextFields that will be asked for
         * in the vehicle information part of the work order:
         * @issue text area that explains the issue the customer is having with their car
         * @service A series of services that the tech chooses to place in the work order
         */
        //Vin num textfield
        //HBox serviceInfoBox = new HBox();
        //serviceInfoBox.setAlignment(Pos.BOTTOM_CENTER);

        Label issueText = new Label("In detail, please write the issue the customer is having with their vehicle:");
        issueText.setFont(Font.font("Times New Roman", 16));
        GridPane.setConstraints(issueText, 0, 9, 3, 3);
        GridPane.setHalignment(issueText, HPos.CENTER);
        grid.getChildren().add(issueText);

        TextArea issue = new TextArea();
        issue.setMaxWidth(300);
        issue.setMaxSize(400,400);
        issue.setWrapText(true);
        GridPane.setConstraints(issue, 1, 12, 3, 3);
        GridPane.setHalignment(issue, HPos.CENTER);
        grid.getChildren().add(issue);


        /**
         * When the next button is pressed, save the textfield answers
         * into the Map strings.
         */
        Button nextButton = new Button("Complete Form");
        GridPane.setConstraints(nextButton, 2, 19);
        nextButton.setOnMouseClicked(e->{

            //If none of the textfields are empty, save the answers into the string
            if (!firstName.getText().isEmpty() && !lastName.getText().isEmpty() &&
                    !address.getText().isEmpty() && !city.getText().isEmpty() &&
                    !email.getText().isEmpty() && !postalCode.getText().isEmpty() &&
                    !cellPhoneNum.getText().isEmpty() && !vinNum.getText().isEmpty() &&
                    !brand.getText().isEmpty() && !model.getText().isEmpty() &&
                    !year.getText().isEmpty() && !kilometers.getText().isEmpty() &&
                    !issue.getText().isEmpty()) {

                firstNameMap = firstName.getText();
                lastNameMap = lastName.getText();
                addressMap = address.getText();
                cityMap = city.getText();
                emailMap = email.getText();
                postalCodeMap = postalCode.getText();
                cellPhoneNumMap = cellPhoneNum.getText();
                vinNumMap = vinNum.getText();
                brandMap = brand.getText();
                modelMap = model.getText();
                yearMap = year.getText();
                kilometersMap = kilometers.getText();
                issueMap = issue.getText();

                //Add the answers to the Map
                newCustomerMap.put("firstNameMap", firstName.getText());
                newCustomerMap.put("lastNameMap", lastName.getText());
                newCustomerMap.put("addressMap", address.getText());
                newCustomerMap.put("cityMap", city.getText());
                newCustomerMap.put("emailMap", email.getText());
                newCustomerMap.put("postalCodeMap", postalCode.getText());
                newCustomerMap.put("cellPhoneNumMap", cellPhoneNum.getText());
                newCustomerMap.put("vinNumMap", vinNum.getText());
                newCustomerMap.put("brandMap", brand.getText());
                newCustomerMap.put("modelMap", model.getText());
                newCustomerMap.put("yearMap", year.getText());
                newCustomerMap.put("kilometerMap", kilometers.getText());
                newCustomerMap.put("issueMap", issue.getText());


                textfieldIncomplete.setVisible(false);
                grid.getChildren().remove(textfieldIncomplete);

                //Finished the customer info page -
                // Customer profile is created & work order has been opened for service
                //Now opens up the open current issue tab
                System.out.println("page complete");
                System.out.println(newCustomerMap);

                //Delete response in textfields and close the tab
                for (TextField answer : arrayOfTextFields) {
                    answer.setText("");
                }
                issue.setText("");
                NewWorkOrderTab.closeInstance();

            } else {
                // If one of the textfields are empty, let the user know which textfield is empty
                textfieldIncomplete.setText("You have an empty textfield");
                GridPane.setConstraints(textfieldIncomplete, 2, 17);
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
