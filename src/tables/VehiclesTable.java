package tables;

import dao.VehiclesDAO;
import database.DBConst;
import database.Database;
import javabean.Vehicles;

import java.sql.PreparedStatement;
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
    private Database db = Database.getInstance();
    private ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();
    private static int maxVehicle = 0;

//    private CustomerVehiclesTable customerVehiclesTable = new CustomerVehiclesTable();
//    private VehicleWorkordersTable vehicleWorkordersTable = new VehicleWorkordersTable();

    /**
     *
     * @param query
     * @return ArrayList
     */
    private ArrayList<Vehicles> getAllFromDB(String query) {
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
                        data.getString(DBConst.VEHICLE_COLUMN_KM),
                        data.getInt(DBConst.VEHICLE_COLUMN_DELETED)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    /**
     *
     * @return vehicles
     */
    @Override
    public ArrayList<Vehicles> getAllVehicles() {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLES;
        return getAllFromDB(query);
    }

    /**
     *
     * @return vehicles
     */
    public ArrayList<Vehicles> getAllActiveVehicles() {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLES + " WHERE " + DBConst.VEHICLE_COLUMN_DELETED + " = '0'";
        return getAllFromDB(query);
    }

    /**
     *
     * @param vehicleID
     * @return vehicle
     */
    @Override
    public Vehicles getVehicle(int vehicleID) {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLES + " WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicleID;
        Vehicles vehicle = new Vehicles();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            data.first();
            vehicle = new Vehicles(data.getInt(DBConst.VEHICLE_COLUMN_ID),
                    data.getString(DBConst.VEHICLE_COLUMN_VIN),
                    data.getString(DBConst.VEHICLE_COLUMN_BRAND),
                    data.getString(DBConst.VEHICLE_COLUMN_MODEL),
                    data.getString(DBConst.VEHICLE_COLUMN_YEAR),
                    data.getString(DBConst.VEHICLE_COLUMN_KM),
                    data.getInt(DBConst.VEHICLE_COLUMN_DELETED));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }

    /**
     *
     * @param vehicle
     */
    @Override
    public void updateVehicle(Vehicles vehicle) {
        String query = "UPDATE " + DBConst.TABLE_VEHICLES + " SET "  +
                DBConst.VEHICLE_COLUMN_VIN + " = ?, " +
                DBConst.VEHICLE_COLUMN_BRAND + " = ?, " +
                DBConst.VEHICLE_COLUMN_MODEL + " = ?, " +
                DBConst.VEHICLE_COLUMN_YEAR + " = ?, " +
                DBConst.VEHICLE_COLUMN_KM + " = ? WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicle.getId();
        try {
            PreparedStatement updateItem = db.getConnection().prepareStatement(query);
            updateItem.setString(1, vehicle.getVin());
            updateItem.setString(2, vehicle.getBrand());
            updateItem.setString(3, vehicle.getModel());
            updateItem.setString(4, vehicle.getYear());
            updateItem.setString(5, vehicle.getKilometers());
            updateItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param vehicle
     */
    @Override
    public void deleteVehicle(Vehicles vehicle) {
//        String query = "DELETE FROM " + DBConst.TABLE_VEHICLES + " WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicle.getId();
//        System.out.println(vehicle.getId());
//        vehicleWorkordersTable.getVehicleWorkorders(vehicle.getId()).forEach(e-> {
//            System.out.println("Vehicle work orders" + vehicle.getId());
//            vehicleWorkordersTable.deleteVehicleWorkorders(e);
//        });
//        System.out.println(customerVehiclesTable.getCustomerVehicles(vehicle.getId()));
//        customerVehiclesTable.getCustomerVehicles(vehicle.getId()).forEach(e-> {
//            System.out.println("Customer Vehicles" + vehicle.getId());
//            customerVehiclesTable.deleteVehicleCustomer(e);
//        });
        String query = "UPDATE " + DBConst.TABLE_VEHICLES + " SET " + DBConst.VEHICLE_COLUMN_DELETED + " = '1'" + " WHERE " + DBConst.VEHICLE_COLUMN_ID + " = " + vehicle.getId();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param vehicle
     */
    @Override
    public void createVehicle(Vehicles vehicle) {
        String query = "INSERT INTO " + DBConst.TABLE_VEHICLES +
                " (" + DBConst.VEHICLE_COLUMN_VIN + ", " +
                DBConst.VEHICLE_COLUMN_BRAND + ", " +
                DBConst.VEHICLE_COLUMN_MODEL + ", " +
                DBConst.VEHICLE_COLUMN_YEAR + ", " +
                DBConst.VEHICLE_COLUMN_KM + ", " +
                DBConst.VEHICLE_COLUMN_DELETED + ") VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement createItem = db.getConnection().prepareStatement(query);
            createItem.setString(1, vehicle.getVin());
            createItem.setString(2, vehicle.getBrand());
            createItem.setString(3, vehicle.getModel());
            createItem.setString(4, vehicle.getYear());
            createItem.setString(5, vehicle.getKilometers());
            createItem.setInt(6, vehicle.getDeleted());
            createItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author Dorian Harusha
     * @Date 11.29.2018
     * @param brand
     * @return
     */
    public int getVehiclesWorkedOnCount(String brand) {
        int count = 0;
        String query = "SELECT `brand` FROM " + DBConst.TABLE_VEHICLES + " WHERE `brand`" + " = '" + brand + "'";
        try {
            Statement getCount = db.getConnection().createStatement();
            ResultSet data = getCount.executeQuery(query);
            while(data.next()) {
                count++;
                System.out.println(count);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        if(count >= maxVehicle) {
            maxVehicle = count + 1;
        }
        return count;
    }

    /**
     *
     * @return int max number of vehicles
     */
    public static int getMaxVehicle() {
        return maxVehicle;
    }
}



