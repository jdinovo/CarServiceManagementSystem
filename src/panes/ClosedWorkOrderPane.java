package panes;

import javabean.CustomerVehicleIssue;
import javabean.Workorders;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import main.Const;
import tables.CustomerVehicleIssueTable;
import tables.WorkordersTable;

import java.util.ArrayList;

/**
 * ClosedWorkOrderPane contains the GUI for all closed open work orders
 *
 * @author Chris Dias
 * @version 1.0
 * @since 11/26/2018
 */
public class ClosedWorkOrderPane extends BorderPane {

    //Getting access to the data
    private ArrayList<CustomerVehicleIssue> customerVehicleIssues;
    private static CustomerVehicleIssueTable customerVehicleIssueTable = new CustomerVehicleIssueTable();
    private static TableView tableView = new TableView();

    private WorkordersTable workordersTable = new WorkordersTable();

    private Workorders workorder = new Workorders();

    private CustomerVehicleIssue custVehIssue = new CustomerVehicleIssue();

    public ClosedWorkOrderPane() {

        customerVehicleIssues = customerVehicleIssueTable.getAllClosedCustomerVehicleIssues();

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
        issueText.setFont(Const.HEADER_FONT);

        TextArea issue = new TextArea();
        issue.setPromptText("Customer's issue...");
        issue.setPrefSize(400, 200);
        issue.setWrapText(true);
        issue.setEditable(false);

        VBox issueBox = new VBox();
        issueBox.getChildren().addAll(issueText, issue);

        Label causeText = new Label("Cause Of Issue:");
        causeText.setFont(Const.HEADER_FONT);

        TextArea cause = new TextArea();
        cause.setPromptText("Cause of the issue...");
        cause.setPrefSize(400, 200);
        cause.setWrapText(true);
        cause.setEditable(false);

        VBox causeBox = new VBox();
        causeBox.getChildren().addAll(causeText, cause);

        Label correctionText = new Label("Correction:");
        correctionText.setFont(Const.HEADER_FONT);

        TextArea correction = new TextArea();
        correction.setPromptText("What was done to correct issue...");
        correction.setPrefSize(400,200);
        correction.setWrapText(true);
        correction.setEditable(false);

        VBox correctionBox = new VBox();
        correctionBox.getChildren().addAll(correctionText, correction);

//        Button print = new Button("Print Work Order");

//        HBox buttonBox = new HBox();
//        buttonBox.getChildren().addAll(print);
//        buttonBox.setVisible(false);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(issueBox, causeBox, correctionBox);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
        hBox.setVisible(false);

//        buttonBox.setAlignment(Pos.TOP_CENTER);
//        buttonBox.setSpacing(10);

        VBox page = new VBox();
        page.getChildren().addAll(tableView, hBox);
        page.setAlignment(Pos.CENTER);

        this.setMargin(page, new Insets(10));
        this.setTop(page);

//        print.setOnAction(e-> {
//
//        });

        tableView.setRowFactory(tv -> {
            TableRow<CustomerVehicleIssue> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    custVehIssue = row.getItem();
                    workorder = workordersTable.getWorkorder(custVehIssue.getWorkOrderId());

                    issue.setText(workorder.getIssue());
                    cause.setText(workorder.getCause());
                    correction.setText(workorder.getCorrection());

                    FadeTransition fade = new FadeTransition(Duration.millis(500), hBox);
                    fade.setFromValue(.1);
                    fade.setToValue(1);
                    fade.setCycleCount(1);
                    fade.setAutoReverse(false);
                    fade.play();

                    hBox.setVisible(true);
//                    buttonBox.setVisible(true);
                    tableView.setPrefHeight(150);
                }
            });
            return row ;
        });
    }

    /**
     * refreshes table displayed in this pane
     *
     * @author James DiNovo
     * @date 02.12.2018
     */
    public static void refreshTable() {

        tableView.setItems(FXCollections.observableArrayList(customerVehicleIssueTable.getAllClosedCustomerVehicleIssues()));
        tableView.refresh();
    }

}
