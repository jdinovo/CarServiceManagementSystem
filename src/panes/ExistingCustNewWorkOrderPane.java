package panes;

import form.FormAnswers;
import form.ProvinceChoice;
import form.VehicleChoice;
import javabean.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.Const;
import tables.*;
import tabs.ExistingWorkOrderTab;
import tabs.NewWorkOrderTab;

import java.util.*;

import static main.Const.TEXTFIELD_WIDTH_SIZE;

/**
 * ExistingCustNewWorkOrderPane is the pane that opens
 * when a new work order is to be created.
 * It consists of a lsitview of the all the customers,
 * with the option to search by phone number and create a work order based off existing customers.
 *
 * Otherwise you can create a new work order as well as a new customer profile
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/19/2018
 */
public class ExistingCustNewWorkOrderPane extends BorderPane {

    //Importing the vehicleMap
    private Map<String, List<String>> vehicleMap = VehicleChoice.getVehicleModel();
    private ArrayList<String> provinceMap = ProvinceChoice.getProvinceModel();

    //ComboBoxes for the form
    private ComboBox<String> comboBrand = new ComboBox<>();
    private ComboBox<String> comboModel = new ComboBox<>();
    private ComboBox<String> comboProvince = new ComboBox<>();

    private Customers customer = new Customers();
    private Vehicles vehicle = new Vehicles();
    private ArrayList<Customers> customers;
    private ArrayList<CustomerVehicles> customerVehicles;
    private ArrayList<Vehicles> vehicles = new ArrayList<>();

    //Get Access to the tables
    private CustomersTable custTable = new CustomersTable();
    private VehiclesTable vehTable = new VehiclesTable();
    private WorkordersTable workTable = new WorkordersTable();
    private CustomerVehiclesTable custVehTable = new CustomerVehiclesTable();
    private VehicleWorkordersTable vehWorkTable = new VehicleWorkordersTable();
    private CustomerVehicleIssueTable customerVehicleIssueTable = new CustomerVehicleIssueTable();

    private ListView<Vehicles> vehicleListView = new ListView<>();

    private TableView<Customers> tableView;

    public ExistingCustNewWorkOrderPane() {

        //declaring variables
        Text warning = new Text("Error!");
        warning.setVisible(false);
        warning.setFill(Color.RED);

        customers = custTable.getAllActiveCustomers();


        /**
         *Top of the form is the Customer Profiles and a search bar
         */
        VBox tableAndButtonBox = new VBox();
        HBox searchBar = new HBox();
        searchBar.setPadding(new Insets(10,10,10,10));
        searchBar.setSpacing(10);

        Label searchText = new Label("Search by Phone Number:");
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("(555)555-5555");
        searchTextField.setPrefWidth(TEXTFIELD_WIDTH_SIZE);
        Button searchButton = new Button("Search");

        tableView = new TableView<>();
        tableView.setItems(FXCollections.observableArrayList(customers));

        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(25);
        tableView.setPrefHeight(625);

        TableColumn<Customers, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Customers, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customers, String> addressCol = new TableColumn<>("Address");
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Customers, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<>("city"));

        TableColumn<Customers, String> provinceCol = new TableColumn<>("Province");
        provinceCol.setCellValueFactory(new PropertyValueFactory<>("province"));

        TableColumn<Customers, String> postalCol = new TableColumn<>("Postal Code");
        postalCol.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        TableColumn<Customers, String> phoneCol = new TableColumn<>("Phone Number");
        phoneCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Customers, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        tableView.getColumns().addAll(firstNameCol, lastNameCol, addressCol, cityCol, provinceCol, postalCol, phoneCol, emailCol);

        searchButton.setOnMouseClicked(e->{
            if (searchTextField.getText().matches("\\(\\d{3}\\)\\d{3}-?\\d{4}")) {
                final String number = searchTextField.getText().trim();
                if(!number.isEmpty()) {
                    customers.clear();
                    custTable.getAllActiveCustomers().forEach(profile -> {
                        if (profile.getPhoneNumber().equals(number)) {
                            customers.add(profile);
                        }
                    });
                    tableView.setItems(FXCollections.observableArrayList(customers));
                }
            }
        });

        //Create a button that will send the user to the pane to create a new profile instead
        Button newProfile = new Button("Create A New Customer");
        newProfile.setAlignment(Pos.TOP_RIGHT);

