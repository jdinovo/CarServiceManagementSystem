package dao;

import javabean.Customers;
import java.util.ArrayList;

/**
 *
 * CustomerDAO interface declaration
 *
 * @author Dorian Harusha
 * @date 11.11.2018
 * @version 1.0
 *
 */

public interface CustomersDAO {
    public ArrayList<Customers> getAllCustomers();
    public Customers getCustomer(int customerID);
    public void updateCustomer(Customers customer);
    public void deleteCustomer(Customers customer);
    public void createCustomer(Customers customer);
}