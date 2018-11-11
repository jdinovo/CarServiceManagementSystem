package dao;

import javabean.Vehicles;
import java.util.ArrayList;

/**
 *
 * VehiclesDAO Interface declaration
 *
 * @author Dorian Harusha
 * @date 11.11.2018
 * @version 1.0
 *
 */

public interface VehiclesDAO {
    public ArrayList<Vehicles> getAllVehicles();
    public Vehicles getVehicle(int vehicleID);
    public void updateVehicle(Vehicles vehicle);
    public void deleteVehicle(Vehicles vehicle);
    public void createVehicle(Vehicles vehicle);
}
