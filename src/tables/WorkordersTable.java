package tables;

import dao.WorkordersDAO;
import database.DBConst;
import database.Database;
import javabean.Workorders;

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

public class WorkordersTable implements WorkordersDAO {
    Database db = Database.getInstance();
    ArrayList<Workorders> workorders = new ArrayList<Workorders>();

    private static int maxWork = 0;


    /**
     *
     * @return workorders
     */
    @Override
    public ArrayList<Workorders> getAllWorkorders() {
        String query = "SELECT * FROM " + DBConst.TABLE_WORKORDERS;
        workorders = new ArrayList<Workorders>();
        try {
            Statement getItems = db.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                workorders.add(new Workorders(data.getInt(DBConst.WORKORDERS_COLUMN_ID),
                        data.getString(DBConst.WORKORDERS_COLUMN_DATE),
                        data.getString(DBConst.WORKORDERS_COLUMN_ISSUE),
                        data.getString(DBConst.WORKORDERS_COLUMN_CAUSE),
                        data.getString(DBConst.WORKORDERS_COLUMN_CORRECTION),
                        data.getInt(DBConst.WORKORDERS_COLUMN_CLOSED)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return workorders;
    }

    /**
     *
     * @param workorderID
     * @return workorder
     */
    @Override
    public Workorders getWorkorder(int workorderID) {
        String query = "SELECT * FROM " + DBConst.TABLE_WORKORDERS + " WHERE " + DBConst.WORKORDERS_COLUMN_ID + " = " + workorderID;
        Workorders workorder = new Workorders();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            if(data.next()) {
                workorder = new Workorders(data.getInt(DBConst.WORKORDERS_COLUMN_ID),
                        data.getString(DBConst.WORKORDERS_COLUMN_DATE),
                        data.getString(DBConst.WORKORDERS_COLUMN_ISSUE),
                        data.getString(DBConst.WORKORDERS_COLUMN_CAUSE),
                        data.getString(DBConst.WORKORDERS_COLUMN_CORRECTION),
                        data.getInt(DBConst.WORKORDERS_COLUMN_CLOSED));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workorder;
    }

    /**
     *
     * @param workorder
     */
    @Override
    public void updateWorkorder(Workorders workorder) {
        String query = "UPDATE " + DBConst.TABLE_WORKORDERS + " SET "  +
                DBConst.WORKORDERS_COLUMN_DATE + " = ?, " +
                DBConst.WORKORDERS_COLUMN_ISSUE + " = ?, " +
                DBConst.WORKORDERS_COLUMN_CAUSE+ " = ?, " +
                DBConst.WORKORDERS_COLUMN_CORRECTION + " = ?, " +
                DBConst.WORKORDERS_COLUMN_CLOSED + " = ? WHERE " + DBConst.WORKORDERS_COLUMN_ID + " = " + workorder.getId();
        try {
            PreparedStatement updateItem = db.getConnection().prepareStatement(query);
            updateItem.setString(1, workorder.getDate());
            updateItem.setString(2, workorder.getIssue());
            updateItem.setString(3, workorder.getCause());
            updateItem.setString(4, workorder.getCorrection());
            updateItem.setInt(5, workorder.getClosed());
            updateItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param workorder
     */
    @Override
    public void deleteWorkorder(Workorders workorder) {
        String query = "DELETE FROM " + DBConst.TABLE_WORKORDERS + " WHERE " + DBConst.WORKORDERS_COLUMN_ID + " = " + workorder.getId();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param workorder
     */
    @Override
    public void createWorkorder(Workorders workorder) {
        String query = "INSERT INTO " + DBConst.TABLE_WORKORDERS +
                " (" + DBConst.WORKORDERS_COLUMN_DATE + ", " +
                DBConst.WORKORDERS_COLUMN_ISSUE + ", " +
                DBConst.WORKORDERS_COLUMN_CAUSE + ", " +
                DBConst.WORKORDERS_COLUMN_CORRECTION + ", " +
                DBConst.WORKORDERS_COLUMN_CLOSED + ") VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement createItem = db.getConnection().prepareStatement(query);
            createItem.setString(1, workorder.getDate());
            createItem.setString(2, workorder.getIssue());
            createItem.setString(3, workorder.getCause());
            createItem.setString(4, workorder.getCorrection());
            createItem.setInt(5, workorder.getClosed());
            createItem.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author Dorian Harusha
     * @Date 11.29.2018
     * @return number of closed workeorders
     */
    public int getClosedWorkordersCount() {
        String query = "SELECT " + DBConst.TABLE_WORKORDERS + ".* FROM " + DBConst.TABLE_WORKORDERS + ", " + DBConst.TABLE_VEHICLES + ", " + DBConst.TABLE_VEHICLE_WORKORDERS + " WHERE "
                + DBConst.TABLE_VEHICLE_WORKORDERS + "." + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + DBConst.TABLE_VEHICLES + "." + DBConst.VEHICLE_COLUMN_ID + " AND " +
                DBConst.TABLE_VEHICLE_WORKORDERS + "." + DBConst.VEHICLE_WORKORDERS_COLUMN_WORKORDER_ID + " = " + DBConst.TABLE_WORKORDERS + "." + DBConst.WORKORDERS_COLUMN_ID + " AND " +
                DBConst.TABLE_WORKORDERS + "." + DBConst.WORKORDERS_COLUMN_CLOSED + " = 1 AND " + DBConst.TABLE_VEHICLES + "." + DBConst.VEHICLE_COLUMN_DELETED + " = 0";

        return countResults(query);
    }

    /**
     * @Author Dorian Harusha
     * @Date 11.29.2018
     * @return number of open workorders
     */
    public int getOpenWorkordersCount() {
        String query = "SELECT " + DBConst.TABLE_WORKORDERS + ".* FROM " + DBConst.TABLE_WORKORDERS + ", " + DBConst.TABLE_VEHICLES + ", " + DBConst.TABLE_VEHICLE_WORKORDERS + " WHERE "
                + DBConst.TABLE_VEHICLE_WORKORDERS + "." + DBConst.VEHICLE_WORKORDERS_COLUMN_VEHICLE_ID + " = " + DBConst.TABLE_VEHICLES + "." + DBConst.VEHICLE_COLUMN_ID + " AND " +
                DBConst.TABLE_VEHICLE_WORKORDERS + "." + DBConst.VEHICLE_WORKORDERS_COLUMN_WORKORDER_ID + " = " + DBConst.TABLE_WORKORDERS + "." + DBConst.WORKORDERS_COLUMN_ID + " AND " +
                DBConst.TABLE_WORKORDERS + "." + DBConst.WORKORDERS_COLUMN_CLOSED + " = 0 AND " + DBConst.TABLE_VEHICLES + "." + DBConst.VEHICLE_COLUMN_DELETED + " = 0";
        return countResults(query);
    }

    /**
     *
     * gets number of work orders in specified month and year
     *
     * @Author James DiNovo
     * @Date 02.12.2018
     * @return int
     */
    public int getMonthWorkorders(int month, int year) {
        String query = "SELECT * FROM " + DBConst.TABLE_WORKORDERS + " WHERE YEAR(" + DBConst.WORKORDERS_COLUMN_DATE + ") = " + year + " AND MONTH(" + DBConst.WORKORDERS_COLUMN_DATE + ") = " + month;
        int count = countResults(query);

        if(count >= maxWork) {
            maxWork = count + 1;
        }
        return count;
    }

    /**
     * Returns number of results found
     *
     * @author James DiNovo
     * @date 02.12.2018
     * @param query
     * @return int number of results
     */
    private int countResults(String query) {
        int count = 0;
        try {
            Statement getCount = db.getConnection().createStatement();
            ResultSet data = getCount.executeQuery(query);
            while(data.next()) {
                count++;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    /**
     * @author James DiNovo
     * @date 02.12.2018
     * @return int
     */
    public static int getMaxWork() {
        return maxWork;
    }
}

