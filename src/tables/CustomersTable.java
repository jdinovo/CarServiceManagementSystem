package tables;

import dao.CustomersDAO;
import javabean.Customers;
import database.DBConst;
import database.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * CustomersTable class declaration and implementation
 *
 * @author Dorian Harusha
 * @date 11.11.2018
 * @version 1.0
 *
 */

public class CustomersTable implements CustomersDAO {
    Database db = Database.getInstance();
    ArrayList<Customers> customers = new ArrayList<Customers>();

    private ArrayList<Customers> getAllFromDB(String query) {
        customers = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                customers.add(new Customers(data.getInt(DBConst.CUSTOMER_COLUMN_ID),
                        data.getString(DBConst.CUSTOMER_COLUMN_FNAME),
                        data.getString(DBConst.CUSTOMER_COLUMN_LNAME),
                        data.getString(DBConst.CUSTOMER_COLUMN_ADDR),
                        data.getString(DBConst.CUSTOMER_COLUMN_CITY),
                        data.getString(DBConst.CUSTOMER_COLUMN_PROVINCE),
                        data.getString(DBConst.CUSTOMER_COLUMN_POSTAL),
                        data.getString(DBConst.CUSTOMER_COLUMN_PHONE),
                        data.getString(DBConst.CUSTOMER_COLUMN_EMAIL),
                        data.getInt(DBConst.CUSTOMER_COLUMN_DELETED)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    /**
     *
     * @return customers
     */
    @Override
    public ArrayList<Customers> getAllCustomers() {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMERS;
        return getAllFromDB(query);
    }

    /**
     *
     * @return customers
     */
    public ArrayList<Customers> getAllActiveCustomers() {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMERS + " WHERE " + DBConst.CUSTOMER_COLUMN_DELETED + " = '0'";
        return getAllFromDB(query);
    }

    /**
     *
     * @param customerID
     * @return customer
     */
    @Override
    public Customers getCustomer(int customerID) {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMERS + " WHERE " + DBConst.CUSTOMER_COLUMN_ID + " = " + customerID;
        Customers customer = new Customers();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            customer = new Customers(data.getInt(DBConst.CUSTOMER_COLUMN_ID),
                    data.getString(DBConst.CUSTOMER_COLUMN_FNAME),
                    data.getString(DBConst.CUSTOMER_COLUMN_LNAME),
                    data.getString(DBConst.CUSTOMER_COLUMN_ADDR),
                    data.getString(DBConst.CUSTOMER_COLUMN_CITY),
                    data.getString(DBConst.CUSTOMER_COLUMN_PROVINCE),
                    data.getString(DBConst.CUSTOMER_COLUMN_POSTAL),
                    data.getString(DBConst.CUSTOMER_COLUMN_PHONE),
                    data.getString(DBConst.CUSTOMER_COLUMN_EMAIL),
                    data.getInt(DBConst.CUSTOMER_COLUMN_DELETED));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    /**
     *
     * @param customer
     */
    @Override
    public void updateCustomer(Customers customer) {
        String query = "UPDATE " + DBConst.TABLE_CUSTOMERS + " SET "  +
                DBConst.CUSTOMER_COLUMN_FNAME + " = ?, " +
                DBConst.CUSTOMER_COLUMN_LNAME + " = ?, " +
                DBConst.CUSTOMER_COLUMN_ADDR + " = ?, " +
                DBConst.CUSTOMER_COLUMN_CITY + " = ?, " +
                DBConst.CUSTOMER_COLUMN_PROVINCE + " = ?, " +
                DBConst.CUSTOMER_COLUMN_POSTAL + " = ?, " +
                DBConst.CUSTOMER_COLUMN_PHONE + " = ?, " +
                DBConst.CUSTOMER_COLUMN_EMAIL + " = ? WHERE " + DBConst.CUSTOMER_COLUMN_ID + " = " + customer.getId();
        try {
            PreparedStatement updateItem = db.getConnection().prepareStatement(query);
            updateItem.setString(1, customer.getFirstName());
            updateItem.setString(2, customer.getLastName());
            updateItem.setString(3, customer.getAddress());
            updateItem.setString(4, customer.getCity());
            updateItem.setString(5, customer.getProvince());
            updateItem.setString(6, customer.getPostalCode());
            updateItem.setString(7, customer.getPhoneNumber());
            updateItem.setString(8, customer.getEmail());
            updateItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param customer
     */
    @Override
    public void deleteCustomer(Customers customer) {
        //String query = "DELETE FROM " + DBConst.TABLE_CUSTOMERS + " WHERE " + DBConst.CUSTOMER_COLUMN_ID + " = " + customer.getId();
        String query = "UPDATE " + DBConst.TABLE_CUSTOMERS + " SET " + DBConst.CUSTOMER_COLUMN_DELETED + " = '1' WHERE " + DBConst.CUSTOMER_COLUMN_ID + " = " + customer.getId();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param customer
     */
    @Override
    public void createCustomer(Customers customer) {
        String query = "INSERT INTO " + DBConst.TABLE_CUSTOMERS +
                " (" + DBConst.CUSTOMER_COLUMN_FNAME + ", " +
                DBConst.CUSTOMER_COLUMN_LNAME + ", " +
                DBConst.CUSTOMER_COLUMN_ADDR + ", " +
                DBConst.CUSTOMER_COLUMN_CITY + ", " +
                DBConst.CUSTOMER_COLUMN_PROVINCE + ", " +
                DBConst.CUSTOMER_COLUMN_POSTAL + ", " +
                DBConst.CUSTOMER_COLUMN_PHONE + ", " +
                DBConst.CUSTOMER_COLUMN_EMAIL + ", " +
                DBConst.CUSTOMER_COLUMN_DELETED + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement createItem = db.getConnection().prepareStatement(query);
            createItem.setString(1, customer.getFirstName());
            createItem.setString(2, customer.getLastName());
            createItem.setString(3, customer.getAddress());
            createItem.setString(4, customer.getCity());
            createItem.setString(5, customer.getProvince());
            createItem.setString(6, customer.getPostalCode());
            createItem.setString(7, customer.getPhoneNumber());
            createItem.setString(8, customer.getEmail());
            createItem.setInt(9, customer.getDeleted());
            createItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}