        searchBar.getChildren().addAll(searchText, searchTextField, searchButton, newProfile);

        tableAndButtonBox.setAlignment(Pos.BOTTOM_CENTER);
        tableAndButtonBox.setPadding(new Insets(10,0,10,0));
        tableAndButtonBox.getChildren().addAll(searchBar, tableView);


        /**
         * Middle of the Form is a table view of which vehicle to perform a service on
         */
        //Vehicle list view title
        Text vehListViewText = new Text("Customer's Vehicles");
        vehListViewText.setFont(Font.font("Times New Roman", 20));

        HBox hBox = new HBox();
        VBox updateCustomerBox = new VBox();
        VBox addVehicleBox = new VBox();
        VBox vehicleList = new VBox();

        //Customer info title
        Text customerInfo = new Text("Customer Information");
        customerInfo.setFont(Font.font("Times New Roman", 20));

        //First Name Label
        Label firstNameText = new Label("First Name:");
        firstNameText.setFont(Font.font("Times New Roman", 16));
        //First Name TextField
        TextField firstName = new TextField();
        firstName.setPromptText("First Name");
        firstName.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        firstName.setEditable(false);

        //Last Name Label
        Label lastNameText = new Label("Last Name:");
        lastNameText.setFont(Font.font("Times New Roman", 16));
        //Last Name textField
        TextField lastName = new TextField();
        lastName.setPromptText("Last Name");
        lastName.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        lastName.setEditable(false);

        //Address Label
        Label addressText = new Label("Address:");
        addressText.setFont(Font.font("Times New Roman", 16));
        //Address Textfield
        TextField address = new TextField();
        address.setPromptText("Address");
        address.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        address.setEditable(false);

        //City Label
        Label cityText = new Label("City:");
        cityText.setFont(Font.font("Times New Roman", 16));
        //City Textfield
        TextField city = new TextField();
        city.setPromptText("City");
        city.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        city.setEditable(false);

        //Province Label
        Label provinceText = new Label("Province:");
        provinceText.setFont(Font.font("Times New Roman", 16));
        //Province Textfield
        comboProvince.setItems(FXCollections.observableArrayList(provinceMap));
        comboProvince.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        comboProvince.setEditable(false);
        comboProvince.setDisable(true);
        TextField comboProvinceTextField = new TextField();
        comboProvinceTextField.setText(FXCollections.observableArrayList(provinceMap).toString());
        comboProvinceTextField.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        comboProvinceTextField.setEditable(false);

        //Email Label
        Label emailText = new Label("Email:");
        emailText.setFont(Font.font("Times New Roman", 16));
        //Email Textfield
        TextField email = new TextField();
        email.setPromptText("example@company.com");
        email.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        email.setEditable(false);

        //Postal Code Label
        Label postalCodeText = new Label("Postal Code:");
        postalCodeText.setFont(Font.font("Times New Roman", 16));
        //Postal Code Textfield
        TextField postalCode = new TextField();
        postalCode.setPromptText("A1B2C3");
        postalCode.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        postalCode.setEditable(false);

        //Phone number Label
        Label phoneNumText = new Label("Phone Number:");
        phoneNumText.setFont(Font.font("Times New Roman", 16));
        //Phone number textfield
        TextField phoneNum = new TextField();
        phoneNum.setPromptText("(555)555-5555");
        phoneNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        phoneNum.setEditable(false);


        /**
         * Right side of the form is the vehicle information
         */

        //Vehicle info title
        Text vehicleInfo = new Text("Vehicle Information");
        vehicleInfo.setFont(Font.font("Times New Roman", 20));

        //Vin num Label
        Label vinNumText = new Label("VIN Number:");
        vinNumText.setFont(Font.font("Times New Roman", 16));
        //Vin Number textfield
        TextField vinNum = new TextField();
        vinNum.setPromptText("Vehicle Identification Number");
        vinNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        vinNum.setEditable(false);

        //Brand label
        Label brandText = new Label("Brand:");
        brandText.setFont(Font.font("Times New Roman", 16));
        //Brand ComboBox
        comboBrand.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        comboBrand.setItems(FXCollections.observableArrayList(vehicleMap.keySet()));
        //Set the drop down menu to the vehicleMap's key values
        comboBrand.setEditable(false);
        comboBrand.setDisable(true);
        TextField comboBrandTextField = new TextField();
        comboBrandTextField.setText(FXCollections.observableArrayList(vehicleMap.keySet()).toString());
        comboBrandTextField.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        comboBrandTextField.setEditable(false);

