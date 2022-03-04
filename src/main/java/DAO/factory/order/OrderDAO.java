package DAO.factory.order;

import DAO.sql.entity.TourOrder;

import java.util.List;

public interface OrderDAO {
    TourOrder getOrder(int userId, int tourId);

    TourOrder getUserOrder(int userId, int tourId);

    boolean addOrder(TourOrder order);

    boolean changeStatus(TourOrder order);

    boolean deleteOrder(TourOrder order);

    List<TourOrder> getAllUserOrders(int userId, int offset,
                                     int noOfRecords);

    List<TourOrder> getAllOrders(int offset,
                                 int noOfRecords);

    int getCountOfUserOrders(int userId);

    int getCountOfOrders();
}
