package Project_7;

import java.util.Scanner;

public abstract class Subscription {
    private String startDate;
    private String endDate;
    private String status;

    public Subscription(String startDate, String endDate, String status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Subscription() {

    }
    protected abstract void create(DataBase database, Scanner read);{
        System.out.print("");
    }
    protected abstract void update(DataBase database, Scanner read);{
        System.out.print("");
    }
    protected abstract void cancel(DataBase database, Scanner read);{
        System.out.print("");
    }
    protected abstract void status(DataBase database, Scanner read);

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}