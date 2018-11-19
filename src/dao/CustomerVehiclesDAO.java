package dao;

import javabean.CustomerVehicles;

import java.util.ArrayList;

/**
 *
 * Customer vehicle table interface
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public interface CustomerVehiclesDAO {
    public ArrayList<CustomerVehicles> getAllCustomerVehicles();
    public ArrayList<CustomerVehicles> getCustomerVehicles(int customerID);
    public void updateCustomerVehicle(CustomerVehicles customervehicle);
    public void deleteCustomerVehicle(CustomerVehicles customerVehicle);
    public void createCustomerVehicle(CustomerVehicles customerVehicle);
}
