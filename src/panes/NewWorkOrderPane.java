package panes;


import com.mysql.jdbc.StringUtils;
import form.FormAnswers;
import form.ProvinceChoice;
import form.VehicleChoice;
import javabean.*;
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
import tables.*;
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
    ArrayList<String> provinceMap = ProvinceChoice.getProvinceModel();

    //Array of Textfields
    ArrayList<TextField> arrayOfTextFields = new ArrayList<>();

    //ComboBoxes for the form
    private ComboBox<String> comboBrand = new ComboBox<>();
    private ComboBox<String> comboModel = new ComboBox<>();
    private ComboBox<String> comboProvince = new ComboBox<>();

    //Get Access to the tables
    CustomersTable custTable = new CustomersTable();
    VehiclesTable vehTable = new VehiclesTable();
    WorkordersTable workTable = new WorkordersTable();
    CustomerVehiclesTable custVehTable = new CustomerVehiclesTable();
    VehicleWorkordersTable vehWorkTable = new VehicleWorkordersTable();
    CustomerVehicleIssueTable customerVehicleIssueTable = new CustomerVehicleIssueTable();

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

        GridPane.setConstraints(textfieldIncomplete, 0, 14, 2, 2);
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
        firstName.setPromptText("First Name");
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
        lastName.setPromptText("Last Name");
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
        address.setPromptText("Ex) # Street Name St.");
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
        city.setPromptText("City Name");
        arrayOfTextFields.add(city);
        city.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(city, HPos.CENTER);
        this.add(city, 0, 3, 1, 1);

        //Province label
        Label provinceText = new Label("Province:");
        provinceText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(provinceText, HPos.LEFT);
        this.add(provinceText, 0, 4, 1, 1);
        //Province ComboBox
        comboProvince.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        //Set the drop down menu to the vehicleMap's key values
        comboProvince.setItems(FXCollections.observableArrayList(provinceMap));
        GridPane.setHalignment(comboProvince, HPos.CENTER);
        this.add(comboProvince, 0, 4, 1, 1);

        //Email Label
        Label emailText = new Label("Email:");
        emailText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(emailText, HPos.LEFT);
        this.add(emailText, 0, 5, 1, 1);
        //Email Textfield
        TextField email = new TextField();
        email.setPromptText("Ex) emailname@hotmail.com");
        arrayOfTextFields.add(email);
        email.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(email, HPos.CENTER);
        this.add(email, 0, 5, 1, 1);

        //Postal Code Label
        Label postalCodeText = new Label("Postal Code:");
        postalCodeText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(postalCodeText, HPos.LEFT);
        this.add(postalCodeText, 0, 6, 1, 1);
        //Postal Code Textfield
        TextField postalCode = new TextField();
        postalCode.setPromptText("Ex) A9AA9A");
        arrayOfTextFields.add(postalCode);
        postalCode.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(postalCode, HPos.CENTER);
        this.add(postalCode, 0, 6, 1, 1);

        //Phone number Label
        Label phoneNumText = new Label("Phone Number:");
        phoneNumText.setFont(Font.font("Times New Roman", 16));
        GridPane.setHalignment(phoneNumText, HPos.LEFT);
        this.add(phoneNumText, 0, 7, 1, 1);
        //Phone number textfield
        TextField phoneNum = new TextField();
        phoneNum.setPromptText("Ex) (555)555-5555");
        arrayOfTextFields.add(phoneNum);
        phoneNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        GridPane.setHalignment(phoneNum, HPos.CENTER);
        this.add(phoneNum, 0, 7, 1, 1);

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
        vinNum.setPromptText("Vin Number");
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
        comboBrand.setOnAction(e->{
            comboModel.setValue("");
        });
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
        year.setPromptText("Year");
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
        kilometers.setPromptText("Number of Kilometers");
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
        this.add(issueText, 0, 9, 2,2);
        GridPane.setValignment(issueText, VPos.CENTER);
        GridPane.setHalignment(issueText, HPos.CENTER);

        TextArea issue = new TextArea();
        issue.setPromptText("Explain issue with the vehicle");
        issue.setMaxWidth(300);
        issue.setMaxSize(400,200);
        issue.setWrapText(true);
        this.add(issue, 0, 11, 2, 2);
        GridPane.setValignment(issue, VPos.CENTER);
        GridPane.setHalignment(issue, HPos.CENTER);

        /**
         * When the next button is pressed, save the textfield answers
         * into the Map strings.
         */
        Button nextButton = new Button("Complete Form");
        this.add(nextButton, 0, 13, 2, 1);
        GridPane.setValignment(nextButton, VPos.CENTER);
        GridPane.setHalignment(nextButton, HPos.CENTER);

        nextButton.setOnMouseClicked(e->{
            try {
                emailText.setTextFill(Color.BLACK);
                postalCodeText.setTextFill(Color.BLACK);
                phoneNumText.setTextFill(Color.BLACK);
                vinNumText.setTextFill(Color.BLACK);
                yearText.setTextFill(Color.BLACK);
                issueText.setTextFill(Color.BLACK);
                textfieldIncomplete.setText("You have an empty textfield! Please fill out the entire form!");
                if (firstName.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (lastName.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (address.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (city.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (email.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (postalCode.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (phoneNum.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (vinNum.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (comboBrand.getValue().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (comboModel.getValue().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (year.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (kilometers.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (issue.getText().trim().isEmpty()) {
                    textfieldIncomplete.setVisible(true);
                } else if (!email.getText().trim().matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                    textfieldIncomplete.setText("Please make sure email follows example@company.com");
                    textfieldIncomplete.setVisible(true);
                    emailText.setTextFill(Color.RED);
                } else if (postalCode.getText().trim().length() > 6) {
                    textfieldIncomplete.setText("Please make sure your postal code follows A0B1C0");
                    textfieldIncomplete.setVisible(true);
                    postalCodeText.setTextFill(Color.RED);
                } else if (phoneNum.getText().trim().length() > 15 || !phoneNum.getText().matches("\\(\\d{3}\\)\\d{3}-?\\d{4}")) {
                    textfieldIncomplete.setText("Please make sure your phone number follows (555)555-5555");
                    textfieldIncomplete.setVisible(true);
                    phoneNumText.setTextFill(Color.RED);
                } else if (vinNum.getText().trim().length() > 17) {
                    textfieldIncomplete.setText("VIN cannot be longer than 17 characters");
                    textfieldIncomplete.setVisible(true);
                    vinNumText.setTextFill(Color.RED);
                } else if (year.getText().trim().length() > 4 || !StringUtils.isStrictlyNumeric(year.getText())) {
                    textfieldIncomplete.setText("Year cannot be longer than 4 digits");
                    textfieldIncomplete.setVisible(true);
                    yearText.setTextFill(Color.RED);
                } else if (!StringUtils.isStrictlyNumeric(kilometers.getText().trim())) {
                    textfieldIncomplete.setText("Kilometers may only be numeric");
                    textfieldIncomplete.setVisible(true);
                    kilometersText.setTextFill(Color.RED);
                } else if (issue.getText().trim().length() > 250) {
                    textfieldIncomplete.setText("Issue description must be no longer than 250 characters");
                    textfieldIncomplete.setVisible(true);
                    issueText.setTextFill(Color.RED);
                } else {

                    //Instantiate the FormAnswers class
                    FormAnswers formAnswers = new FormAnswers();

                    //Populate the formAnswers Map
                    formAnswers.setFirstNameMap(firstName.getText().trim());
                    formAnswers.setLastNameMap(lastName.getText().trim());
                    formAnswers.setAddressMap(address.getText().trim());
                    formAnswers.setCityMap(city.getText().trim());
                    formAnswers.setEmailMap(email.getText().trim());
                    formAnswers.setPostalCodeMap(postalCode.getText().trim());
                    formAnswers.setPhoneNumMap(phoneNum.getText().trim());
                    formAnswers.setVinNumMap(vinNum.getText().trim());
                    formAnswers.setBrandMap(comboBrand.getValue());
                    formAnswers.setModelMap(comboModel.getValue());
                    formAnswers.setProvinceMap(comboProvince.getValue());
                    formAnswers.setYearMap(year.getText().trim());
                    formAnswers.setKilometersMap(kilometers.getText().trim());
                    formAnswers.setIssueMap(issue.getText().trim());

                    textfieldIncomplete.setVisible(false);

                    //Finished the customer info page -
                    // Customer profile is created & work order has been opened for service
                    //Now opens up the open current issue tab
                    System.out.println(formAnswers);

                    java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
                    Workorders workorder = new Workorders(sqlDate.toString(), formAnswers.getIssueMap());
                    workTable.createWorkorder(workorder);
                    ArrayList<Workorders> workorderArray = workTable.getAllWorkorders();

                    Vehicles vehicle = new Vehicles(formAnswers.getVinNumMap(), formAnswers.getBrandMap(), formAnswers.getModelMap(), formAnswers.getYearMap(), formAnswers.getKilometersMap());
                    vehTable.createVehicle(vehicle);
                    ArrayList<Vehicles> vehicleArray = vehTable.getAllVehicles();

                    Customers customer = new Customers(formAnswers.getFirstNameMap(), formAnswers.getLastNameMap(), formAnswers.getAddressMap(), formAnswers.getCityMap(), formAnswers.getProvinceMap(), formAnswers.getPostalCodeMap(), formAnswers.getPhoneNumMap(), formAnswers.getEmailMap());
                    custTable.createCustomer(customer);
                    ArrayList<Customers> customerArray = custTable.getAllCustomers();

                    CustomerVehicles customerVehicle = new CustomerVehicles(customerArray.get(customerArray.size() - 1).getId(), vehicleArray.get(vehicleArray.size() - 1).getId());
                    custVehTable.createCustomerVehicle(customerVehicle);

                    VehicleWorkorders vehicleWorkorder = new VehicleWorkorders(vehicleArray.get(vehicleArray.size() - 1).getId(), workorderArray.get(workorderArray.size() - 1).getId());
                    vehWorkTable.createVehicleWorkorder(vehicleWorkorder);

                    //Delete response in textfields and close the tab
                    for (TextField answer : arrayOfTextFields) {
                        answer.setText("");
                    }

                    comboBrand.setValue(null);
                    comboModel.setValue(null);
                    comboProvince.setValue(null);
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
