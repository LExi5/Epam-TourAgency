package service;

import DAO.factory.DAOFactory;
import DAO.sql.entity.Status;
import DAO.sql.entity.TourOrder;
import DAO.sql.entity.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;


public class OrderService {

    public static boolean addOrder(HttpServletRequest req) {
        int tourId = Integer.parseInt(req.getParameter("tourId"));
        int userId;
        Date date = new Date(System.currentTimeMillis());

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        userId = user.getId();
        TourOrder order = new DAOFactory().getOrderDAO("jdbc").getUserOrder(userId, tourId);
        if (order == null) {
            if (new DAOFactory().getOrderDAO("jdbc").addOrder(new TourOrder(userId, tourId, Status.REGISTERED, date))) {
                new DAOFactory().getTourDAO("jdbc").increment(tourId);
                return true;
            }
        }
        return false;
    }

    public static boolean changeStatus(HttpServletRequest req) {
        int tourId = Integer.parseInt(req.getParameter("tourId"));
        int userId = Integer.parseInt(req.getParameter("userId"));

        String status = req.getParameter("status");

        TourOrder order = new TourOrder();
        order.setUserId(userId);
        order.setTourId(tourId);
        order.setStatus(Status.valueOf(status));

        if (new DAOFactory().getOrderDAO("jdbc").changeStatus(order)) {
            return true;
        }
        return false;
    }

}
