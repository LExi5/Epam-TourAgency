package web.servlets.menu;

import DAO.factory.DAOFactory;
import DAO.sql.entity.Hotel;
import DAO.sql.entity.Location;
import DAO.sql.entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/tours")
public class ToursServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Tour> tours = new DAOFactory().getTourDAO("jdbc").getAllTours();
        List<Hotel> hotels = new DAOFactory().getHotelDAO("jdbc").getHotels();
        session.setAttribute("listOfTours", tours);
        session.setAttribute("listOfHotels", hotels);
        req.getRequestDispatcher("/toursPage.jsp").forward(req,resp);
    }
}
