package tables;

import dao.CustomerVehiclesDAO;
import database.DBConst;
import database.Database;
import javabean.CustomerVehicles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Represents customer vehicle table
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public class CustomerVehiclesTable implements CustomerVehiclesDAO {
    Database db = Database.getInstance();
    ArrayList<CustomerVehicles> customerVehicles = new ArrayList<>();

    /**
     *
     * @param query
     * @return ArrayList<CustomerVehicles>
     */
    private ArrayList<CustomerVehicles> getCustomerVehiclesDB(String query) {
        customerVehicles = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                customerVehicles.add(new CustomerVehicles(data.getInt(DBConst.CUSTOMER_VEHICLES_COLUMN_CUSTOMER_ID), data.getInt(DBConst.CUSTOMER_VEHICLES_COLUMN_VEHICLE_ID)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return customerVehicles;
    }

    /**
     *
     * @return customers
     */
    @Override
    public ArrayList<CustomerVehicles> getAllCustomerVehicles() {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMER_VEHICLES;
        customerVehicles = new ArrayList<>();
        return getCustomerVehiclesDB(query);
    }

    /**
     *
     * @param vehicleID
     * @return customer
     */
    @Override
    public ArrayList<CustomerVehicles> getCustomerVehicles(int vehicleID) {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMER_VEHICLES + " WHERE " + DBConst.CUSTOMER_VEHICLES_COLUMN_VEHICLE_ID + " = " + vehicleID;
        return getCustomerVehiclesDB(query);
    }

    /**
     *
     * @param customerID
     * @return customerVehicles
     */
    public ArrayList<CustomerVehicles> getVehicleCustomers(int customerID) {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMER_VEHICLES + " WHERE " + DBConst.CUSTOMER_VEHICLES_COLUMN_CUSTOMER_ID + " = " + customerID;
        return getCustomerVehiclesDB(query);
    }

    /**
     *
     * @param customerVehicle
     */
    @Override
    public void updateCustomerVehicle(CustomerVehicles customerVehicle) {
        String query = "UPDATE " + DBConst.TABLE_CUSTOMER_VEHICLES + " SET "  +
                DBConst.CUSTOMER_VEHICLES_COLUMN_CUSTOMER_ID + " = " + customerVehicle.getCustomerid() + ", " +
                DBConst.CUSTOMER_VEHICLES_COLUMN_VEHICLE_ID + " = " + customerVehicle.getVehicleid() + ", " +
                " WHERE " + DBConst.CUSTOMER_VEHICLES_COLUMN_CUSTOMER_ID + " = " + customerVehicle.getCustomerid() + " AND " + DBConst.CUSTOMER_VEHICLES_COLUMN_VEHICLE_ID + " = " + customerVehicle.getVehicleid();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param customerVehicle
     */
    @Override
    public void deleteCustomerVehicle(CustomerVehicles customerVehicle) {
        String query = "DELETE FROM " + DBConst.TABLE_CUSTOMER_VEHICLES + " WHERE " + DBConst.CUSTOMER_VEHICLES_COLUMN_CUSTOMER_ID + " = " + customerVehicle.getCustomerid();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param customerVehicle
     */
    public void deleteVehicleCustomer(CustomerVehicles customerVehicle) {
        String query = "DELETE FROM " + DBConst.TABLE_CUSTOMER_VEHICLES + " WHERE " + DBConst.CUSTOMER_VEHICLES_COLUMN_VEHICLE_ID + " = " + customerVehicle.getVehicleid();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param customerVehicle
     */
    @Override
    public void createCustomerVehicle(CustomerVehicles customerVehicle) {
        String query = "INSERT INTO " + DBConst.TABLE_CUSTOMER_VEHICLES +
                " (" + DBConst.CUSTOMER_VEHICLES_COLUMN_CUSTOMER_ID+ ", " +
                DBConst.CUSTOMER_VEHICLES_COLUMN_VEHICLE_ID + ") VALUES ('" +
                customerVehicle.getCustomerid() + "','" +
                customerVehicle.getVehicleid() + "')";
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
