package DAO.factory;

import DAO.factory.hotel.HotelDAO;
import DAO.factory.hotel.HotelDAOImpl;
import DAO.factory.order.OrderDAO;
import DAO.factory.order.OrderDAOImpl;
import DAO.factory.tour.TourDAO;
import DAO.factory.tour.TourDAOImpl;
import DAO.factory.user.UserDAO;
import DAO.factory.user.UserDAOImpl;

public class DAOFactory {

    public static UserDAO getUserDAO(String type) {
        if (type.equalsIgnoreCase("jdbc")) {
            return new UserDAOImpl();
        } else {
            return new UserDAOImpl();
        }
    }

    public static TourDAO getTourDAO(String type) {
        if (type.equalsIgnoreCase("jdbc")) {
            return new TourDAOImpl();
        } else {
            return new TourDAOImpl();
        }
    }

    public static OrderDAO getOrderDAO(String type) {
        if (type.equalsIgnoreCase("jdbc")) {
            return new OrderDAOImpl();
        } else {
            return new OrderDAOImpl();
        }
    }

    public static HotelDAO getHotelDAO(String type) {
        if (type.equalsIgnoreCase("jdbc")) {
            return new HotelDAOImpl();
        } else {
            return new HotelDAOImpl();
        }
    }

}
