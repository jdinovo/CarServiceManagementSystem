package panes;


import form.ProvinceChoice;
import form.VehicleChoice;
import javabean.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import tables.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * OpenWorkOrderPane contains the GUI for all active open work orders
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/24/2018
 */
public class OpenWorkOrderPane extends BorderPane {

    //Getting access to the data
    private CustomerVehicleIssue customerVehicleIssue = new CustomerVehicleIssue();

    private ArrayList<CustomerVehicleIssue> customerVehicleIssues;
    CustomerVehicleIssueTable customerVehicleIssueTable = new CustomerVehicleIssueTable();

    //Importing the vehicleMap
    Map<String, List<String>> vehicleMap = VehicleChoice.getVehicleModel();
    ArrayList<String> provinceMap = ProvinceChoice.getProvinceModel();

    ListView<Vehicles> vehicleListView = new ListView<>();


    public OpenWorkOrderPane() {

        customerVehicleIssues = customerVehicleIssueTable.getAllOpenCustomerVehicleIssues();

        //Table that will contain the list of all active work orders
        TableView tableView = new TableView<>();
        tableView.setItems(FXCollections.observableArrayList(customerVehicleIssues));

        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(25);

        TableColumn<CustomerVehicleIssue, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<CustomerVehicleIssue, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<CustomerVehicleIssue, String> brandCol = new TableColumn<>("Brand");
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<CustomerVehicleIssue, String> modelCol = new TableColumn<>("Model");
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<CustomerVehicleIssue, Integer> idCol = new TableColumn<>("Work Order ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("customerid"));

        TableColumn<CustomerVehicleIssue, String> issueCol = new TableColumn<>("Issue Desc");
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));

        tableView.getColumns().addAll(firstNameCol,lastNameCol,brandCol,modelCol,idCol,issueCol);


        HBox hbox = new HBox();
        //hbox.getChildren().add(tableView);
        this.setMargin(tableView, new Insets(10));
        this.setCenter(tableView);

    }

}
