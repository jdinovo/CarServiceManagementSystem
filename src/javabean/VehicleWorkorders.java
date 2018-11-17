package javabean;

public class VehicleWorkorders {
    private int vehicleID;
    private int workorderID;

    public VehicleWorkorders() {

    }

    public VehicleWorkorders(int vehicleID, int workorderID) {
        this.vehicleID = vehicleID;
        this.workorderID = workorderID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getWorkorderID() {
        return workorderID;
    }

    public void setWorkorderID(int workorderID) {
        this.workorderID = workorderID;
    }
}
