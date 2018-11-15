package javabean;

/**
 *
 * Customers class declaration and implementation
 *
 * @author Dorian Harusha
 * @date 11.11.2018
 * @version 1.0
 *
 */

public class Customers {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String postalCode;
    private String phoneNumber;
    private String email;
    private int vehicles;

    public Customers() {

    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param postalCode
     * @param phoneNumber
     * @param email
     */
    public Customers(String firstName, String lastName, String address, String city, String postalCode, String phoneNumber, String email, int vehicles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vehicles = vehicles;
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param postalCode
     * @param phoneNumber
     * @param email
     */
    public Customers(int id, String firstName, String lastName, String address, String city, String postalCode, String phoneNumber, String email, int vehicles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vehicles = vehicles;
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public int getVehicles() {
        return vehicles;
    }

    public void setVehicles(int vehicles) {
        this.vehicles = vehicles;
    }
}

