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

    public Workorders() {

    }

    public Workorders(int id, String date, String issue, String cause) {
        this.id = id;
        this.date = date;
        this.issue = issue;
        this.cause = cause;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
