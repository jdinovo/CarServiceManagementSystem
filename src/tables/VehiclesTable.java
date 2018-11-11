package tables;

import dao.VehiclesDAO;
import database.DBConst;
import database.Database;
import javabean.Vehicles;
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

public class VehiclesTable implements VehiclesDAO {
    Database db = Database.getInstance();
    ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();

    @Override
    public ArrayList<Vehicles> getAllVehicles() {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLES;
        vehicles = new ArrayList<Vehicles>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                vehicles.add(new Vehicles(data.getInt(DBConst.VEHICLE_COLUMN_ID),
                        data.getString(DBConst.VEHICLE_COLUMN_VIN),
                        data.getString(DBConst.VEHICLE_COLUMN_BRAND),
                        data.getString(DBConst.VEHICLE_COLUMN_MODEL),
                        data.getString(DBConst.VEHICLE_COLUMN_YEAR),
                        data.getString(DBConst.VEHICLE_COLUMN_KM)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    @Override
    public Vehicles getVehicle(int vehicleID) {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLES + " WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicleID;
        Vehicles vehicle = new Vehicles();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            vehicle = new Vehicles(data.getInt(DBConst.VEHICLE_COLUMN_ID),
                    data.getString(DBConst.VEHICLE_COLUMN_VIN),
                    data.getString(DBConst.VEHICLE_COLUMN_BRAND),
                    data.getString(DBConst.VEHICLE_COLUMN_MODEL),
                    data.getString(DBConst.VEHICLE_COLUMN_YEAR),
                    data.getString(DBConst.VEHICLE_COLUMN_KM));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    @Override
    public void updateVehicle(Vehicles vehicle) {
        String query = "UPDATE " + DBConst.TABLE_VEHICLES + " SET "  +
                DBConst.VEHICLE_COLUMN_VIN + " " + vehicle.getVin() + ", " +
                DBConst.VEHICLE_COLUMN_BRAND + " " + vehicle.getBrand() + ", " +
                DBConst.VEHICLE_COLUMN_MODEL + " " + vehicle.getModel() + ", " +
                DBConst.VEHICLE_COLUMN_YEAR + " " + vehicle.getYear() + ", " +
                DBConst.VEHICLE_COLUMN_KM + " " + vehicle.getKilometers() +
                " WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicle.getId();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVehicle(Vehicles vehicle) {
        String query = "DELET FROM " + DBConst.TABLE_VEHICLES + " WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicle.getId();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createVehicle(Vehicles vehicle) {
        String query = "INSERT INTO " + DBConst.TABLE_VEHICLES +
                " (" + DBConst.VEHICLE_COLUMN_VIN + ", " +
                DBConst.VEHICLE_COLUMN_BRAND + ", " +
                DBConst.VEHICLE_COLUMN_MODEL + ", " +
                DBConst.VEHICLE_COLUMN_YEAR + ", " +
                DBConst.VEHICLE_COLUMN_KM + ", " + ") VALUES ('" +
                vehicle.getVin() + "','" +
                vehicle.getBrand() + "','" +
                vehicle.getModel() + "','" +
                vehicle.getYear() + "','" +
                vehicle.getKilometers() + "')";
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



