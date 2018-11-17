package javabean;

public class CustomerVehicles {
    private int customerid;
    private int vehicleid;

    public CustomerVehicles() {

    }

    public CustomerVehicles(int customerid, int vehicleid) {
        this.customerid = customerid;
        this.vehicleid = vehicleid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }
}
