package web.servlets.tour;

import DAO.factory.DAOFactory;
import DAO.factory.tour.TourDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateTour")
public class UpdateTourServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tourId = Integer.parseInt(req.getParameter("tourId"));
        String status = req.getParameter("status");

        TourDAO tourDAO = new DAOFactory().getTourDAO("jdbc");
        if(tourDAO.update(tourId,status)){
            req.getRequestDispatcher("tours").forward(req, resp);
        } else {
            req.setAttribute("massage","Can not update status");
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }
}
