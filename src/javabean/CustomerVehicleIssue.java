package javabean;

public class CustomerVehicleIssue {

    private String firstName;
    private String lastName;
    private String brand;
    private String model;
    private int workOrderId;
    private String issue;
    private int closed = 0;

    public CustomerVehicleIssue() {

    }

    /**
     * overloaded constructor
     *
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     * @param firstName
     * @param lastName
     * @param brand
     * @param model
     * @param workOrderId
     * @param issue
     */
    public CustomerVehicleIssue(String firstName, String lastName, String brand, String model, int workOrderId, String issue, int closed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.brand = brand;
        this.model = model;
        this.workOrderId = workOrderId;
        this.issue = issue;
        this.closed = closed;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @return issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     * @author Chris Dias
     *  @date 11/24/2018
     *  @version 1.0
     *
     * @param issue
     */
    public void setIssue(String issue) {
        this.issue = issue;
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
    public int getWorkOrderId() {
        return workOrderId;
    }

    /**
     *
     * sets customer id
     *
     *  @author James DiNovo
     *  @date 17.11.2018
     *  @version 1.0
     * @param workOrderId
     */
    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    /**
     * @return closed
     */
    public int getClosed() {
        return closed;
    }

    /**
     * @param closed
     */
    public void setClosed(int closed) {
        this.closed = closed;
    }
}
