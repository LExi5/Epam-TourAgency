package DAO.sql.entity;

public enum Status {
    PAYED("Payed"), REGISTERED("Registered"), CANCELLED("Cancelled");
    String s;

    Status(String s) {
        this.s = s;
    }

    public String getText(){
        return this.s;
    }
}
