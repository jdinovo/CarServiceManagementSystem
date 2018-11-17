package dao;

import javabean.VehicleWorkorders;
import tables.VehiclesTable;

import java.util.ArrayList;

public interface VehicleWorkordersDAO {
    public ArrayList<VehicleWorkorders> getAllVehicleWorkorders();
    public ArrayList<VehicleWorkorders> getVehicleWorkorders(int vehicleId);
    public void createVehicleWorkorder(VehicleWorkorders vehicleWorkorder);
}
