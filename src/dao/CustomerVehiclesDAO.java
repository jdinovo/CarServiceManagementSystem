package dao;

import javabean.CustomerVehicles;

import java.util.ArrayList;

public interface CustomerVehiclesDAO {
    public ArrayList<CustomerVehicles> getAllCustomerVehicles();
    public ArrayList<CustomerVehicles> getCustomerVehicles(int customerID);
    public void updateCustomerVehicle(CustomerVehicles customervehicle);
    public void deleteCustomerVehicle(CustomerVehicles customerVehicle);
    public void createCustomerVehicle(CustomerVehicles customerVehicle);
}
