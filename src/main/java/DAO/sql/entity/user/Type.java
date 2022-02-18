package DAO.sql.entity.user;

public enum Type {
    USER("user"),MANAGER("manager"),ADMIN("admin");
    String s;

    Type(String s) {
        this.s = s;
    }
}
