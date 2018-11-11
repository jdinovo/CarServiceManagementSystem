package dao;

import javabean.Workorders;

import java.util.ArrayList;

/**
 *
 * WorkordersDAO interface declaration
 *
 * @author Dorian Harusha
 * @date 11.11.2018
 * @version 1.0
 *
 */

public interface WorkordersDAO {
    public ArrayList<Workorders> getAllWorkorders();
    public Workorders getWorkorder(int workorderID);
    public void updateWorkorder(Workorders workorder);
    public void deleteWorkorder(Workorders workorder);
    public void createWorkorder(Workorders workorder);
}