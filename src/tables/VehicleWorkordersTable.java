package tables;

import dao.VehicleWorkordersDAO;
import database.DBConst;
import database.Database;
import javabean.VehicleWorkorders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicleWorkordersTable implements VehicleWorkordersDAO {
    Database db = Database.getInstance();
    ArrayList<VehicleWorkorders> vehicleWorkorders = new ArrayList<>();

    /**
     *
     * @param query
     * @return
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
     * @return
     */
    @Override
    public ArrayList<VehicleWorkorders> getAllVehicleWorkorders() {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLE_WORKORDERS;
        vehicleWorkorders = new ArrayList<>();
        return getVehicleWorkordersDB(query);
    }

    /**
     *
     * @param vehicleID
     * @return
     */
    @Override
    public ArrayList<VehicleWorkorders> getVehicleWorkorders(int vehicleID) {
        String query = "SELECT * FROM " + DBConst.TABLE_VEHICLE_WORKORDERS + " WHERE " + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + vehicleID;
        return getVehicleWorkordersDB(query);
    }

    /**
     *
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
}