        //Model Label
        Label modelText = new Label("Model:");
        modelText.setFont(Font.font("Times New Roman", 16));
        //Model ComboBox
        //comboModel.setItems(FXCollections.observableArrayList(vehicleMap.values()));
        comboModel.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        comboModel.setEditable(false);
        comboModel.setDisable(true);
        TextField comboModelTextField = new TextField();
        comboModelTextField.setText(FXCollections.observableArrayList(vehicleMap.values()).toString());
        comboModelTextField.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        comboModelTextField.setEditable(false);

        //Year Text
        Label yearText = new Label("Year:");
        yearText.setFont(Font.font("Times New Roman", 16));
        //Year Textfield
        TextField year = new TextField();
        year.setPromptText("Vehicle Year");
        year.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        year.setEditable(false);

        //Kilometers Text
        Label kilometersText = new Label("Kilometers:");
        kilometersText.setFont(Font.font("Times New Roman", 16));
        //Kilometers Textfield
        TextField kilometers = new TextField();
        kilometers.setPromptText("Vehicle Kilometers");
        kilometers.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        kilometers.setEditable(false);

        //Service box where the issues are placed
        Label issueText = new Label("Please write the issue the customer is having with their vehicle:");
        issueText.setFont(Font.font("Times New Roman", 20));
        issueText.setPadding(new Insets(10,0,0,0));

        TextArea issue = new TextArea();
        issue.setPromptText("Explain issue with the vehicle");
        //issue.setMaxWidth(200);
        //issue.setMaxSize(200,300);
        issue.setWrapText(true);

        //submit button
        Button submit = new Button("Submit Work Order");

        //Update the customer box
        updateCustomerBox.getChildren().addAll(customerInfo, firstNameText, firstName, lastNameText, lastName, addressText, address, cityText, city, provinceText, comboProvince, postalCodeText, postalCode, emailText, email, phoneNumText, phoneNum);
        updateCustomerBox.setSpacing(5);

        //Adds all the different listviews to the pane
        addVehicleBox.getChildren().addAll(vehicleInfo, vinNumText, vinNum, brandText, comboBrand, modelText, comboModel, yearText, year, kilometersText, kilometers);
        addVehicleBox.setSpacing(10);
        addVehicleBox.setVisible(false);

        vehicleList.setPadding(new Insets(0,10,0,10));
        vehicleList.setAlignment(Pos.CENTER);
        vehicleList.getChildren().addAll(vehListViewText, vehicleListView, issueText, issue, submit);


        customerVehicles = custVehTable.getVehicleCustomers(customer.getId());
        vehicles.clear();
        customerVehicles.forEach(n-> {
            Vehicles vehicleHolder = vehTable.getVehicle(n.getVehicleid());
            if(vehicleHolder.getDeleted() == 0) {
                vehicles.add(vehicleHolder);
            }
        });

        vehicleListView.setItems(FXCollections.observableArrayList(vehicles));
        vehicleListView.setPrefHeight(200);
        addVehicleBox.setVisible(false);
        warning.setVisible(false);

        vehicleListView.setOnMouseClicked(e-> {
            if(!vehicleListView.getSelectionModel().isEmpty()) {
                vehicle = vehicleListView.getSelectionModel().getSelectedItem();
                vinNum.setText(vehicle.getVin());
                comboBrand.setValue(vehicle.getBrand());
                comboModel.setValue(vehicle.getModel());
                year.setText(vehicle.getYear());
                kilometers.setText(vehicle.getKilometers());
                vinNumText.setTextFill(Color.BLACK);
                yearText.setTextFill(Color.BLACK);
                brandText.setTextFill(Color.BLACK);
                modelText.setTextFill(Color.BLACK);
                kilometersText.setTextFill(Color.BLACK);
                addVehicleBox.setVisible(true);
                warning.setVisible(false);
            }
        });

