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
    ArrayList<CustomerVehicles> getAllCustomerVehicles();
    ArrayList<CustomerVehicles> getCustomerVehicles(int customerID);
    void updateCustomerVehicle(CustomerVehicles customervehicle);
    void deleteCustomerVehicle(CustomerVehicles customerVehicle);
    void createCustomerVehicle(CustomerVehicles customerVehicle);
}
