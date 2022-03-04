package web.servlets.menu;

import DAO.factory.DAOFactory;
import DAO.factory.tour.TourDAO;
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
        int page = 1;
        int recordsPerPage = 3;

        TourDAO tourDAO = new DAOFactory().getTourDAO("jdbc");

        if (req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));

        List<Tour> tours = tourDAO.getAllTours((page - 1) * recordsPerPage,
                recordsPerPage);
        List<Hotel> hotels = new DAOFactory().getHotelDAO("jdbc").getHotels();

        int noOfRecords = tourDAO.getCountOfTours();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        session.setAttribute("listOfTours", tours);
        session.setAttribute("listOfHotels", hotels);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);
        req.getRequestDispatcher("/toursPage.jsp").forward(req, resp);
    }
}
