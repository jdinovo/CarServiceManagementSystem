package javabean;

/**
 *
 * Represents vehicle workorder object from DB
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public class VehicleWorkorders {
    private int vehicleID;
    private int workorderID;

    /**
     * empty constructor
     */
    public VehicleWorkorders() {

    }

    /**
     * overloaded constructor
     *
     * @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @param vehicleID
     * @param workorderID
     */
    public VehicleWorkorders(int vehicleID, int workorderID) {
        this.vehicleID = vehicleID;
        this.workorderID = workorderID;
    }

    /**
     *
     * gets vehicle id
     *
     *  @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @return int
     */
    public int getVehicleID() {
        return vehicleID;
    }

    /**
     *
     * sets vehicle id
     *
     * @author James DiNovo
     * @date 17.11.2018
     * @version 1.0
     * @param vehicleID
     *
     */
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    /**
     *
     * returns workorder id
     *
     *  @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @return int
     */
    public int getWorkorderID() {
        return workorderID;
    }

    /**
     *
     * sets workorder id
     *
     * @author James DiNovo
     * @date 17.11.2018
     * @version 1.0
     * @param workorderID
     *
     */
    public void setWorkorderID(int workorderID) {
        this.workorderID = workorderID;
    }
}
