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
    ArrayList<Workorders> getAllWorkorders();
    Workorders getWorkorder(int workorderID);
    void updateWorkorder(Workorders workorder);
    void deleteWorkorder(Workorders workorder);
    void createWorkorder(Workorders workorder);
}