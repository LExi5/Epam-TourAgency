package web.servlets.tour;

import DAO.factory.DAOFactory;
import DAO.sql.entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/editor")
public class EditorTourServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int lasting = Integer.parseInt(req.getParameter("lasting"));
            int hotelId = Integer.parseInt(req.getParameter("hotel"));
            String startDate = req.getParameter("startDate");
            String endDate = req.getParameter("startDate");
            String status = req.getParameter("status");
            String desc = req.getParameter("description");
            int price = Integer.parseInt(req.getParameter("price"));
            String type = req.getParameter("type");
            int discount = Integer.parseInt(req.getParameter("discount"));
            int step = Integer.parseInt(req.getParameter("step"));

            Tour tour = new Tour(name, lasting, new DAOFactory().getHotelDAO("jdbc").getHotel(hotelId),
                    getDate(startDate), getDate(endDate),
                    status, desc, price, type, discount, step);
            System.out.println("add tour");
            new DAOFactory().getTourDAO("jdbc").add(tour);
            resp.sendRedirect("tours");
        } catch (Exception e) {
            req.setAttribute("massage", e.getMessage());
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    private java.sql.Date getDate(String date) throws ParseException {
        java.util.Date utilDay = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        utilDay = (java.util.Date) df.parse(date);
        return new java.sql.Date(utilDay.getTime());
    }

}
