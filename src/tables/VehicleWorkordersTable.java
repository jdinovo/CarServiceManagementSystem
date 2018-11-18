package tables;

import dao.VehicleWorkordersDAO;
import database.DBConst;
import database.Database;
import javabean.VehicleWorkorders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * Represents vehicle workorder table
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public class VehicleWorkordersTable implements VehicleWorkordersDAO {
    Database db = Database.getInstance();
    ArrayList<VehicleWorkorders> vehicleWorkorders = new ArrayList<>();

    /**
     *
     *
     * @author James DiNovo
     * @date 18.11.2018
     * @version 1.0
     * @param query
     * @return ArrayList of workorders
     *
     */
    private ArrayList<VehicleWorkorders> getVehicleWorkordersDB(String query) {
        vehicleWorkorders = new ArrayList<>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                vehicleWorkorders.add(new VehicleWorkorders(data.getInt(DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID), data.getInt(DBConst.VEHICLE_WORKORDERS_COLUMN_WORKORDER_ID)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return vehicleWorkorders;
    }

    /**
     *
     *
     * @author James DiNovo
     * @date 18.11.2018
     * @version 1.0
     * @return ArrayList of workorders
     *
     */
    @Override
    public ArrayList<VehicleWorkorders> getAllVehicleWorkorders() {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLE_WORKORDERS;
        vehicleWorkorders = new ArrayList<>();
        return getVehicleWorkordersDB(query);
    }

    /**
     *
     * @author James DiNovo
     * @date 18.11.2018
     * @version 1.0
     * @param vehicleID the id of the vehicle you want to retrieve
     * @return ArrayList of workorders
     */
    @Override
    public ArrayList<VehicleWorkorders> getVehicleWorkorders(int vehicleID) {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLE_WORKORDERS + " WHERE " + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + vehicleID;
        return getVehicleWorkordersDB(query);
    }

    /**
     * @author James DiNovo
     * @date 18.11.2018
     * @version 1.0
     * @param vehicleWorkorder
     */
    @Override
    public void createVehicleWorkorder(VehicleWorkorders vehicleWorkorder) {
        String query = "INSERT INTO " + DBConst.TABLE_VEHICLE_WORKORDERS +
                " (" + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID+ ", " +
                DBConst.VEHICLE_WORKORDERS_COLUMN_WORKORDER_ID + ") VALUES ('" +
                vehicleWorkorder.getVehicleID() + "','" +
                vehicleWorkorder.getWorkorderID() + "')";
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author James DiNovo
     * @date 17.11.2018
     * @version 1.0
     * @param vehicleWorkorder
     */
    @Override
    public void updateVehicleWorkorders(VehicleWorkorders vehicleWorkorder) {
        String query = "UPDATE " + DBConst.TABLE_VEHICLE_WORKORDERS + " SET "  +
                DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + vehicleWorkorder.getVehicleID() + ", " +
                DBConst.VEHICLE_WORKORDERS_COLUMN_WORKORDER_ID + " = " + vehicleWorkorder.getWorkorderID() + ", " +
                " WHERE " + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + vehicleWorkorder.getVehicleID() + " AND " + DBConst.VEHICLE_WORKORDERS_COLUMN_WORKORDER_ID + " = " + vehicleWorkorder.getWorkorderID();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * deletes workorder from DB
     *
     * @author James DiNovo
     * @date 17.11.2018
     * @version 1.0
     * @param vehicleWorkorder
     */
    @Override
    public void deleteVehicleWorkorders(VehicleWorkorders vehicleWorkorder) {
        String query = "DELETE FROM " + DBConst.TABLE_VEHICLE_WORKORDERS + " WHERE " + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + vehicleWorkorder.getVehicleID();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
