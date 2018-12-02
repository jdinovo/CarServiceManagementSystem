package panes;

import com.mysql.jdbc.StringUtils;
import form.ProvinceChoice;
import form.VehicleChoice;
import javabean.CustomerVehicles;
import javabean.Customers;
import javabean.Vehicles;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.Const;
import tables.CustomerVehiclesTable;
import tables.CustomersTable;
import tables.VehiclesTable;
import tabs.StatisticsTab;

import java.util.*;

import static main.Const.BODY_FONT;
import static main.Const.HEADER_FONT;
import static main.Const.TEXTFIELD_WIDTH_SIZE;

/**
 *
 * Contains edit customer information gui
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 */
public class EditCustInfoPane extends BorderPane {
    //Importing the vehicleMap
    private Map<String, List<String>> vehicleMap = VehicleChoice.getVehicleModel();
    private ArrayList<String> provinceMap = ProvinceChoice.getProvinceModel();
    private static TableView<Customers> tableView = new TableView<>();

    //ComboBoxes for the form
    private ComboBox<String> comboBrand = new ComboBox<>();
    private ComboBox<String> comboModel = new ComboBox<>();
    private ComboBox<String> comboProvince = new ComboBox<>();

    private Customers customer = new Customers();
    private Vehicles vehicle = new Vehicles();
    private ArrayList<Customers> customers;
    private ArrayList<CustomerVehicles> customerVehicles = new ArrayList<>();
    private ArrayList<Vehicles> vehicles = new ArrayList<>();

    private ListView<Vehicles> vehicleListView = new ListView<>();

    private static CustomersTable custTable = new CustomersTable();

