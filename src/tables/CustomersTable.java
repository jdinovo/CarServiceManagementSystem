package tables;

import dao.CustomersDAO;
import javabean.Customers;
import database.DBConst;
import database.Database;
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

    /**
     *
     * @return customers
     */
    @Override
    public ArrayList<Customers> getAllCustomers() {
        String query = "SELECT * FROM " + DBConst.TABLE_CUSTOMERS;
        customers = new ArrayList<Customers>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                customers.add(new Customers(data.getInt(DBConst.CUSTOMER_COLUMN_ID),
                        data.getString(DBConst.CUSTOMER_COLUMN_FNAME),
                        data.getString(DBConst.CUSTOMER_COLUMN_LNAME),
                        data.getString(DBConst.CUSTOMER_COLUMN_ADDR),
                        data.getString(DBConst.CUSTOMER_COLUMN_CITY),
                        data.getString(DBConst.CUSTOMER_COLUMN_POSTAL),
                        data.getString(DBConst.CUSTOMER_COLUMN_PHONE),
                        data.getString(DBConst.CUSTOMER_COLUMN_EMAIL)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return customers;
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
                    data.getString(DBConst.CUSTOMER_COLUMN_POSTAL),
                    data.getString(DBConst.CUSTOMER_COLUMN_PHONE),
                    data.getString(DBConst.CUSTOMER_COLUMN_EMAIL));
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
                DBConst.CUSTOMER_COLUMN_FNAME + " " + customer.getFirstName() + ", " +
                DBConst.CUSTOMER_COLUMN_LNAME + " " + customer.getLastName() + ", " +
                DBConst.CUSTOMER_COLUMN_ADDR + " " + customer.getAddress() + ", " +
                DBConst.CUSTOMER_COLUMN_CITY + " " + customer.getCity() + ", " +
                DBConst.CUSTOMER_COLUMN_POSTAL + " " + customer.getPostalCode() + ", " +
                DBConst.CUSTOMER_COLUMN_PHONE + " " + customer.getPhoneNumber() + ", " +
                DBConst.CUSTOMER_COLUMN_EMAIL + " " + customer.getEmail() +
                " WHERE " + DBConst.CUSTOMER_COLUMN_ID + " = " + customer.getId();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
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
        String query = "DELET FROM " + DBConst.TABLE_CUSTOMERS + " WHERE " + DBConst.CUSTOMER_COLUMN_ID + " = " + customer.getId();
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
                DBConst.CUSTOMER_COLUMN_POSTAL + ", " +
                DBConst.CUSTOMER_COLUMN_PHONE + ", " +
                DBConst.CUSTOMER_COLUMN_EMAIL + ", " + ") VALUES ('" +
                customer.getFirstName() + "','" +
                customer.getLastName() + "','" +
                customer.getAddress() + "','" +
                customer.getCity() + "','" +
                customer.getPostalCode() + "','" +
                customer.getPhoneNumber() + "','" +
                customer.getEmail() + "')";
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}