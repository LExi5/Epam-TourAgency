package service;

import DAO.factory.DAOFactory;
import DAO.sql.entity.Status;
import DAO.sql.entity.Tour;
import DAO.sql.entity.TourOrder;
import DAO.sql.entity.user.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static boolean addOrder(HttpServletRequest req){
        int tourId = Integer.parseInt(req.getParameter("tourId"));
        int userId;
        Date date = new Date(System.currentTimeMillis());

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        userId = user.getId();

        if(new DAOFactory().getOrderDAO("jdbc").getUserOrder(userId)==null){
            System.out.println("Order never been ordered");
            if(new DAOFactory().getOrderDAO("jdbc").addOrder(new TourOrder(userId,tourId, Status.REGISTERED, date))){
                return true;
            }
            return false;
        }else{
            System.out.println("You have already ordered this tour");
            return false;
        }
    }

}