        tableView.setRowFactory(tv -> {
            TableRow<Customers> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    customer = row.getItem();
                    customerVehicles = custVehTable.getVehicleCustomers(customer.getId());
                    vehicles.clear();
                    customerVehicles.forEach(e-> {
                        Vehicles vehicleHolder = vehTable.getVehicle(e.getVehicleid());
                        if(vehicleHolder.getDeleted() == 0) {
                            vehicles.add(vehicleHolder);
                        }
                    });
                    firstName.setText(customer.getFirstName());
                    lastName.setText(customer.getLastName());
                    address.setText(customer.getAddress());
                    city.setText(customer.getCity());
                    comboProvince.setValue(customer.getProvince());
                    postalCode.setText(customer.getPostalCode());
                    email.setText(customer.getEmail());
                    phoneNum.setText(customer.getPhoneNumber());
                    vehicleListView.setItems(FXCollections.observableArrayList(vehicles));
                    hBox.setVisible(true);
                    addVehicleBox.setVisible(false);
                    warning.setVisible(false);
                    tableView.setPrefHeight(150);
                }
            });
            return row ;
        });

        hBox.getChildren().addAll(updateCustomerBox, vehicleList, addVehicleBox);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(0, 10, 0, 10));
        hBox.setVisible(false);

        hBox.setAlignment(Pos.CENTER);
        this.setTop(tableAndButtonBox);
        this.setCenter(hBox);
        this.setBottom(warning);
        this.setPadding(new Insets(0, 10, 0, 10));

        newProfile.setOnMouseClicked(e->{
            NewWorkOrderTab newWorkOrderTab = NewWorkOrderTab.getInstance();
            if(!ExistingWorkOrderTab.getInstance().getTabPane().getTabs().contains(newWorkOrderTab)) {
                ExistingWorkOrderTab.getInstance().getTabPane().getTabs().add(newWorkOrderTab);
                ExistingWorkOrderTab.getInstance().getTabPane().getSelectionModel().select(newWorkOrderTab);

                ExistingWorkOrderTab.closeInstance();
            } else {
                ExistingWorkOrderTab.getInstance().getTabPane().getSelectionModel().select(newWorkOrderTab);
            }
        });


        //Once the form is completed
        submit.setOnMouseClicked(e-> {
            try {

                if (issue.getText().length() > 250) {
                    warning.setText("Issue description must be no longer than 250 characters");
                    warning.setVisible(true);
                    issueText.setTextFill(Color.RED);
                } else if (issue.getText().trim().isEmpty()) {
                    warning.setText("Issue cannot be empty");
                    warning.setVisible(true);
                    issueText.setTextFill(Color.RED);
                } else if (tableView.getSelectionModel().isCellSelectionEnabled()) {
                    System.out.println(tableView.getSelectionModel().getSelectedCells());
                } else if(vehicleListView.getSelectionModel().isEmpty()) {
                    vehListViewText.setText("Select a vehicle");
                    vehListViewText.setFill(Color.RED);
                } else {

                    vehListViewText.setText("Vehicle Information");
                    vehListViewText.setFill(Color.BLACK);
                    issueText.setTextFill(Color.BLACK);

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

                    warning.setVisible(false);

                    //Finished the customer info page -
                    // Customer profile is created & work order has been opened for service
                    //Now opens up the open current issue tab
                    System.out.println(formAnswers);

                    java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
                    Workorders workorder = new Workorders(sqlDate.toString(), formAnswers.getIssueMap());
                    workTable.createWorkorder(workorder);
                    ArrayList<Workorders> workorderArray = workTable.getAllWorkorders();

                    VehicleWorkorders vehicleWorkorder = new VehicleWorkorders(vehicle.getId(), workorderArray.get(workorderArray.size() - 1).getId());
                    vehWorkTable.createVehicleWorkorder(vehicleWorkorder);

                    CustomerVehicleIssue customerVehicleIssue = new CustomerVehicleIssue(firstName.getText(), lastName.getText(), comboBrand.getValue(),
                            comboModel.getValue(), workorderArray.get(workorderArray.size() - 1).getId(), issue.getText(), 0);
                    customerVehicleIssueTable.createCustomerVehicleIssue(customerVehicleIssue);

                    //Complete the form and close the instance
                    issue.setText("");

                    ExistingWorkOrderTab.closeInstance();
                }
            } catch(Exception f) {
                warning.setVisible(true);
            }
        });
    }
}


