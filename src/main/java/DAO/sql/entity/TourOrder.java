package DAO.sql.entity;

import DAO.sql.entity.user.User;

import java.sql.Date;

public class TourOrder {

    private int id;
    private int userId;
    private int tourId;
    private Status status;
    private Date registrationDate;
    private Tour tour;

    public TourOrder(int id,int userId, int tourId, Status status, Date registrationDate) {
        this.id = id;
        this.userId = userId;
        this.tourId = tourId;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public TourOrder(int userId, int tourId, Status status, Date registrationDate) {
        this.userId = userId;
        this.tourId = tourId;
        this.status = status;
        this.registrationDate = registrationDate;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public TourOrder(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TourOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", tourId=" + tourId +
                ", status=" + status +
                ", registrationDate=" + registrationDate +
                ", tour=" + tour +
                '}';
    }
}
