package panes;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tabs.NewWorkOrderTab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewWorkOrderPane extends GridPane {

    /**
     * A map that will contain the customer information.
     * In a future update, this will be saved into the database
     */
    private Map<String, String> newCustomerMap = new HashMap<>();
    private String firstNameMap = "";
    private String lastNameMap = "";
    private String addressMap = "";
    private String cityMap = "";
    private String emailMap = "";
    private String postalCodeMap = "";
    private String cellPhoneNumMap = "";

    //Vehicle part
    private String vinNumMap = "";
    private String brandMap = "";
    private String modelMap = "";
    private String yearMap = "";
    private String kilometersMap = "";

    //Service Part
    private String issueMap = "";
    //String servicesMap = "";



    /**
     * @author Chris Dias
     * @date 10.31.2018
     * @version 1.0
     *
     * A function that creates the Customer Information part of the GUI
     * of NewWorkOrder to be used in the New Work Order tab
     */
    public NewWorkOrderPane() {

        Text textfieldIncomplete = new Text("");
        textfieldIncomplete.setVisible(false);

        //Array of Textfields
        ArrayList<TextField> arrayOfTextFields = new ArrayList<>();

        //GridPane that contains the entire UI for the Customer Info part of the NewWorkOrder

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setVgap(20);
        this.setHgap(10);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
//        ColumnConstraints col3 = new ColumnConstraints();
//        col3.setPercentWidth(20);
//        ColumnConstraints col4 = new ColumnConstraints();
//        col4.setPercentWidth(30);

        this.getColumnConstraints().addAll(col1,col2);

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
        GridPane.setHalignment(firstNameText, HPos.LEFT);
        this.add(firstNameText, 0, 0, 1, 1);


        TextField firstName = new TextField();
        arrayOfTextFields.add(firstName);
        firstName.setMaxWidth(250);
        GridPane.setHalignment(firstName, HPos.RIGHT);
        this.add(firstName, 0, 0, 1, 1);

        //Last Name textfield
        Label lastNameText = new Label("Last Name:");
        lastNameText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(lastNameText, HPos.LEFT);
        this.add(lastNameText, 0, 1, 1, 1);

        TextField lastName = new TextField();
        arrayOfTextFields.add(lastName);
        lastName.setMaxWidth(250);
        GridPane.setHalignment(lastName, HPos.RIGHT);
        this.add(lastName, 0, 1, 1, 1);

        //Address
        Label addressText = new Label("Address:");
        addressText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(addressText, HPos.LEFT);
        this.add(addressText, 0, 2, 1, 1);

        TextField address = new TextField();
        arrayOfTextFields.add(address);
        address.setMaxWidth(250);
        GridPane.setHalignment(address, HPos.RIGHT);
        this.add(address, 0, 2, 1, 1);

        //City
        Label cityText = new Label("City:");
        cityText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(cityText, HPos.LEFT);
        this.add(cityText, 0, 3, 1, 1);

        TextField city = new TextField();
        arrayOfTextFields.add(city);
        city.setMaxWidth(250);
        GridPane.setHalignment(city, HPos.RIGHT);
        this.add(city, 0, 3, 1, 1);

        //Email
        Label emailText = new Label("Email:");
        emailText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(emailText, HPos.LEFT);
        this.add(emailText, 0, 4, 1, 1);

        TextField email = new TextField();
        arrayOfTextFields.add(email);
        email.setMaxWidth(250);
        GridPane.setHalignment(email, HPos.RIGHT);
        this.add(email, 0, 4, 1, 1);

        //Postal Code
        Label postalCodeText = new Label("Postal Code:");
        postalCodeText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(postalCodeText, HPos.LEFT);
        this.add(postalCodeText, 0, 5, 1, 1);

        TextField postalCode = new TextField();
        arrayOfTextFields.add(postalCode);
        postalCode.setMaxWidth(250);
        GridPane.setHalignment(postalCode, HPos.RIGHT);
        this.add(postalCode, 0, 5, 1, 1);

        //Cell phone number
        Label cellPhoneNumText = new Label("Cell Number:");
        cellPhoneNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(cellPhoneNumText, HPos.LEFT);
        this.add(cellPhoneNumText, 0, 6, 1, 1);

        TextField cellPhoneNum = new TextField();
        arrayOfTextFields.add(cellPhoneNum);
        cellPhoneNum.setMaxWidth(250);
        GridPane.setHalignment(cellPhoneNum, HPos.RIGHT);
        this.add(cellPhoneNum, 0, 6, 1, 1);

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
        GridPane.setHalignment(vinNumText, HPos.LEFT);
        this.add(vinNumText, 1, 0, 1, 1);

        TextField vinNum = new TextField();
        arrayOfTextFields.add(vinNum);
        vinNum.setMaxWidth(250);
        GridPane.setHalignment(vinNum, HPos.RIGHT);
        this.add(vinNum, 1, 0, 1, 1);

        //Brand textfield
        Label brandText = new Label("Brand:");
        brandText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(brandText, HPos.LEFT);
        this.add(brandText, 1, 1, 1, 1);

        TextField brand = new TextField();
        arrayOfTextFields.add(brand);
        brand.setMaxWidth(250);
        GridPane.setHalignment(brand, HPos.RIGHT);
        this.add(brand, 1, 1, 1, 1);

        //Model Text
        Label modelText = new Label("Model:");
        modelText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(modelText, HPos.LEFT);
        this.add(modelText, 1, 2, 1, 1);

        TextField model = new TextField();
        arrayOfTextFields.add(model);
        model.setMaxWidth(250);
        GridPane.setHalignment(model, HPos.RIGHT);
        this.add(model, 1, 2, 1, 1);

        //Year Text
        Label yearText = new Label("Year:");
        yearText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(yearText, HPos.LEFT);
        this.add(yearText, 1, 3, 1, 1);

        TextField year = new TextField();
        arrayOfTextFields.add(year);
        year.setMaxWidth(250);
        GridPane.setHalignment(year, HPos.RIGHT);
        this.add(year,  1, 3, 1, 1);

        //Email
        Label kilometersText = new Label("Kilometers:");
        kilometersText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(kilometersText, HPos.LEFT);
        this.add(kilometersText, 1, 4, 1, 1);

        TextField kilometers = new TextField();
        arrayOfTextFields.add(kilometers);
        kilometers.setMaxWidth(250);
        GridPane.setHalignment(kilometers, HPos.RIGHT);
        this.add(kilometers, 1, 4, 1, 1);

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
                this.getChildren().remove(textfieldIncomplete);

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
                GridPane.setConstraints(textfieldIncomplete, 0, 13, 2, 2);
                GridPane.setValignment(textfieldIncomplete, VPos.CENTER);
                GridPane.setHalignment(textfieldIncomplete, HPos.CENTER);
                textfieldIncomplete.setFill(Color.RED);

                //Only add to the screen if the text is not visible
                if (!textfieldIncomplete.isVisible()) {
                    this.getChildren().add(textfieldIncomplete);
                }
                textfieldIncomplete.setVisible(true);
            }

        });

    }


}
