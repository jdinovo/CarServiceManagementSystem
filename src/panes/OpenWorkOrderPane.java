package panes;


import form.ProvinceChoice;
import form.VehicleChoice;
import javabean.*;
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
import tables.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static main.Const.HEADER_FONT;

/**
 * OpenWorkOrderPane contains the GUI for all active open work orders
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/24/2018
 */
public class OpenWorkOrderPane extends BorderPane {

    //Getting access to the data
    private static TableView tableView = new TableView();
    private ArrayList<CustomerVehicleIssue> customerVehicleIssues;
    private static CustomerVehicleIssueTable customerVehicleIssueTable = new CustomerVehicleIssueTable();
    private WorkordersTable workordersTable = new WorkordersTable();

    private CustomerVehicleIssue custVehIssue = new CustomerVehicleIssue();
    private Workorders workorder = new Workorders();

    public OpenWorkOrderPane() {

        Text warning = new Text("Work order must be complete before closing!");
        warning.setVisible(false);
        warning.setFill(Color.RED);

        customerVehicleIssues = customerVehicleIssueTable.getAllOpenCustomerVehicleIssues();

        //Table that will contain the list of all active work orders
        tableView = new TableView<>();
        tableView.setItems(FXCollections.observableArrayList(customerVehicleIssues));

        tableView.setEditable(false);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setFixedCellSize(25);
        tableView.setPrefHeight(650);

        TableColumn<CustomerVehicleIssue, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<CustomerVehicleIssue, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<CustomerVehicleIssue, String> brandCol = new TableColumn<>("Brand");
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<CustomerVehicleIssue, String> modelCol = new TableColumn<>("Model");
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<CustomerVehicleIssue, Integer> idCol = new TableColumn<>("Work Order ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("workOrderId"));

        TableColumn<CustomerVehicleIssue, String> issueCol = new TableColumn<>("Issue Desc");
        issueCol.setCellValueFactory(new PropertyValueFactory<>("issue"));

        tableView.getColumns().addAll(firstNameCol,lastNameCol,brandCol,modelCol,idCol,issueCol);

        Label issueText = new Label("Customer Issue:");
        issueText.setFont(HEADER_FONT);

        TextArea issue = new TextArea();
        issue.setPromptText("Customer's issue...");
        issue.setPrefSize(400,200);
        issue.setWrapText(true);

        VBox issueBox = new VBox();
        issueBox.getChildren().addAll(issueText, issue);

        Label causeText = new Label("Cause Of Issue:");
        causeText.setFont(HEADER_FONT);

        TextArea cause = new TextArea();
        cause.setPromptText("Cause of the issue...");
        cause.setPrefSize(400,200);
        cause.setWrapText(true);

        VBox causeBox = new VBox();
        causeBox.getChildren().addAll(causeText, cause);

        Label correctionText = new Label("Correction:");
        correctionText.setFont(HEADER_FONT);

        TextArea correction = new TextArea();
        correction.setPromptText("What was done to correct issue...");
        correction.setPrefSize(400,200);
        correction.setWrapText(true);

        VBox correctionBox = new VBox();
        correctionBox.getChildren().addAll(correctionText, correction);

        Button close = new Button("Close Work Order");
        Button update = new Button("Update Work Order");

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(update, close);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(issueBox, causeBox, correctionBox);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        hBox.setVisible(false);

        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setSpacing(10);
        buttonBox.setVisible(false);

        VBox page = new VBox();
        page.getChildren().addAll(tableView, hBox, buttonBox, warning);
        page.setAlignment(Pos.CENTER);

        this.setMargin(page, new Insets(10));
        this.setTop(page);


        update.setOnAction(e-> {
            workorder.setIssue(issue.getText().trim());
            workorder.setCause(cause.getText().trim());
            workorder.setCorrection(correction.getText().trim());
            workordersTable.updateWorkorder(workorder);

            tableView.setPrefHeight(650);
            warning.setVisible(false);
            hBox.setVisible(false);
            buttonBox.setVisible(false);

            tableView.setItems(FXCollections.observableArrayList(customerVehicleIssueTable.getAllOpenCustomerVehicleIssues()));
            tableView.refresh();
        });

        close.setOnAction(e-> {
            if(!issue.getText().trim().isEmpty() && !cause.getText().trim().isEmpty() && !correction.getText().trim().isEmpty()) {
                workorder.setIssue(issue.getText().trim());
                workorder.setCause(cause.getText().trim());
                workorder.setCorrection(correction.getText().trim());
                workorder.setClosed(1);
                workordersTable.updateWorkorder(workorder);
                tableView.setPrefHeight(650);
                warning.setVisible(false);
                hBox.setVisible(false);
                buttonBox.setVisible(false);

                tableView.setItems(FXCollections.observableArrayList(customerVehicleIssueTable.getAllOpenCustomerVehicleIssues()));
                tableView.refresh();
                ClosedWorkOrderPane.refreshTable();
            } else {
                warning.setVisible(true);
            }
        });


        tableView.setRowFactory(tv -> {
            TableRow<CustomerVehicleIssue> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    custVehIssue = row.getItem();
                    workorder = workordersTable.getWorkorder(custVehIssue.getWorkOrderId());

                    issue.setText(workorder.getIssue());
                    cause.setText(workorder.getCause());
                    correction.setText(workorder.getCorrection());

                    hBox.setVisible(true);
                    buttonBox.setVisible(true);
                    tableView.setPrefHeight(150);
                    warning.setVisible(false);
                }
            });
            return row ;
        });

    }

    public static void refreshTable() {
        tableView.setItems(FXCollections.observableArrayList(customerVehicleIssueTable.getAllOpenCustomerVehicleIssues()));
        tableView.refresh();
    }

}
