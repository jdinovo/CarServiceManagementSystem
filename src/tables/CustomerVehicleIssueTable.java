package tables;

import dao.CustomerVehiclesIssueDAO;
import database.DBConst;
import database.Database;
import javabean.CustomerVehicleIssue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Represents the relationship of customer vehicle issue
 * that will appear in the open and closed work order
 */
public class CustomerVehicleIssueTable implements CustomerVehiclesIssueDAO {

    Database db = Database.getInstance();
    ArrayList<CustomerVehicleIssue> customerVehicleIssues = new ArrayList<>();

    private ArrayList<CustomerVehicleIssue> getCustomerVehicleIssuesDB(String query) {
        customerVehicleIssues = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                customerVehicleIssues.add(new CustomerVehicleIssue(
                        data.getString(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_FNAME),
                        data.getString(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_LNAME),
                        data.getString(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_BRAND),
                        data.getString(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_MODEL),
                        data.getInt(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_WORKORDER_ID),
                        data.getString(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_ISSUE),
                        data.getInt(DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_CLOSED)));
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return customerVehicleIssues;
    }

    /**
     *
     * @return all open work orders
     */
    @Override
    public ArrayList<CustomerVehicleIssue> getAllCustomerVehicleIssues() {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMER_VEHICLE_ISSUE;
        customerVehicleIssues = new ArrayList<>();
        return getCustomerVehicleIssuesDB(query);
    }

    public ArrayList<CustomerVehicleIssue> getAllOpenCustomerVehicleIssues() {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMER_VEHICLE_ISSUE + " WHERE " + DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_CLOSED + " = '0'";
        return getCustomerVehicleIssuesDB(query);
    }

    @Override
    public void createCustomerVehicleIssue(CustomerVehicleIssue customerVehicleIssue) {
        String query = "INSERT INTO " + DBConst.TABLE_CUSTOMER_VEHICLE_ISSUE + " (" +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_FNAME + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_LNAME + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_BRAND + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_MODEL + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_WORKORDER_ID + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_ISSUE + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_CLOSED + ") VALUES ('" +
                customerVehicleIssue.getFirstName() + "','" +
                customerVehicleIssue.getLastName() + "','" +
                customerVehicleIssue.getBrand() + "','" +
                customerVehicleIssue.getModel() + "','" +
                customerVehicleIssue.getCustomerid() + "','" +
                customerVehicleIssue.getIssue() + "','" +
                customerVehicleIssue.getClosed() + "')";
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomerVehicleIssue(CustomerVehicleIssue customerVehicleIssue) {
        String query = "UPDATE " + DBConst.TABLE_CUSTOMER_VEHICLE_ISSUE + " SET " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_FNAME + " " + customerVehicleIssue.getFirstName() + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_LNAME + " " + customerVehicleIssue.getLastName() + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_BRAND + " " + customerVehicleIssue.getBrand() + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_MODEL + " " + customerVehicleIssue.getModel() + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_WORKORDER_ID + " " + customerVehicleIssue.getCustomerid() + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_ISSUE + " " + customerVehicleIssue.getIssue() + ", " +
                DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_CLOSED + " " + customerVehicleIssue.getClosed() +
                " WHERE " + DBConst.CUSTOMER_VEHICLE_ISSUE_COLUMN_WORKORDER_ID + " = " + customerVehicleIssue.getCustomerid();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
