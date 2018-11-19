package form;

import java.util.HashMap;
import java.util.Map;

/**
 * A map that will contain the customer information.
 * In a future update, this will be saved into the database
 * @author Chris Dias
 * @date 11-13-2018
 * @version 1.0
 */
public class FormAnswers {

    private Map<String, String> newCustomerMap = new HashMap<>();

    private String firstNameMap = "";
    private String lastNameMap = "";
    private String addressMap = "";
    private String cityMap = "";
    private String provinceMap = "";
    private String emailMap = "";
    private String postalCodeMap = "";
    private String phoneNumMap = "";

    //Vehicle part
    private String vinNumMap = "";
    private String brandMap = "";
    private String modelMap = "";
    private String yearMap = "";
    private String kilometersMap = "";

    //Service Part
    private String issueMap = "";

    public FormAnswers() {
        newCustomerMap.put(firstNameMap, getAddressMap());

    }

    /**
     * GETTERS && SETTERS for each parameter
     * @author Chris Dias
     *
     */
    public Map<String, String> getNewCustomerMap() {
        return newCustomerMap;
    }

    public void setNewCustomerMap(Map<String, String> newCustomerMap) {
        this.newCustomerMap = newCustomerMap;
    }

    public String getFirstNameMap() {
        return firstNameMap;
    }

    public void setFirstNameMap(String firstNameMap) {
        this.firstNameMap = firstNameMap;
    }

    public String getLastNameMap() {
        return lastNameMap;
    }

    public void setLastNameMap(String lastNameMap) {
        this.lastNameMap = lastNameMap;
    }

    public String getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(String addressMap) {
        this.addressMap = addressMap;
    }

    public String getCityMap() {
        return cityMap;
    }

    public void setCityMap(String cityMap) {
        this.cityMap = cityMap;
    }

    public String getProvinceMap() {
        return provinceMap;
    }

    public void setProvinceMap(String provinceMap) {
        this.provinceMap = provinceMap;
    }

    public String getEmailMap() {
        return emailMap;
    }

    public void setEmailMap(String emailMap) {
        this.emailMap = emailMap;
    }

    public String getPostalCodeMap() {
        return postalCodeMap;
    }

    public void setPostalCodeMap(String postalCodeMap) {
        this.postalCodeMap = postalCodeMap;
    }

    public String getPhoneNumMap() {
        return phoneNumMap;
    }

    public void setPhoneNumMap(String phoneNumMap) {
        this.phoneNumMap = phoneNumMap;
    }

    public String getVinNumMap() {
        return vinNumMap;
    }

    public void setVinNumMap(String vinNumMap) {
        this.vinNumMap = vinNumMap;
    }

    public String getBrandMap() {
        return brandMap;
    }

    public void setBrandMap(String brandMap) {
        this.brandMap = brandMap;
    }

    public String getModelMap() {
        return modelMap;
    }

    public void setModelMap(String modelMap) {
        this.modelMap = modelMap;
    }

    public String getYearMap() {
        return yearMap;
    }

    public void setYearMap(String yearMap) {
        this.yearMap = yearMap;
    }

    public String getKilometersMap() {
        return kilometersMap;
    }

    public void setKilometersMap(String kilometersMap) {
        this.kilometersMap = kilometersMap;
    }

    public String getIssueMap() {
        return issueMap;
    }

    public void setIssueMap(String issueMap) {
        this.issueMap = issueMap;
    }

    @Override
    public String toString() {
        return "FormAnswers{" +
                "newCustomerMap=" + newCustomerMap +
                ", firstNameMap='" + firstNameMap + '\'' +
                ", lastNameMap='" + lastNameMap + '\'' +
                ", addressMap='" + addressMap + '\'' +
                ", cityMap='" + cityMap + '\'' +
                ", provinceMap='" + provinceMap + '\'' +
                ", emailMap='" + emailMap + '\'' +
                ", postalCodeMap='" + postalCodeMap + '\'' +
                ", phoneNumMap='" + phoneNumMap + '\'' +
                ", vinNumMap='" + vinNumMap + '\'' +
                ", brandMap='" + brandMap + '\'' +
                ", modelMap='" + modelMap + '\'' +
                ", yearMap='" + yearMap + '\'' +
                ", kilometersMap='" + kilometersMap + '\'' +
                ", issueMap='" + issueMap + '\'' +
                '}';
    }
}
