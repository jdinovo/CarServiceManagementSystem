package javabean;

/**
 *
 * Workorders class declaration and implementation
 *
 * @author Dorian Harusha
 * @date 11.11.2018
 * @version 1.0
 *
 */

public class Workorders {
    private int id;
    private String date;
    private String issue;
    private String cause;
    private String correction;

    public Workorders() {

    }

    /**
     * @param date
     * @param issue
     * @param cause
     */
    public Workorders(String date, String issue) {
        this.date = date;
        this.issue = issue;
        this.cause = "";
        this.correction = "";
    }

    /**
     *
     * @param id
     * @param date
     * @param issue
     * @param cause
     */
    public Workorders(int id, String date, String issue, String cause, String correction) {
        this.id = id;
        this.date = date;
        this.issue = issue;
        this.cause = cause;
        this.correction = correction;
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
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     *
     * @return issue
     */
    public String getIssue() {
        return issue;
    }

    /**
     *
     * @param issue
     */
    public void setIssue(String issue) {
        this.issue = issue;
    }

    /**
     *
     * @return cause
     */
    public String getCause() {
        return cause;
    }

    /**
     *
     * @param cause
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     *
     * @return correction
     */
    public String getCorrection() {
        return correction;
    }

    /**
     *
     * @param correction
     */
    public void setCorrection(String correction) {
        this.correction = correction;
    }
}
