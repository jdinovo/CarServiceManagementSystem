package tables;

import dao.WorkordersDAO;
import database.DBConst;
import database.Database;
import javabean.Workorders;
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
                        data.getString(DBConst.WORKORDERS_COLUMN_CAUSE)));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return workorders;
    }

    @Override
    public Workorders getWorkorder(int workorderID) {
        String query = "SELECT * FROM " + DBConst.TABLE_WORKORDERS + " WHERE " + DBConst.WORKORDERS_COLUMN_ID + " = " + workorderID;
        Workorders workorder = new Workorders();
        try {
            Statement getItem = db.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            workorder = new Workorders(data.getInt(DBConst.WORKORDERS_COLUMN_ID),
                    data.getString(DBConst.WORKORDERS_COLUMN_DATE),
                    data.getString(DBConst.WORKORDERS_COLUMN_ISSUE),
                    data.getString(DBConst.WORKORDERS_COLUMN_CAUSE));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workorder;
    }

    @Override
    public void updateWorkorder(Workorders workorder) {
        String query = "UPDATE " + DBConst.TABLE_WORKORDERS + " SET "  +
                DBConst.WORKORDERS_COLUMN_DATE + " " + workorder.getDate() + ", " +
                DBConst.WORKORDERS_COLUMN_ISSUE + " " + workorder.getIssue() + ", " +
                DBConst.WORKORDERS_COLUMN_CAUSE+ " " + workorder.getCause() +
                " WHERE " + DBConst.WORKORDERS_COLUMN_ID + " = " + workorder.getId();
        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteWorkorder(Workorders workorder) {
        String query = "DELET FROM " + DBConst.TABLE_WORKORDERS + " WHERE " + DBConst.WORKORDERS_COLUMN_ID + " = " + workorder.getId();
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createWorkorder(Workorders workorder) {
        String query = "INSERT INTO " + DBConst.TABLE_WORKORDERS +
                " (" + DBConst.WORKORDERS_COLUMN_DATE + ", " +
                DBConst.WORKORDERS_COLUMN_ISSUE + ", " +
                DBConst.WORKORDERS_COLUMN_CAUSE + ") VALUES ('" +
                workorder.getDate() + "','" +
                workorder.getIssue() + "','" +
                workorder.getCause() + "')";
        try {
            db.getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