    public EditCustInfoPane() {

        //declaring variables
        Text warning = new Text("Error!");
        warning.setVisible(false);
        warning.setFill(Color.RED);

        //get access to table classes
        VehiclesTable vehTable = new VehiclesTable();
        CustomerVehiclesTable custVehTable = new CustomerVehiclesTable();

        customers = custTable.getAllActiveCustomers();

        //create and show pop up to get phone number to query db with
        TextInputDialog dialog = new TextInputDialog();
        dialog.getEditor().setPromptText("(555)555-5555");

        dialog.setTitle("Find Customer");
        dialog.setHeaderText("Enter the customer's phone number and click OK to find their information.\nClick CANCEL to see all customers.");
        dialog.setContentText("Phone Number:");


        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                dialog.getDialogPane().lookupButton(ButtonType.OK).requestFocus();
            }
        });

        Optional<String> result = dialog.showAndWait();


        result.ifPresent(n-> {
            final String number = n.trim();
            System.out.println("phone number: " + number);
            if(!number.isEmpty()) {
                customers.clear();
                custTable.getAllActiveCustomers().forEach(e -> {
                    if (e.getPhoneNumber().equals(number)) {
                        customers.add(e);
                    }
                });
            }
        });

        tableView = new TableView<>();
        tableView.setItems(FXCollections.observableArrayList(customers));

        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(25);
        tableView.setPrefHeight(675);

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

        /**********************************************************
         * EDIT FORM
         ***********************************************************/

        HBox hBox = new HBox();
        VBox updateCustomerBox = new VBox();
        VBox addVehicleBox = new VBox();
        VBox vehicleList = new VBox();

        //Customer info title
        Text customerInfo = new Text("Customer Information");
        customerInfo.setFont(HEADER_FONT);

        //First Name Label
        Label firstNameText = new Label("First Name:");
        firstNameText.setFont(BODY_FONT);

        //First Name TextField
        TextField firstName = new TextField();
        firstName.setPromptText("First Name");
        firstName.setMaxWidth(TEXTFIELD_WIDTH_SIZE);


        //Last Name Label
        Label lastNameText = new Label("Last Name:");
        lastNameText.setFont(BODY_FONT);

        //Last Name textField
        TextField lastName = new TextField();
        lastName.setPromptText("Last Name");
        lastName.setMaxWidth(TEXTFIELD_WIDTH_SIZE);


        //Address Label
        Label addressText = new Label("Address:");
        addressText.setFont(BODY_FONT);

        //Address Textfield
        TextField address = new TextField();
        address.setPromptText("Address");
        address.setMaxWidth(TEXTFIELD_WIDTH_SIZE);


        //City Label
        Label cityText = new Label("City:");
        cityText.setFont(BODY_FONT);

        //City Textfield
        TextField city = new TextField();
        city.setPromptText("City");
        city.setMaxWidth(TEXTFIELD_WIDTH_SIZE);

        //Province Label
        Label provinceText = new Label("Province:");
        provinceText.setFont(BODY_FONT);

        //Province Textfield
        comboProvince.setItems(FXCollections.observableArrayList(provinceMap));
        comboProvince.setMaxWidth(TEXTFIELD_WIDTH_SIZE);

        //Email Label
        Label emailText = new Label("Email:");
        emailText.setFont(BODY_FONT);

        //Email Textfield
        TextField email = new TextField();
        email.setPromptText("example@company.com");
        email.setMaxWidth(TEXTFIELD_WIDTH_SIZE);


        //Postal Code Label
        Label postalCodeText = new Label("Postal Code:");
        postalCodeText.setFont(BODY_FONT);

        //Postal Code Textfield
        TextField postalCode = new TextField();
        postalCode.setPromptText("A1B2C3");
        postalCode.setMaxWidth(TEXTFIELD_WIDTH_SIZE);


        //Phone number Label
        Label phoneNumText = new Label("Phone Number:");
        phoneNumText.setFont(BODY_FONT);

        //Phone number textfield
        TextField phoneNum = new TextField();
        phoneNum.setPromptText("(555)555-5555");
        phoneNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);

        //Vehicle info title
        Text vehicleInfo = new Text("Add New Vehicle");
        vehicleInfo.setFont(HEADER_FONT);

        //Vin num Label
        Label vinNumText = new Label("VIN Number:");
        vinNumText.setFont(BODY_FONT);

        //Vin Number textfield
        TextField vinNum = new TextField();
        vinNum.setPromptText("Vehicle Identification Number");
        vinNum.setMaxWidth(TEXTFIELD_WIDTH_SIZE);

        //Brand label
        Label brandText = new Label("Brand:");
        brandText.setFont(BODY_FONT);

        //Brand ComboBox
        comboBrand.setMaxWidth(TEXTFIELD_WIDTH_SIZE);
        //Set the drop down menu to the vehicleMap's key values
        comboBrand.setItems(FXCollections.observableArrayList(vehicleMap.keySet()));
        comboBrand.setOnMouseClicked(e-> {
            comboModel.setValue("");
        });
        comboModel.setOnMouseClicked(e->{
            for (Map.Entry<String, List<String>> pair : vehicleMap.entrySet()) {
                if(pair.getKey().equals(comboBrand.getValue())) {
                    comboModel.setItems(FXCollections.observableList(pair.getValue()));
                }
            }
        });

        //Model Label
        Label modelText = new Label("Model:");
        modelText.setFont(BODY_FONT);

        //Model ComboBox
        comboModel.setMaxWidth(TEXTFIELD_WIDTH_SIZE);


        //Year Text
        Label yearText = new Label("Year:");
        yearText.setFont(BODY_FONT);

        TextField year = new TextField();
        year.setPromptText("Vehicle Year");
        year.setMaxWidth(TEXTFIELD_WIDTH_SIZE);

        //Email
        Label kilometersText = new Label("Kilometers:");
        kilometersText.setFont(BODY_FONT);

        TextField kilometers = new TextField();
        kilometers.setPromptText("Vehicle Kilometers");
        kilometers.setMaxWidth(TEXTFIELD_WIDTH_SIZE);

        Button updateCust = new Button("Update Info");
        updateCust.setOnAction(e-> {
            firstNameText.setTextFill(Color.BLACK);
            lastNameText.setTextFill(Color.BLACK);
            addressText.setTextFill(Color.BLACK);
            cityText.setTextFill(Color.BLACK);
            provinceText.setTextFill(Color.BLACK);
            emailText.setTextFill(Color.BLACK);
            postalCodeText.setTextFill(Color.BLACK);
            phoneNumText.setTextFill(Color.BLACK);
            warning.setText("You have an empty textfield! Please fill out the entire form!");
            if (firstName.getText().trim().isEmpty()) {
                firstNameText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (lastName.getText().trim().isEmpty()) {
                lastNameText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (address.getText().trim().isEmpty()) {
                addressText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (city.getText().trim().isEmpty()) {
                cityText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (comboProvince.getValue().isEmpty()) {
                provinceText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (email.getText().trim().isEmpty()) {
                emailText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (postalCode.getText().trim().isEmpty()) {
                postalCodeText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (phoneNum.getText().trim().isEmpty()) {
                phoneNumText.setTextFill(Color.RED);
                warning.setVisible(true);
            } else if (!email.getText().trim().matches("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
                warning.setText("Please make sure email follows example@company.com");
                warning.setVisible(true);
                emailText.setTextFill(Color.RED);
            } else if (postalCode.getText().trim().length() > 6) {
                warning.setText("Please make sure your postal code follows A0B1C0");
                warning.setVisible(true);
                postalCodeText.setTextFill(Color.RED);
            } else if (phoneNum.getText().trim().length() > 15 || !phoneNum.getText().matches("\\(\\d{3}\\)\\d{3}-?\\d{4}")) {
                warning.setText("Please make sure your phone number follows (555)555-5555");
                warning.setVisible(true);
                phoneNumText.setTextFill(Color.RED);
            } else {
                customer.setFirstName(firstName.getText().trim());
                customer.setLastName(lastName.getText().trim());
                customer.setAddress(address.getText().trim());
                customer.setCity(city.getText().trim());
                customer.setProvince(comboProvince.getValue());
                customer.setPostalCode(postalCode.getText().trim());
                customer.setEmail(email.getText().trim());
                customer.setPhoneNumber(phoneNum.getText().trim());

                FadeTransition fade = new FadeTransition(Duration.millis(500), hBox);
                fade.setFromValue(1);
                fade.setToValue(0);
                fade.setCycleCount(1);
                fade.setAutoReverse(false);
                fade.play();
                fade.setOnFinished(a-> {
                    hBox.setVisible(false);
                    tableView.setPrefHeight(675);
                });

                warning.setVisible(false);
                custTable.updateCustomer(customer);
                tableView.refresh();
                ExistingCustNewWorkOrderPane.refreshTable();
                OpenWorkOrderPane.refreshTable();
                ClosedWorkOrderPane.refreshTable();
            }

        });

        Button addVehicle = new Button("Add New Vehicle");
        Button add = new Button("Add");
        Button cancel = new Button("Cancel");
        Button delVehicle = new Button("Delete Vehicle");
        delVehicle.setOnAction(e-> {
            Vehicles vehicle = vehicleListView.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("");
            alert.setGraphic(null);
            alert.setContentText("Are you sure you want to delete this vehicle?");
            if(!vehicleListView.getSelectionModel().isEmpty()) {
                if (alert.showAndWait().get() == ButtonType.OK) {
                    vehTable.deleteVehicle(vehicle);
                    customerVehicles = custVehTable.getVehicleCustomers(customer.getId());
                    vehicles.clear();
                    customerVehicles.forEach(n -> {
                        Vehicles vehicleHolder = vehTable.getVehicle(n.getVehicleid());
                        if(vehicleHolder.getDeleted() == 0) {
                            vehicles.add(vehicleHolder);
                        }
                        addVehicleBox.setVisible(false);
                    });
                    ExistingCustNewWorkOrderPane.refreshTable();
                    vehicleListView.setItems(FXCollections.observableArrayList(vehicles));
                    OpenWorkOrderPane.refreshTable();
                    ClosedWorkOrderPane.refreshTable();
                }
            }
        });
        Button deleteCustomer = new Button("Delete Customer");

        //Vehicle list view title
        Text vehListViewText = new Text("Vehicle Information");
        vehListViewText.setFont(HEADER_FONT);

        HBox custInfoButtons = new HBox();
        custInfoButtons.setSpacing(10);
        custInfoButtons.setAlignment(Pos.CENTER);
        custInfoButtons.getChildren().addAll(updateCust, deleteCustomer);
        updateCustomerBox.getChildren().addAll(customerInfo, firstNameText, firstName, lastNameText, lastName, addressText, address, cityText, city, provinceText, comboProvince, postalCodeText, postalCode, emailText, email, phoneNumText, phoneNum, custInfoButtons);
        updateCustomerBox.setSpacing(5);
        //updateCustomerBox.setBorder(new Border());

        HBox addVehicleButtons = new HBox();
        addVehicleButtons.getChildren().addAll(add, cancel);
        addVehicleButtons.setAlignment(Pos.CENTER);
        addVehicleButtons.setSpacing(10);
        addVehicleBox.getChildren().addAll(vehicleInfo, vinNumText, vinNum, brandText, comboBrand, modelText, comboModel, yearText, year, kilometersText, kilometers, addVehicleButtons);
        addVehicleBox.setSpacing(10);
        addVehicleBox.setVisible(false);

        HBox vehicleListButtons = new HBox(addVehicle, delVehicle);
        vehicleListButtons.setSpacing(10);
        vehicleListButtons.setAlignment(Pos.CENTER);
        vehicleList.getChildren().addAll(vehListViewText, vehicleListView, vehicleListButtons);

        hBox.getChildren().addAll(updateCustomerBox, vehicleList, addVehicleBox);
        //hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(25);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setVisible(false);

        deleteCustomer.setOnAction(e-> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("");
            alert.setGraphic(null);
            alert.setContentText("Are you sure you want to delete this customer?");
            if (alert.showAndWait().get() == ButtonType.OK) {
                custTable.deleteCustomer(customer);
                vehicles.forEach(v-> {
                    vehTable.deleteVehicle(v);
                });
                customers.clear();
                customers = custTable.getAllActiveCustomers();
                tableView.setItems(FXCollections.observableArrayList(customers));
                tableView.refresh();
                FadeTransition fade = new FadeTransition(Duration.millis(500), hBox);
                fade.setFromValue(1);
                fade.setToValue(0);
                fade.setCycleCount(1);
                fade.setAutoReverse(false);
                fade.play();
                fade.setOnFinished(a-> {
                    hBox.setVisible(false);
                    tableView.setPrefHeight(675);
                });
                ExistingCustNewWorkOrderPane.refreshTable();
                OpenWorkOrderPane.refreshTable();
                ClosedWorkOrderPane.refreshTable();
                StatisticsTab.generateChart();
            }

        });

        addVehicle.setOnAction(e-> {
            vehicleInfo.setText("Add New Vehicle");
            vinNumText.setTextFill(Color.BLACK);
            yearText.setTextFill(Color.BLACK);
            brandText.setTextFill(Color.BLACK);
            modelText.setTextFill(Color.BLACK);
            kilometersText.setTextFill(Color.BLACK);
            vinNum.setText("");
            comboBrand.setValue("");
            comboModel.setValue("");
            year.setText("");
            kilometers.setText("");
            FadeTransition fade = new FadeTransition(Duration.millis(500), addVehicleBox);
            fade.setFromValue(.1);
            fade.setToValue(1);
            fade.setCycleCount(1);
            fade.setAutoReverse(false);
            fade.play();
            addVehicleBox.setVisible(true);
            warning.setVisible(false);
            add.setText("Add");
        });
        cancel.setOnAction(e-> {
            FadeTransition fade = new FadeTransition(Duration.millis(500), addVehicleBox);
            fade.setFromValue(1);
            fade.setToValue(0);
            fade.setCycleCount(1);
            fade.setAutoReverse(false);
            fade.play();
            fade.setOnFinished(a-> {
                addVehicleBox.setVisible(false);
                warning.setVisible(false);
            });
        });

        add.setOnAction(e-> {
            if(vinNum.getText().trim().isEmpty()) {
                warning.setText("VIN cannot be left empty");
                warning.setVisible(true);
                vinNumText.setTextFill(Color.RED);
            } else if (comboBrand.getValue().isEmpty()) {
                warning.setText("You must select a brand");
                warning.setVisible(true);
                brandText.setTextFill(Color.RED);
            } else if (comboModel.getValue().isEmpty()) {
                warning.setText("You must select a model");
                warning.setVisible(true);
                modelText.setTextFill(Color.RED);
            } else if (year.getText().trim().isEmpty()) {
                warning.setText("Year cannot be left empty");
                warning.setVisible(true);
                yearText.setTextFill(Color.RED);
            } else if (kilometers.getText().trim().isEmpty()) {
                warning.setText("Kilometers cannot be left empty");
                warning.setVisible(true);
                kilometersText.setTextFill(Color.RED);
            }  else if (vinNum.getText().trim().length() > 17) {
                warning.setText("VIN cannot be longer than 17 characters");
                warning.setVisible(true);
                vinNumText.setTextFill(Color.RED);
            } else if (year.getText().trim().length() > 4 || !StringUtils.isStrictlyNumeric(year.getText())) {
                warning.setText("Year cannot be longer than 4 digits");
                warning.setVisible(true);
                yearText.setTextFill(Color.RED);
            } else if (!StringUtils.isStrictlyNumeric(kilometers.getText()) || kilometers.getText().trim().length() > 7) {
                warning.setText("Kilometers must be numeric");
                warning.setVisible(true);
                kilometersText.setTextFill(Color.RED);
            } else {
                if(add.getText().equals("Add")) {
                    vehTable.createVehicle(new Vehicles(vinNum.getText().trim(), comboBrand.getValue(), comboModel.getValue(), year.getText().trim(), kilometers.getText().trim()));
                    ArrayList<Vehicles> vehArray = vehTable.getAllVehicles();
                    custVehTable.createCustomerVehicle(new CustomerVehicles(customer.getId(), vehArray.get(vehArray.size() - 1).getId()));

                    vehicles.add(vehTable.getVehicle(vehArray.get(vehArray.size() - 1).getId()));
                } else {
                    vehicle.setVin(vinNum.getText().trim());
                    vehicle.setBrand(comboBrand.getValue());
                    vehicle.setModel(comboModel.getValue());
                    vehicle.setYear(year.getText().trim());
                    vehicle.setKilometers(kilometers.getText().trim());
                    vehTable.updateVehicle(vehicle);
                }

                customerVehicles = custVehTable.getVehicleCustomers(customer.getId());
                vehicles.clear();
                customerVehicles.forEach(n-> {
                    Vehicles vehicleHolder = vehTable.getVehicle(n.getVehicleid());
                    if(vehicleHolder.getDeleted() == 0) {
                        vehicles.add(vehicleHolder);
                    }
                });
                vehicleListView.setItems(FXCollections.observableArrayList(vehicles));
                FadeTransition fade = new FadeTransition(Duration.millis(500), addVehicleBox);
                fade.setFromValue(1);
                fade.setToValue(0);
                fade.setCycleCount(1);
                fade.setAutoReverse(false);
                fade.play();
                fade.setOnFinished(a-> {
                    addVehicleBox.setVisible(false);
                    warning.setVisible(false);
                });
                StatisticsTab.generateBarChart();
                ExistingCustNewWorkOrderPane.refreshTable();
            }
        });

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
                add.setText("Update");
                vehicleInfo.setText("Update Vehicle");
                FadeTransition fade = new FadeTransition(Duration.millis(500), addVehicleBox);
                fade.setFromValue(.1);
                fade.setToValue(1);
                fade.setCycleCount(1);
                fade.setAutoReverse(false);
                fade.play();
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
                    tableView.setPrefHeight(150);
                    firstName.setText(customer.getFirstName());
                    lastName.setText(customer.getLastName());
                    address.setText(customer.getAddress());
                    city.setText(customer.getCity());
                    comboProvince.setValue(customer.getProvince());
                    postalCode.setText(customer.getPostalCode());
                    email.setText(customer.getEmail());
                    phoneNum.setText(customer.getPhoneNumber());
                    vehicleListView.setItems(FXCollections.observableArrayList(vehicles));
                    FadeTransition fade = new FadeTransition(Duration.millis(500), hBox);
                    fade.setFromValue(.1);
                    fade.setToValue(1);
                    fade.setCycleCount(1);
                    fade.setAutoReverse(false);
                    fade.play();
                    hBox.setVisible(true);
                    addVehicleBox.setVisible(false);
                    warning.setVisible(false);
                }
            });
            return row ;
        });

        hBox.setAlignment(Pos.CENTER);
        this.setTop(tableView);
        this.setCenter(warning);
        this.setBottom(hBox);
        this.setPadding(new Insets(10, 10, 10, 10));


    }

    /**
     * refreshes table displayed in this pane
     *
     * @author James DiNovo
     * @date 02.12.2018
     */
    public static void refreshTable() {
        tableView.setItems(FXCollections.observableArrayList(custTable.getAllActiveCustomers()));
        tableView.refresh();
    }
}
