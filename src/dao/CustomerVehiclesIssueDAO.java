package dao;

import javabean.CustomerVehicleIssue;

import java.util.ArrayList;

/**
 *
 * Customer vehicle issue table interface
 *
 * @author Chris Dias
 * @date 11/24/2018
 * @version 1.0
 *
 */
public interface CustomerVehiclesIssueDAO {

    ArrayList<CustomerVehicleIssue> getAllCustomerVehicleIssues();
    ArrayList<CustomerVehicleIssue> getAllOpenCustomerVehicleIssues();
    ArrayList<CustomerVehicleIssue> getAllClosedCustomerVehicleIssues();
    void createCustomerVehicleIssue(CustomerVehicleIssue customerVehicleIssue);
    void updateCustomerVehicleIssue(CustomerVehicleIssue customerVehicleIssue);

}
