package DAO.sql.entity;

import java.util.Date;

public class Tour {

    private int id;
    private String name;
    private int lasting;
    private int countPeople = 0;
    private Hotel hotel;

    private Date startDate;
    private Date endDate;

    private String status;
    private String description;
    private int price;
    private String type;
    private int discount;
    private int step;

    public Tour() {

    }

    public Tour(String name, int lasting, int countPeople, Hotel hotel, Date startDate,
                Date endDate, String status, String description, int price,
                String type, int discount, int step) {
        this.name = name;
        this.lasting = lasting;
        this.countPeople = countPeople;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.description = description;
        this.price = price;
        this.type = type;
        this.discount = discount;
        this.step = step;
    }

    public Tour(String name, int lasting, Hotel hotel, Date startDate,
                Date endDate, String status, String description, int price,
                String type, int discount, int step) {
        this.name = name;
        this.lasting = lasting;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.description = description;
        this.price = price;
        this.type = type;
        this.discount = discount;
        this.step = step;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLasting() {
        return lasting;
    }

    public void setLasting(int lasting) {
        this.lasting = lasting;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lasting=" + lasting +
                ", hotel=" + hotel +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", discount=" + discount +
                ", step=" + step +
                '}';
    }
}
