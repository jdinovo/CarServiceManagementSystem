package dao;

import javabean.VehicleWorkorders;

import java.util.ArrayList;

/**
 *
 * Vehicle workorder interface
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public interface VehicleWorkordersDAO {
    public ArrayList<VehicleWorkorders> getAllVehicleWorkorders();
    public ArrayList<VehicleWorkorders> getVehicleWorkorders(int vehicleId);
    public void createVehicleWorkorder(VehicleWorkorders vehicleWorkorder);
    public void updateVehicleWorkorders(VehicleWorkorders vehicleWorkorder);
    public void deleteVehicleWorkorders(VehicleWorkorders vehicleWorkorder);
}
