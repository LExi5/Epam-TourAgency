package web.servlets.tour;

import DAO.factory.DAOFactory;
import DAO.sql.entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteTour")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tour_id = Integer.parseInt(req.getParameter("tourId"));


        if (new DAOFactory().getTourDAO("jdbc").remove(tour_id)) {
            HttpSession session = req.getSession();
            List<Tour> tours = new DAOFactory().getTourDAO("jdbc").getAllTours();

            req.setAttribute("listOfTours", tours);
            req.getRequestDispatcher("/toursPage.jsp").forward(req, resp);
        }else{
            req.setAttribute("massage","Couldn't delete this tour");
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }
    }
}
