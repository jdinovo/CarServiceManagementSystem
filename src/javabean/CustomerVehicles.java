package javabean;

/**
 *
 * Represents CustomerVehicle object from DB
 *
 * @author James DiNovo
 * @date 17.11.2018
 * @version 1.0
 *
 */
public class CustomerVehicles {
    private int customerid;
    private int vehicleid;

    /**
     * empty constructor
     */
    public CustomerVehicles() {

    }

    /**
     * overloaded constructor
     *
     * @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @param customerid
     * @param vehicleid
     */
    public CustomerVehicles(int customerid, int vehicleid) {
        this.customerid = customerid;
        this.vehicleid = vehicleid;
    }

    /**
     *
     * gets customer id
     *
     *  @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @return int
     */
    public int getCustomerid() {
        return customerid;
    }

    /**
     *
     * sets customer id
     *
     *  @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @param customerid
     */
    public void setCustomerid(int customerid) {
        this.customerid = customerid;
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
    public int getVehicleid() {
        return vehicleid;
    }

    /**
     *
     * sets vehicle id
     *
     *  @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @param vehicleid
     */
    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }
}
